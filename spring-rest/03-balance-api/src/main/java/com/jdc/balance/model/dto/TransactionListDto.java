package com.jdc.balance.model.dto;

import java.time.LocalDate;

import com.jdc.balance.model.entity.Transaction;

public record TransactionListDto(
		long id,
		LedgerDto ledger,
		LocalDate issueDate,
		String issueUser,
		long itemCount,
		long total
		) {

	public static TransactionListDto from(Transaction entity) {
		return new TransactionListDto(
				entity.getId(), 
				LedgerDto.from(entity.getLedger()), 
				entity.getIssueDate(), 
				entity.getIssueUser(), 
				entity.getItems().size(), 
				entity.getItems().stream().mapToInt(a -> a.getQuantity() * a.getUnitPrice()).sum());
	}
}
