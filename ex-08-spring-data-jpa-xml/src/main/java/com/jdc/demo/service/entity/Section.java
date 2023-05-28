package com.jdc.demo.service.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "SECTION")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Please select course.")
	@ManyToOne(optional = false)
	private Course course;
	
	@NotNull(message = "Please select teacher.")
	@ManyToOne(optional = false)
	private Teacher teacher;
	
	@NotNull(message = "Please enter start date.")
	@Column(nullable = false, name = "start_date")
	private LocalDate startDate;
	
	@NotEmpty(message = "Please select days of week.")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "SECTION_DAYS")
	private List<DayOfWeek> days;
	
	@NotBlank(message = "Please enter start time.")
	@Column(nullable = false, name = "start_time")
	private String startTime;
	
	@NotBlank(message = "Please enter end time.")
	@Column(nullable = false, name = "end_time")
	private String endTime;

	private boolean acceptable;
}
