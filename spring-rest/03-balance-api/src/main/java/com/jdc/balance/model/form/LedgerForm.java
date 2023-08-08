package com.jdc.balance.model.form;

import com.jdc.balance.model.entity.Ledger;
import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.LedgerType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LedgerForm(
		@NotNull(message = "Please select ledger type.")
		LedgerType type,
		@NotEmpty(message = "Please enter ledger name.")
		String name
		) {

	public Ledger entity(Member user) {
		var entity = new Ledger();
		entity.setOwner(user);
		entity.setName(name);
		entity.setType(type);
		return entity;
	}

}
