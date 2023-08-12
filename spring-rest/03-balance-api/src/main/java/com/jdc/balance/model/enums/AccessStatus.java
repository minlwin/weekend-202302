package com.jdc.balance.model.enums;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public enum AccessStatus {

	Success("Success"), 
	NoUserName("Invalid User Name"), 
	InvalidPassword("Invalid Password"), 
	Others("Other Authentication Error");
	
	private String value;
	
	private AccessStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static AccessStatus getStatus(AuthenticationException e) {
		
		if(e instanceof UsernameNotFoundException) {
			return NoUserName;
		}
		
		if(e instanceof BadCredentialsException) {
			return InvalidPassword;
		}
		
		return Others;
	}
}
