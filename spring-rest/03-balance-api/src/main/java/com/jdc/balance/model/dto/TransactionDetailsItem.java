package com.jdc.balance.model.dto;

public record TransactionDetailsItem(
		String itemName,
		int unitPrice,
		int quantity
		) {
	
	public int getTotal() {
		return unitPrice * quantity;
	}
}
