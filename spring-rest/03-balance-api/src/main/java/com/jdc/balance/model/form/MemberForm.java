package com.jdc.balance.model.form;

import java.time.LocalDate;
import java.util.function.Function;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;

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

	public Member entity(Function<String, String> encoder) {
		var entity = new Member();
		entity.setEmail(email);
		entity.setName(name);
		entity.setPhone(phone);
		entity.setPassword(encoder.apply(phone));
		entity.setRegistrationDate(LocalDate.now());
		entity.setRole(MemberRole.Admin);
		entity.setStatus(MemberStatus.Active);
		return entity;
	}
}
