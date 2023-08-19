package com.jdc.balance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.balance.model.dto.MemberDetailsDto;
import com.jdc.balance.model.dto.MemberListDto;
import com.jdc.balance.model.dto.response.PageResult;
import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;
import com.jdc.balance.model.form.MemberForm;
import com.jdc.balance.model.form.MemberStatusForm;
import com.jdc.balance.model.repo.MemberRepo;
import com.jdc.balance.utils.exceptions.BalanceBusinessException;

@Service
@Transactional(rollbackFor = BalanceBusinessException.class)
@PreAuthorize("hasAuthority('Admin')")
public class MemberService {
	
	@Autowired
	private MemberRepo repo;
	
	@Autowired
	private LedgerService ledgerService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AccessLogService accessLogService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public MemberDetailsDto findById(int id) {
		return repo.findById(id).map(member -> 
			MemberDetailsDto.from(member)
					.lastAccessTime(accessLogService.findLastAccess(member.getEmail()))
					.transactions(transactionService.findCountByMemberId(member.getId()))
					.ledgers(ledgerService.findCountByMemberId(member.getId())))
		.orElseThrow(() -> new BalanceBusinessException("There is no member with id %d.".formatted(id)));
	}

	public int create(MemberForm form) {
		return repo.save(form.entity(passwordEncoder::encode)).getId();
	}

	public int update(int id, MemberForm form) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new BalanceBusinessException("There is no member with id %d.".formatted(id)));
		
		
		if(!entity.getEmail().equals(form.email())) {
			if(repo.countByEmail(form.email()) > 0) {
				throw new BalanceBusinessException("Your email already has been used by other member.");
			}
			
			entity.setEmail(form.email());
		}
		
		entity.setName(form.email());
		entity.setPhone(form.phone());
		
		return id;
	}

	public int updateStatus(int id, MemberStatusForm form) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new BalanceBusinessException("There is no member with id %d.".formatted(id)));
		entity.setStatus(form.status());
		return id;
	}

	@Transactional(readOnly = true)
	public PageResult<MemberListDto> search(Optional<MemberRole> role, Optional<MemberStatus> status, String keyword, int page,
			int pageSize) {
		
		var pageParam = PageRequest.of(page, pageSize);
		var result = repo.findAll(
				role(role).and(status(status)).and(name(keyword)), 
				pageParam);
		
		return PageResult.of(result.map(MemberListDto::from));
	}
	
	private Specification<Member> role(Optional<MemberRole> param) {
		if(param.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("role"), param.get());
	}

	private Specification<Member> status(Optional<MemberStatus> param) {
		if(param.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("status"), param.get());
	}
	
	private Specification<Member> name(String param) {
		if(!StringUtils.hasLength(param)) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.like(cb.lower(root.get("name")), param.toLowerCase().concat("%"));
	}

}
