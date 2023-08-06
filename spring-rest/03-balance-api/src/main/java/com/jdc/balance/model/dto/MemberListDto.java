package com.jdc.balance.model.dto;

import java.time.LocalDate;

import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;

public record MemberListDto(
		int id,
		String email,
		MemberRole role,
		String phone,
		LocalDate registAt,
		MemberStatus status
		) {

}
