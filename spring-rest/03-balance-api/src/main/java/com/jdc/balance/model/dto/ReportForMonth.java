package com.jdc.balance.model.dto;

import java.time.YearMonth;

public record ReportForMonth(
		YearMonth month,
		LedgerDto ledger,
		long transactionCount,
		long transactionAmount
		) {

}
