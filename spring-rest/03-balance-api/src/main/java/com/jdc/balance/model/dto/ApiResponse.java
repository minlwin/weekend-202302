package com.jdc.balance.model.dto;

public record ApiResponse<T>(
		boolean success, 
		T result) {}
