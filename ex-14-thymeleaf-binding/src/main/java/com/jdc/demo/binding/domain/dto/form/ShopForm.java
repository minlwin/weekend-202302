package com.jdc.demo.binding.domain.dto.form;

import com.jdc.demo.binding.domain.entity.Shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopForm {

	private int id;
	private String name;
	private String coverImage;
	private String greeting;
	
	public Shop entity() {
		return new Shop(name, coverImage, greeting);
	}
	
	public static ShopForm from(Shop entity) {
		return new ShopForm(entity.getId(), entity.getName(), entity.getCoverImage(), entity.getGreeting());
	}
}
