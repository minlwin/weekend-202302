package com.jdc.balance.model.form;

import java.time.LocalDate;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TransactionForm(
		@NotNull(message = "Please select ledger.")
		Integer ledgerId,
		@NotNull(message = "Please enter issue date.")
		LocalDate issueDate,
		@NotBlank(message = "Please enter issue user name.")
		String userName,
		@Validated
		@NotEmpty(message = "Please enter transaction item.")
		List<TransactionItemForm> items
		) {

}
