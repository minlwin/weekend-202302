package com.jdc.demo.binding.domain.dto.vo;

import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.binding.domain.entity.Feature;
import com.jdc.demo.binding.domain.entity.Product;

import lombok.Data;

@Data
public class ProductDetailsVO {

	private int id;
	private String name;
	
	private int categoryId;
	private String categoryName;
	
	private int shopId;
	private String shopName;
	
	private String brand;
	private List<Feature> features = new ArrayList<>();
	private int price;
	private String coverImage;
	private List<String> images = new ArrayList<>();
	
	private String shopOwner;
	
	
	public static ProductDetailsVO from(Product entity) {
		var vo = new ProductDetailsVO();
		
		vo.id = entity.getId();
		vo.name = entity.getName();
		vo.categoryId = entity.getCategory().getId();
		vo.categoryName = entity.getCategory().getName();
		vo.shopId = entity.getShop().getId();
		vo.shopName = entity.getShop().getName();
		vo.brand = entity.getBrand();
		
		vo.features = entity.getFeatures();
		vo.price = entity.getPrice();
		vo.coverImage = entity.getCoverImage();
		vo.images = entity.getImages();
		
		vo.shopOwner = entity.getShop().getOwner().getEmail();
		
		return vo;
	}
}
