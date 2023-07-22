package com.jdc.demo.controller.form;

import com.jdc.demo.entity.Account;
import com.jdc.demo.entity.Account.Role;
import com.jdc.demo.entity.Office;
import com.jdc.demo.entity.Student;
import com.jdc.demo.entity.Teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignUpForm {
	
	@NotBlank(message = "Please Enter user name.")
	private String name;
	
	@NotBlank(message = "Please Enter Email Address.")
	private String email;
	
	@NotBlank(message = "Please Enter Password.")
	private String password;
	
	@NotNull(message = "Please Select role.")
	private Role role;
	
	public Account entity() {
		
		var entity = switch (role) {
		case Office -> new Office();
		case Teacher -> new Teacher();
		case Student -> new Student();
		default ->
			throw new IllegalArgumentException("Unexpected value: " + role);
		};
		
		entity.setActivated(true);
		entity.setName(name);
		entity.setEmail(email);
		entity.setPassword(password);
		
		return entity;
	}
}
