package com.jdc.balance.model.dto.response;

public record ApiResponse<T>(
		boolean success, 
		T result) {

	public static<T> ApiResponse<T> from(T result) {
		return new ApiResponse<T>(true, result);
	}
	
	public static ApiResponse<ErrorResponse> from(ErrorResponse resp) {
		return new ApiResponse<ErrorResponse>(false, resp);
	}
}
