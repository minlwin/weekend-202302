package com.jdc.demo.api.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.demo.model.BusinessException;
import com.jdc.demo.model.dto.BusinessError;

@RestControllerAdvice
public class BusinessExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	BusinessError handle(BusinessException e) {
		return BusinessError.business(e.getMessage());
	}
}
