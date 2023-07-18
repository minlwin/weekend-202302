package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.Account;
import com.jdc.demo.binding.domain.entity.Shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdWithName<ID> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ID id;
	private String name;
	
	public static IdWithName<Integer> from(Shop entity) {
		return new IdWithName<Integer>(entity.getId(), entity.getName());
	}
	
	public static IdWithName<String> from(Account entity) {
		return new IdWithName<String>(entity.getEmail(), entity.getName());
	}
	
}
