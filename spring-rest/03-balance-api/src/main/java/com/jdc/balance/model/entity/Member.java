package com.jdc.balance.model.entity;

import java.time.LocalDate;

import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_member", allocationSize = 1)
public class Member {

	@Id
	@GeneratedValue(generator = "seq_member")
	private int id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	private String phone;
	@Column(nullable = false)
	private MemberRole role;
	@Column(nullable = false)
	private String password;

	@Column(nullable = false, columnDefinition = "integer default 0")
	private MemberStatus status;
	private LocalDate registrationDate;
}
