package com.jdc.registration.service.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Section section;
	@ManyToOne(optional = false)
	private Student student;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime registAt;
	
	
	private String remark;
}
