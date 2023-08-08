package com.jdc.balance.model.form;

import com.jdc.balance.model.entity.Transaction;
import com.jdc.balance.model.entity.TransactionItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record TransactionItemForm(
		@NotEmpty(message = "Please enter item name.")
		String itemName,
		@Min(value = 1, message = "Please enter unit price.")
		int unitPrice,
		@Min(value = 1, message = "Please enter quantity.")
		int quantity
		) {

	public TransactionItem entity(Transaction transaction) {
		var entity = new TransactionItem();
		entity.setTransaction(transaction);
		entity.setName(itemName);
		entity.setUnitPrice(unitPrice);
		entity.setQuantity(quantity);
		return entity;
	}
}
