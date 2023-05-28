package com.jdc.demo.service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "TEACHER")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter name")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "Please enter phone number.")
	@Pattern(
			regexp = "^09\\d([- ](\\d){4}){2}$", 
			message = "Please enter valid phone number.")
	@Column(nullable = false)
	private String phone;
	
	@NotBlank(message = "Please enter email address.")
	@Email(message = "Please enter valid email")
	@Column(nullable = false)
	private String email;
	
	@NotNull(message = "Please enter entry date.")
	@Column(name = "entry_date")
	private LocalDate entryDate;
}
