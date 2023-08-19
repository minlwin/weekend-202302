package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;

public record LoginResultDto(
		int id,
		String name,
		String email,
		MemberRole role,
		String token
		) {
	
	public LoginResultDto token(String token) {
		return new LoginResultDto(id, name, email, role, token);
	}

	public static LoginResultDto from(Member entity) {
		return new LoginResultDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getRole(), null);
	}
}
