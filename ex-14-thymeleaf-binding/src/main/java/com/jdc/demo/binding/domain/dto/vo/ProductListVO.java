package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.Product;

import lombok.Data;

@Data
public class ProductListVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String category;
	private String brand;
	private int price;
	private String coverImage;
	
	public static ProductListVO from(Product entity) {
		var vo = new ProductListVO();
		vo.id = entity.getId();
		vo.name = entity.getName();
		vo.category = entity.getCategory().getName();
		vo.brand = entity.getBrand();
		vo.price = entity.getPrice();
		vo.coverImage = entity.getCoverImage();
		return vo;
	}
}
