package com.jdc.demo.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessError {

	private Type type;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime time;
	private List<String> message;

	public static BusinessError validation(List<String> message) {
		return new BusinessError(Type.Validation, LocalDateTime.now(), message);
	}

	public static BusinessError business(String message) {
		return new BusinessError(Type.Business, LocalDateTime.now(), List.of(message));
	}

	public static BusinessError platform(String message) {
		return new BusinessError(Type.Platform, LocalDateTime.now(), List.of(message));
	}

	public enum Type {
		Validation, Business, Platform
	}
}
