package com.jdc.balance.utils.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.dto.response.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	public ApiResponse<ErrorResponse> handleBusiness(BalanceBusinessException e) {
		return ApiResponse.from(ErrorResponse.business(e.getMessages()));
	}
	
	@ExceptionHandler
	public ApiResponse<ErrorResponse> handleValidation(BalanceValidationException e) {
		return ApiResponse.from(ErrorResponse.business(e.getMessages()));
	}	
}
