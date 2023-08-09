package com.jdc.balance.utils.exceptions;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.dto.response.ErrorResponse;

import jakarta.annotation.PostConstruct;

@RestControllerAdvice
public class ExceptionHandlers {
	
	private Map<String, String> authErrorMapping;
	
	@PostConstruct
	private void initialize() {
		authErrorMapping = Map.of(
			UsernameNotFoundException.class.getName(), "Please check your login id.",
			BadCredentialsException.class.getName(), "Please check your password.",
			DisabledException.class.getName(), "Your account is disabled, please contact to admin.",
			LockedException.class.getName(), "Your account is locked, please contact to admin."
				);
	}

	@ExceptionHandler
	public ApiResponse<ErrorResponse> handleBusiness(BalanceBusinessException e) {
		return ApiResponse.from(ErrorResponse.business(e.getMessages()));
	}
	
	@ExceptionHandler
	public ApiResponse<ErrorResponse> handleValidation(BalanceValidationException e) {
		return ApiResponse.from(ErrorResponse.business(e.getMessages()));
	}	
	
	@ExceptionHandler
	public ApiResponse<ErrorResponse> handleAuthenticationFailure(AuthenticationException e) {
		var message = Optional.ofNullable(authErrorMapping.get(e.getClass().getName()));
		return ApiResponse.from(ErrorResponse.business(List.of(message.orElse("Authentication Error."))));
	}

	
}
