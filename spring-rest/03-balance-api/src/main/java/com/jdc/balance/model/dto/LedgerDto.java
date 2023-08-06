package com.jdc.balance.model.dto;

import com.jdc.balance.model.enums.LedgerType;

public record LedgerDto(
		int id, 
		LedgerType type,
		String name
		) {

}
