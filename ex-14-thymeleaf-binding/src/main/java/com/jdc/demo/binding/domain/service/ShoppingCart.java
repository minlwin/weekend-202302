package com.jdc.demo.binding.domain.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.jdc.demo.binding.domain.dto.vo.InvoiceItemVO;
import com.jdc.demo.binding.domain.dto.vo.InvoiceSummaryVO;

import lombok.RequiredArgsConstructor;

@Service
@SessionScope
@RequiredArgsConstructor
public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Map<Integer, Integer> items = new LinkedHashMap<Integer, Integer>();
	List<InvoiceItemVO> invoiceItems = new ArrayList<InvoiceItemVO>();
	
	private InvoiceSummaryVO summary;

	public void addToCart(int productId, int count, Supplier<ProductService> service) {
		var previous = items.get(productId);
		count = (null != previous) ? previous + count : count; 
		if(count == 0) {
			items.remove(productId);
		} else {
			items.put(productId, count);
		}
		
		loadParchaseItems(service.get());
	}
	
	public int getCount() {
		
		if(items.isEmpty()) {
			return 0;
		}
		
		return items.values().stream().mapToInt(a -> a).sum();
	}

	public void clear() {
		items.clear();
		invoiceItems.clear();
	}
		
	public Map<Integer, Integer> getItems() {
		return new LinkedHashMap<>(items);
	}
	
	public InvoiceSummaryVO getSummary() {
		return summary;
	}
	
	public List<InvoiceItemVO> getInvoiceItems() {
		return invoiceItems;
	}
	
	private void loadParchaseItems(ProductService productService) {
		this.invoiceItems = productService.getPurchaseItems(items);
		var subTotal = invoiceItems.stream().mapToInt(InvoiceItemVO::getTotal).sum();
		summary = new InvoiceSummaryVO(getCount(), subTotal);
	}
	
}
