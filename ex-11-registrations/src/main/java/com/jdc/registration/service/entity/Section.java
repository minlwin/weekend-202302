package com.jdc.registration.service.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Course course;
	
	@ManyToOne(optional = false)
	private Teacher teacher;
	
	@Column(nullable = false)
	private LocalDate startDate;
	@Column(nullable = false)
	private int months;
	
	@ElementCollection
	private List<DayOfWeek> days;
	
	
	@Column(nullable = false)
	private String startTime;
	@Column(nullable = false)
	private String endTime;
	
	private boolean acceptable;
}
