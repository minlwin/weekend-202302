package com.jdc.balance.model.dto;

import java.time.LocalDate;

public record ReportForDayDto(
		LocalDate date,
		LedgerDto ledger,
		long transactionCount,
		long transactionAmount
		) {

}
