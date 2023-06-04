package com.jdc.registration.service.entity;

import jakarta.persistence.Entity;

@Entity
public class Office extends Account{

	protected Office() {
		super(Role.Office);
	}

}
