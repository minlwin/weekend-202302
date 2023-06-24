package com.jdc.demo.binding.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	private String email;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Role role;

	@Column(nullable = false)
	private String password;

	private AuditInfo audit;

	public enum Role {
		Admin,
		Member
	}

}