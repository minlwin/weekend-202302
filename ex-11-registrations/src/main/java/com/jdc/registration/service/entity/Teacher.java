package com.jdc.registration.service.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teacher extends Account{
	
	public Teacher() {
		super(Role.Teacher);
	}

}
