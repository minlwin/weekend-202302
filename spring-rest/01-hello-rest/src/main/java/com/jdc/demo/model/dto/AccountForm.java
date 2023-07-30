package com.jdc.demo.model.dto;

import com.jdc.demo.model.entity.Account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountForm {

	@NotBlank(message = "Please enter name")
	private String name;
	
	@Email(message = "Please enter valid email form")
	@NotBlank(message = "Please enter email address")
	private String email;
	
	@NotBlank(message = "Please enter phone number")
	private String phone;
	
	public Account entity() {
		var entity = new Account();
		entity.setEmail(email);
		entity.setName(name);
		entity.setPhone(phone);
		return entity;
	}
}
