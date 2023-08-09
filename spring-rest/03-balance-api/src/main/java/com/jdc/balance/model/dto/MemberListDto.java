package com.jdc.balance.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;

public record MemberListDto(
		int id,
		String email,
		MemberRole role,
		String phone,
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate registAt,
		MemberStatus status
		) {

	public static MemberListDto from(Member entity) {
		return new MemberListDto(
				entity.getId(), 
				entity.getEmail(), 
				entity.getRole(), 
				entity.getPhone(), 
				entity.getRegistrationDate(), 
				entity.getStatus());
	}
}
