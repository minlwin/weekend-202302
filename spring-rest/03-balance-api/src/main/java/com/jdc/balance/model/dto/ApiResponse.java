package com.jdc.balance.model.dto;

public record ApiResponse<T>(
		boolean success, 
		T result) {

	public static<T> ApiResponse<T> from(T result) {
		return new ApiResponse<T>(true, result);
	}
}
