package com.jdc.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Office extends Account{

	public Office() {
		super(Role.Office);
	}

}
