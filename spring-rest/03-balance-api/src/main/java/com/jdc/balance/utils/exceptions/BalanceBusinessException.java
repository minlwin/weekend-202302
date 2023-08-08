package com.jdc.balance.utils.exceptions;

import java.util.List;

public class BalanceBusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BalanceBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BalanceBusinessException(String message) {
		super(message);
	}
	
	public List<String> getMessages() {
		return List.of(getMessage());
	}
}
