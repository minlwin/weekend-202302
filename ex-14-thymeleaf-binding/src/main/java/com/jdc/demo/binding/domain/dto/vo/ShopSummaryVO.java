package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.Shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopSummaryVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	
	public static ShopSummaryVO from(Shop shop) {
		return new ShopSummaryVO(shop.getId(), shop.getName());
	}
}
