package com.jdc.registration.service.dto;

import java.time.LocalDate;

import com.jdc.registration.service.entity.Account;
import com.jdc.registration.service.entity.Account.Role;

import lombok.Data;

@Data
public class AccountDto {

	private int id;
	private String email;
	private String name;
	private Role role;
	private boolean activated;
	private LocalDate retiredAt;
	
	public AccountDto(Account account) {
		this.id = account.getId();
		this.email = account.getEmail();
		this.name = account.getName();
		this.role = account.getRole();
		this.activated = account.isActivated();
		this.retiredAt = account.getRetiredAt();
	}

}
