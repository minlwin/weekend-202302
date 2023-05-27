package com.jdc.demo.service.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SECTION")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Course course;
	
	@ManyToOne(optional = false)
	private Teacher teacher;
	
	@Column(nullable = false, name = "start_date")
	private LocalDate startDate;
	
	@ElementCollection
	@CollectionTable(name = "SECTION_DAYS")
	private List<DayOfWeek> days;
	
	@Column(nullable = false, name = "start_time")
	private String startTime;
	
	@Column(nullable = false, name = "end_time")
	private String endTime;

	private boolean acceptable;
}
