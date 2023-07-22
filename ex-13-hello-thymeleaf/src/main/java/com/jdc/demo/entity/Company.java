package com.jdc.demo.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "COMPANY")
@Data
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter company name.")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Please enter category.")
	@Column(nullable = false)
	private String category;

	@NotBlank(message = "Please enter email.")
	@Column(nullable = false)
	private String email;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
		name = "COMPANY_PHONE", 
		joinColumns = @JoinColumn(name = "company_id"))
	private List<String> phone;

	private String address;
}
