package com.jdc.registration.service.form;

import com.jdc.registration.service.entity.Account;
import com.jdc.registration.service.entity.Account.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountForm {

	private int id;
	
	@NotBlank(message = "Please enter email.")
	private String email;
	@NotBlank(message = "Please enter account name.")
	private String name;
	@NotNull(message = "Please select role.")
	private Role role;
	
	public AccountForm(Account account) {
		this.id = account.getId();
		this.email = account.getEmail();
		this.name = account.getName();
		this.role = account.getRole();
	}
}
