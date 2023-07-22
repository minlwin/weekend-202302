package com.jdc.demo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student extends Account{
	
	private String phone;

	public Student() {
		super(Role.Student);
	}

}
