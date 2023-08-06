package com.jdc.balance.model.dto;

import java.time.LocalDate;

public record TransactionListDto(
		long id,
		LedgerDto ledger,
		LocalDate issueDate,
		String issueUser,
		long itemCount,
		long total
		) {

}
