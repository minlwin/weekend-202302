package com.jdc.demo.binding.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Feature {

	@NotBlank(message = "Please enter feature name.")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Please enter feature value.")
	@Column(nullable = false)
	private String feature;

}