package com.jdc.demo.binding.domain.service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.jdc.demo.binding.domain.dto.vo.PurchaseSummaryVO;

@Service
@SessionScope
public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, Integer> items = new LinkedHashMap<Integer, Integer>();
	
	private PurchaseSummaryVO summary;

	public void addToCart(int productId, int count) {
		var previous = items.get(productId);
		count = (null != previous) ? previous + count : count; 
		if(count == 0) {
			items.remove(productId);
		} else {
			items.put(productId, count);
		}
	}
	
	public int getCount() {
		
		if(items.isEmpty()) {
			return 0;
		}
		
		return items.values().stream().mapToInt(a -> a).sum();
	}

	public void clear() {
		items.clear();
	}
		
	public Map<Integer, Integer> getItems() {
		return new LinkedHashMap<>(items);
	}
	
	public PurchaseSummaryVO getSummary() {
		return summary;
	}
	
	public void setSummary(int subTotal) {
		int tax = subTotal / 100 * 5;
		int total = subTotal + tax;
		summary = new PurchaseSummaryVO(getCount(), subTotal, tax, total);
	}
}
