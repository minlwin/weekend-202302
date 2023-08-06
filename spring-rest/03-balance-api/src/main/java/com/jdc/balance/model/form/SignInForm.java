package com.jdc.balance.model.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignInForm(
		@NotBlank(message = "Please enter email.")
		@Email(message = "Please enter vaild email.")
		String email,
		@NotBlank(message = "Please enter password.")
		String password
		) {

}
