package com.jdc.demo.binding.domain.dto.vo;

import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.binding.domain.entity.Feature;
import com.jdc.demo.binding.domain.entity.Product;

import lombok.Data;

@Data
public class PurchaseItemVO {

	private int id;
	private String name;
	private String category;
	private String brand;
	private String coverImage;
	
	private List<Feature> features = new ArrayList<>();
	
	private int price;
	private int quantity;
	
	public int getTotal() {
		return price * quantity;
	}
	
	public static PurchaseItemVO from(Product product) {
		var dto = new PurchaseItemVO();
		dto.id = product.getId();
		dto.name = product.getName();
		dto.category = product.getCategory().getName();
		dto.brand = product.getBrand();
		dto.features = product.getFeatures();
		dto.coverImage = product.getCoverImage();
		dto.price = product.getPrice();
		return dto;
	}
	
	public PurchaseItemVO quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
}
