package com.jdc.demo.binding.domain.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ACCOUNT")
@EntityListeners(value = AuditingEntityListener.class)
public class Account {

	@Id
	@NonNull
	private String email;
	
	@NonNull
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Role role;

	@Column(nullable = false)
	@NonNull
	private String password;

	private AuditInfo audit = new AuditInfo();

	public enum Role {
		Admin,
		Member
	}

}