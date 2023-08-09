package com.jdc.balance.model.enums;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public enum AccessStatus {

	Success, NoUserName, InvalidPassword, Others;
	
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
