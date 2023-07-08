package com.jdc.demo.binding.domain.dto.vo;

import com.jdc.demo.binding.domain.entity.Product;

import lombok.Data;

@Data
public class ProductListVO {

	private int id;
	private String name;
	private String category;
	private int price;
	private String coverImage;
	
	public static ProductListVO from(Product entity) {
		var vo = new ProductListVO();
		vo.id = entity.getId();
		vo.name = entity.getName();
		vo.category = entity.getCategory().getName();
		vo.price = entity.getPrice();
		vo.coverImage = entity.getCoverImage();
		return vo;
	}
}
