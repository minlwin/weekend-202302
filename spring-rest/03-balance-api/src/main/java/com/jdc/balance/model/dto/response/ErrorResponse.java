package com.jdc.balance.model.dto.response;

import java.util.List;

import com.jdc.balance.model.enums.ErrorType;

public record ErrorResponse(
	ErrorType type,
	List<String> messages) {

	public static ErrorResponse validation(List<String> messages) {
		return new ErrorResponse(ErrorType.Validation, messages);
	}
	
	public static ErrorResponse business(List<String> messages) {
		return new ErrorResponse(ErrorType.Business, messages);
	}
	
	public static ErrorResponse platform(List<String> messages) {
		return new ErrorResponse(ErrorType.Platform, messages);
	}
}
