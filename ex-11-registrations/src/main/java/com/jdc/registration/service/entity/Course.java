package com.jdc.registration.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter course name.")
	@Column(nullable = false)
	private String name;
	
	@NotNull(message = "Please select course level.")
	@Column(nullable = false)
	private Level level;
	
	@Min(value = 30, message = "Please enter course hours atleast 30 hours..")
	private int hours;
	@Min(value = 100000, message = "Please enter course fees atleast 100,000 MMK.")
	private int fees;
	
	private String description;
	
	
	public enum Level {
		Entry, Basic, Intermediate, Advance
	}
}
