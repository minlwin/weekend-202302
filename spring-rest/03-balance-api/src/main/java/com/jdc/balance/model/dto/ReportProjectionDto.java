package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.Ledger;

public interface ReportProjectionDto {

	Ledger getLedger();
	long getTransactionCount();
	long getTransactionAmount();

}
