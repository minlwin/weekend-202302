package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;

public record LoginResultDto(
		int id,
		String email,
		MemberRole role
		) {

	public static LoginResultDto from(Member entity) {
		return new LoginResultDto(entity.getId(), entity.getEmail(), entity.getRole());
	}
}
