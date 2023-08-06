package com.jdc.balance.model.form;

import com.jdc.balance.model.enums.MemberStatus;

import jakarta.validation.constraints.NotNull;

public record MemberStatusForm(
		@NotNull(message = "Please select member status.")
		MemberStatus status
		) {

}
