package com.jdc.balance.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.balance.model.entity.AccessLog;

public record AccessLogDto(
		long id,
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		LocalDateTime access,
		String username,
		String status
		) {
	
	public static AccessLogDto from(AccessLog log) {
		return new AccessLogDto(log.getId(), log.getAccess(), log.getUsername(), log.getStatus().getValue());
	}
}
