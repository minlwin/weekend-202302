package com.jdc.balance.model.form;

import java.time.LocalDate;
import java.util.List;

public record TransactionForm(
		int ledgerId,
		LocalDate issueDate,
		String userName,
		List<TransactionItemForm> items
		) {

}
