package com.jdc.balance.model.dto;

import java.time.YearMonth;

public record ReportForMonthDto(
		YearMonth month,
		LedgerDto ledger,
		long transactionCount,
		long transactionAmount
		) {

	public static ReportForMonthDto from(YearMonth month, ReportProjectionDto dto) {
		return new ReportForMonthDto(month, LedgerDto.from(dto.getLedger()), dto.getTransactionCount(), dto.getTransactionAmount());
	}
}
