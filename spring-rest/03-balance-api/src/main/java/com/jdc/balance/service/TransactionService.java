package com.jdc.balance.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.balance.model.dto.TransactionDetailsDto;
import com.jdc.balance.model.dto.TransactionListDto;
import com.jdc.balance.model.dto.response.PageResult;
import com.jdc.balance.model.entity.Transaction;
import com.jdc.balance.model.enums.LedgerType;
import com.jdc.balance.model.form.TransactionForm;
import com.jdc.balance.model.repo.LedgerRepo;
import com.jdc.balance.model.repo.TransactionRepo;
import com.jdc.balance.utils.exceptions.BalanceBusinessException;

@Service
@Transactional(readOnly = true)
@PreAuthorize("hasAuthority('Member')")
public class TransactionService {
	
	@Autowired
	private TransactionRepo repo;
	@Autowired
	private LoginUserService loginUserService;
	@Autowired
	private LedgerRepo ledgerRepo;

	@Transactional(rollbackFor = BalanceBusinessException.class)
	public Long create(TransactionForm form) {
		
		var owner = loginUserService.getLoginUser();
		var transaction = form.entity(owner);
		
		transaction.setItems(form.items().stream().map(a -> a.entity(transaction)).toList());
		
		var savedTransaction = repo.save(transaction);
		
		return savedTransaction.getId();
	}

	@Transactional(rollbackFor = BalanceBusinessException.class)
	public Long update(long id, TransactionForm form) {
		var transaction = repo.findById(id)
				.orElseThrow(() -> new BalanceBusinessException("There is no transaction with id %d.".formatted(id)));
		
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!transaction.getOwner().getEmail().equals(username)) {
			throw new BalanceBusinessException("You can't update ledger as you are not owner of this ledger.");
		}
		
		transaction.setIssueUser(form.userName());
		transaction.setIssueDate(form.issueDate());
		transaction.setLedger(ledgerRepo.findById(form.ledgerId())
				.orElseThrow(() -> new BalanceBusinessException("There is no ledger with id %d.".formatted(form.ledgerId()))));
		
		transaction.setItems(form.items().stream().map(a -> a.entity(transaction)).toList());;
		
		return transaction.getId();
	}

	public TransactionDetailsDto findById(long id) {
		return repo.findById(id).map(TransactionDetailsDto::from)
				.orElseThrow(() -> new BalanceBusinessException("There is no transaction with id %d.".formatted(id)));
	}

	public PageResult<TransactionListDto> search(Optional<LedgerType> type, Optional<LocalDate> from, Optional<LocalDate> to, String keyword,
			int page, int pageSize) {
		
		var pageParam = PageRequest.of(page, pageSize);
		var result = repo.findAll(
				type(type).and(from(from)).and(to(to)).and(keyword(keyword)), 
				pageParam);
		return PageResult.of(result.map(TransactionListDto::from));
	}
	
	private Specification<Transaction> type(Optional<LedgerType> type) {
		if(type.isEmpty()) {
			return Specification.where(null);
		}
		return (root, query, cb) -> cb.equal(root.get("ledger").get("type"), type.get());
	}

	private Specification<Transaction> from(Optional<LocalDate> type) {
		if(type.isEmpty()) {
			return Specification.where(null);
		}
		return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("issueDate"), type.get());
	}

	private Specification<Transaction> to(Optional<LocalDate> type) {
		if(type.isEmpty()) {
			return Specification.where(null);
		}
		return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("issueDate"), type.get());
	}
	
	private Specification<Transaction> keyword(String type) {
		if(!StringUtils.hasLength(type)) {
			return Specification.where(null);
		}
		return (root, query, cb) -> cb.like(cb.lower(root.get("issueUser")), type.toLowerCase().concat("%"));
	}

	public Long findCountByMemberId(int id) {
		return repo.countByOwnerId(id);
	}
	
}
