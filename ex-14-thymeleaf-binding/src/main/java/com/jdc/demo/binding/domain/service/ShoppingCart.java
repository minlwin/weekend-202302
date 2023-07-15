package com.jdc.demo.binding.domain.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class ShoppingCart {
	
	private Map<Integer, Integer> items = new LinkedHashMap<Integer, Integer>();

	public void addToCart(int productId, int count) {
		var previous = items.get(productId);
		count = (null != previous) ? previous + count : count; 
		items.put(productId, count);
	}
	
	public void plusOne(int productId) {
		
	}
	
	public void minusOne(int productId) {
		
	}
	
	public int getCount() {
		
		if(items.isEmpty()) {
			return 0;
		}
		
		return items.values().stream().mapToInt(a -> a).sum();
	}

	public void clear() {
		
	}
	
}
