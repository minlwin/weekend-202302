package com.jdc.demo.binding.domain.dto.form;

import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.binding.domain.entity.Feature;
import com.jdc.demo.binding.domain.entity.Product;

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
	
	public static ProductForm from(Product entity) {
		var form = new ProductForm();
		form.id = entity.getId();
		form.shop = entity.getShop().getId();
		form.name = entity.getName();
		form.category = entity.getCategory().getName();
		form.brand = entity.getBrand();
		form.price = entity.getPrice();
		form.features = entity.getFeatures();
		return form;
	}
}
