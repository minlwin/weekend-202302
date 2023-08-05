package com.jdc.balance.model.form;

public record TransactionItemForm(
		String itemName,
		int unitPrice,
		int quantity
		) {

}
