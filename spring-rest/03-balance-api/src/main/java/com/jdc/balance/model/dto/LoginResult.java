package com.jdc.balance.model.dto;

import com.jdc.balance.model.enums.MemberRole;

public record LoginResult(
		int id,
		String email,
		MemberRole role
		) {

}
