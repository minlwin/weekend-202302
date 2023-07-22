package com.jdc.registration.service.entity;

import jakarta.persistence.Entity;

@Entity
public class Office extends Account{

	public Office() {
		super(Role.Office);
	}

}
