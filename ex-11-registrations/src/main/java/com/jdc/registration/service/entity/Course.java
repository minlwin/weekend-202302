package com.jdc.registration.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Level level;

	private int hours;
	private String description;
	private int fees;
	
	
	public enum Level {
		Entry, Basic, Intermediate, Advance
	}
}
