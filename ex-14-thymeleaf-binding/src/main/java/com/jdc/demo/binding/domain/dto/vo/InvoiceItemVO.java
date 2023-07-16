package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.binding.domain.dto.form.FeatureForm;
import com.jdc.demo.binding.domain.entity.Product;

import lombok.Data;

@Data
public class InvoiceItemVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String category;
	private String brand;
	private String coverImage;
	
	private List<FeatureForm> features = new ArrayList<>();
	
	private int price;
	private int quantity;
	
	public int getTotal() {
		return price * quantity;
	}
	
	public static InvoiceItemVO from(Product product) {
		var dto = new InvoiceItemVO();
		dto.id = product.getId();
		dto.name = product.getName();
		dto.category = product.getCategory().getName();
		dto.brand = product.getBrand();
		dto.features = product.getFeatures().stream().map(FeatureForm::from).toList();
		dto.coverImage = product.getCoverImage();
		dto.price = product.getPrice();
		return dto;
	}
	
	public InvoiceItemVO quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
}
