package com.jdc.demo.binding.domain.dto.form;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.Shop;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	
	@NotBlank(message = "Please enter shop name.")
	private String name;
	private String coverImage;
	@NotBlank(message = "Please enter greeting message.")
	private String greeting;
	
	public Shop entity() {
		return new Shop(name, greeting);
	}
	
	public static ShopForm from(Shop entity) {
		return new ShopForm(entity.getId(), entity.getName(), entity.getCoverImage(), entity.getGreeting());
	}
}
