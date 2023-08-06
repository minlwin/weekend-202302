package com.jdc.balance.model.dto;

import java.time.LocalDate;
import java.util.List;

public record TransactionDetailsDto(
		long id,
		LedgerDto ledger,
		LocalDate issueDate,
		String issueUser,
		List<TransactionDetailsItem> items) {

	public int getItemCount() {
		return null != items ? items.size() : 0;
	}
	
	public int getTotal() {
		return null != items && !items.isEmpty() ? 
				items.stream().mapToInt(a -> a.getTotal()).sum() : 0;
	}
}
