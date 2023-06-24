package com.jdc.demo.binding.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Feature {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String feature;

}