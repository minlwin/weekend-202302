package com.jdc.demo.binding.domain.dto.form;

import java.util.function.Function;

import com.jdc.demo.binding.domain.entity.Account;
import com.jdc.demo.binding.domain.entity.Account.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpForm {

	@NotBlank(message = "Please enter your name.")
	private String name;
	
	@Email(message = "Please enter valid email.")
	@NotBlank(message = "Please enter email for login.")
	private String email;
	
	
	@NotBlank(message = "Please enter password.")
	private String password;
	
	public Account entity(Function<String, String> passwordEncoder) {
		var entity = new Account(email, name, passwordEncoder.apply(password));
		entity.setRole(Role.Member);
		return entity;
	}
}
