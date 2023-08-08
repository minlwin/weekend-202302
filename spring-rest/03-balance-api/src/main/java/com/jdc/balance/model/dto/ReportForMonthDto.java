package com.jdc.balance.model.dto;

import java.time.YearMonth;

public record ReportForMonthDto(
		YearMonth month,
		LedgerDto ledger,
		long transactionCount,
		long transactionAmount
		) {

}
