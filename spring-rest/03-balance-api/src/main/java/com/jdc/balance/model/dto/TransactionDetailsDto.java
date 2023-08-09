package com.jdc.balance.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.balance.model.entity.Transaction;

public record TransactionDetailsDto(
		long id,
		LedgerDto ledger,
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate issueDate,
		String issueUser,
		int total,
		List<TransactionDetailsItemDto> items) {

	public int getItemCount() {
		return null != items ? items.size() : 0;
	}
	
	public int getTotal() {
		return null != items && !items.isEmpty() ? 
				items.stream().mapToInt(a -> a.getTotal()).sum() : 0;
	}
	
	public static TransactionDetailsDto from(Transaction entity) {
		return new TransactionDetailsDto(
				entity.getId(), 
				LedgerDto.from(entity.getLedger()), 
				entity.getIssueDate(), 
				entity.getIssueUser(), 
				entity.getTotal(),
				entity.getItems().stream().map(TransactionDetailsItemDto::from).toList());
	}
}
