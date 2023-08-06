package com.jdc.balance.model.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MemberForm(
		@NotBlank(message = "Please enter name.")
		String name,
		@NotBlank(message = "Please enter email.")
		@Email(message = "Please enter vaild email.")
		String email,
		@NotBlank(message = "Please enter phone number.")
		String phone
		) {

}
