package com.jdc.registration.service.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Please select course.")
	@ManyToOne(optional = false)
	private Course course;
	
	@ManyToOne(optional = false)
	private Teacher teacher;
	
	@NotNull(message = "Please enter start date.")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@NotEmpty(message = "Please select days.")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<DayOfWeek> days;
	
	@NotBlank(message = "Please enter start time.")
	@Column(nullable = false)
	private String startTime;

	@NotBlank(message = "Please enter end time.")
	@Column(nullable = false)
	private String endTime;
	
	@Column(nullable = false)
	private int months;
	
	private boolean acceptable;
}
