package com.jdc.balance.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ReportForDayDto(
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate date,
		LedgerDto ledger,
		long transactionCount,
		long transactionAmount
		) {

}
