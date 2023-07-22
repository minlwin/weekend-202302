package com.jdc.registration.service.form;

import com.jdc.registration.service.entity.Account.Role;
import com.jdc.registration.service.entity.Student;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistrationForm {
	
	private Integer sectionId;

	@NotBlank(message = "Please enter student name.")
	private String name;
	@NotBlank(message = "Please enter email address.")
	private String email;
	@NotBlank(message = "Please enter phone number.")
	private String phone;
	@NotBlank(message = "Please enter password.")
	private String password;
	
	public Student getStudent() {
		var entity = new Student();
		entity.setRole(Role.Student);
		entity.setName(name);
		entity.setPhone(phone);
		entity.setEmail(email);
		entity.setActivated(true);
		return entity;
	}
}
