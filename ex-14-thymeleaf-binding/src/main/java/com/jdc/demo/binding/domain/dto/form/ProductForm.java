package com.jdc.demo.binding.domain.dto.form;

import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.binding.domain.entity.Feature;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {

	private int id;
	
	@NotNull(message = "Please select shop.")
	private Integer shop;
	
	@NotBlank(message = "Please enter product name.")
	private String name;
	@NotBlank(message = "Please enter category name.")
	private String category;
	@NotBlank(message = "Please enter brand name.")
	private String brand;
	
	private int price;
	
	@Valid
	private List<Feature> features = new ArrayList<>();	
}
