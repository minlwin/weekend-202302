package com.jdc.balance.model.dto;

import java.time.LocalDate;

public record ReportForDay(
		LocalDate date,
		LedgerDto ledger,
		long transactionCount,
		long transactionAmount
		) {

}
