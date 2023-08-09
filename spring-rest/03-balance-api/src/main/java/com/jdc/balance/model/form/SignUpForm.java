package com.jdc.balance.model.form;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignUpForm(
		@NotBlank(message = "Please enter name.")
		String name,
		@NotBlank(message = "Please enter email.")
		@Email(message = "Please enter vaild email.")
		String email,
		@NotBlank(message = "Please enter password.")
		String password
		) {

	public SignInForm signIn() {
		return new SignInForm(email, password);
	}
	
	public Member entity(PasswordEncoder passwordEncoder) {
		var entity = new Member();
		entity.setName(name);
		entity.setEmail(email);
		entity.setPassword(passwordEncoder.encode(password));
		entity.setRegistrationDate(LocalDate.now());
		entity.setRole(MemberRole.Member);
		entity.setStatus(MemberStatus.Active);
		return entity;
	}
}
