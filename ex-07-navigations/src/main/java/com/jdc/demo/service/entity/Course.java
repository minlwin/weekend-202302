package com.jdc.demo.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter course name.")
	@Column(nullable = false, unique = true)
	private String name;
	
	@NotNull(message = "Please select course level.")
	@Column(nullable = false)
	private Level level;
	
	@Positive(message = "Please enter course fees.")
	private int price;
	
	@Positive(message = "Please enter duration in hours.")
	private int hours;
	
	private String description;
	
	public enum Level {
		Basic, Intermediate, Advance, Professional
	}
}
