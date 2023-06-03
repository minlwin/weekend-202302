package com.jdc.demo.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String loginId;
	
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Role role;

	private boolean activated;
	private boolean expired;
	
	public enum Role {
		Office, Student
	}
}
