package com.jdc.balance.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;

public record MemberDetailsDto(
		int id,
		String email,
		MemberRole role,
		String phone,
		LocalDate registAt,
		MemberStatus status,
		LocalDateTime lastAccessTime,
		long ledgers,
		long transactions
		) {

}
