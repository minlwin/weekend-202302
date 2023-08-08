package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.TransactionItem;

public record TransactionDetailsItemDto(
		long id,
		String itemName,
		int unitPrice,
		int quantity
		) {
	
	public int getTotal() {
		return unitPrice * quantity;
	}
	
	public static TransactionDetailsItemDto from(TransactionItem entity) {
		return new TransactionDetailsItemDto(
				entity.getId(),
				entity.getName(),
				entity.getUnitPrice(), 
				entity.getQuantity());
	}
}
