package com.jdc.balance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.balance.model.dto.LedgerDto;
import com.jdc.balance.model.entity.Ledger;
import com.jdc.balance.model.enums.LedgerType;
import com.jdc.balance.model.form.LedgerForm;
import com.jdc.balance.model.repo.LedgerRepo;
import com.jdc.balance.utils.exceptions.BalanceBusinessException;

@Service
@Transactional
@PreAuthorize("hasAuthority('Member')")
public class LedgerService {
	
	@Autowired
	private LedgerRepo repo;
	
	@Autowired
	private LoginUserService loginUserService;

	public int create(LedgerForm form) {
		
		var user = loginUserService.getLoginUser();
		var entity = form.entity(user);
		entity = repo.save(entity);
		
		return entity.getId();
	}

	public int update(int id, LedgerForm form) {
		
		var entity = repo.findById(id)
				.orElseThrow(() -> new BalanceBusinessException("There is no ledger with id %d.".formatted(id)));
		
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!entity.getOwner().getEmail().equals(username)) {
			throw new BalanceBusinessException("You can't update ledger as you are not owner of this ledger.");
		}
		
		entity.setType(form.type());
		entity.setName(form.name());
		
		return entity.getId();
	}

	@Transactional(readOnly = true)
	public List<LedgerDto> search(Optional<LedgerType> type, String keyword) {
		return repo.findAll(owner().and(type(type)).and(keyword(keyword))).stream().map(LedgerDto::from).toList();
	}
	
	private Specification<Ledger> owner() {
		return (root, query, cb) -> cb.equal(root.get("owner").get("id"), loginUserService.getLoginUser().getId());
	}
	
	private Specification<Ledger> type(Optional<LedgerType> data) {
		
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return Specification.where((root, query, cb) -> 
				cb.equal(root.get("type"), data.get()));
	}

	private Specification<Ledger> keyword(String data) {
		
		if(!StringUtils.hasLength(data)) {
			return Specification.where(null);
		}
		
		return Specification.where((root, query, cb) -> 
				cb.like(cb.lower(root.get("name")), data.toLowerCase().concat("%")));
	}

	public Long findCountByMemberId(int id) {
		return repo.countByOwnerId(id);
	}
}
