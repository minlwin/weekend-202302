package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.Ledger;
import com.jdc.balance.model.enums.LedgerType;

public record LedgerDto(
		int id, 
		LedgerType type,
		String name
		) {

	public static LedgerDto from(Ledger entity) {
		return new LedgerDto(entity.getId(), entity.getType(), entity.getName());
	}
}
