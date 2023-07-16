package com.jdc.demo.binding.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Feature implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Please enter feature name.")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Please enter feature value.")
	@Column(nullable = false)
	private String feature;

}