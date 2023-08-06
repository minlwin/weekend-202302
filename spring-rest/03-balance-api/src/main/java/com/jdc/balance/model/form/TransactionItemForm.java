package com.jdc.balance.model.form;

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

}
