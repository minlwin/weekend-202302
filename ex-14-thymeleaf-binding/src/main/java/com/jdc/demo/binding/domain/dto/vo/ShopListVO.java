package com.jdc.demo.binding.domain.dto.vo;

import com.jdc.demo.binding.domain.entity.Shop;
import com.jdc.demo.binding.domain.entity.ShopReview;

import lombok.Data;

@Data
public class ShopListVO {

	private int id;
	private String name;
	private String greeting;
	private String coverImage;
	private String ownerName;
	private String email;
	private int rating;
	
	public static ShopListVO from(Shop entity) {
		var vo = new ShopListVO();
		vo.id = entity.getId();
		vo.name = entity.getName();
		vo.greeting = entity.getGreeting();
		vo.coverImage = entity.getCoverImage();
		vo.ownerName = entity.getOwner().getName();
		vo.email = entity.getOwner().getEmail();
		
		Double average = entity.getReviews().stream()
				.mapToInt(ShopReview::getRating)
				.average().orElse(0);
		
		vo.rating = average.intValue();
		
		return vo;
	}
}
