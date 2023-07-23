package com.jdc.demo.model.dto;

import com.jdc.demo.model.entity.Account;

import lombok.Data;

@Data
public class AccountForm {

	private String name;
	private String email;
	private String phone;
	
	public Account entity() {
		var entity = new Account();
		entity.setEmail(email);
		entity.setName(name);
		entity.setPhone(phone);
		return entity;
	}
}
