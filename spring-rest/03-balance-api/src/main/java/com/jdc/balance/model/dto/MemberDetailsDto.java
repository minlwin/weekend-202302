package com.jdc.balance.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;

public record MemberDetailsDto(
		int id,
		String email,
		MemberRole role,
		String phone,
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate registAt,
		MemberStatus status,
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		LocalDateTime lastAccessTime,
		long ledgers,
		long transactions
		) {
	
	public MemberDetailsDto lastAccessTime(LocalDateTime time) {
		return new MemberDetailsDto(id, email, role, phone, registAt, status, time, ledgers, transactions);
	}
	
	public MemberDetailsDto ledgers(long count) {
		return new MemberDetailsDto(id, email, role, phone, registAt, status, lastAccessTime, count, transactions);
	}
	
	public MemberDetailsDto transactions(long count) {
		return new MemberDetailsDto(id, email, role, phone, registAt, status, lastAccessTime, ledgers, count);
	}

	public static MemberDetailsDto from(Member entity) {
		return new MemberDetailsDto(
				entity.getId(), 
				entity.getEmail(), 
				entity.getRole(), 
				entity.getPhone(), 
				entity.getRegistrationDate(), 
				entity.getStatus(),
				null,
				0, 
				0);
	}
}
