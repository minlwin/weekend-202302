package com.jdc.balance.model.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignInForm(
		@NotBlank(message = "Please enter email.")
		@Email(message = "Please enter vaild email.")
		String email,
		@NotBlank(message = "Please enter password.")
		String password
		) {

	public UsernamePasswordAuthenticationToken token() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}
