package com.jdc.balance.api;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.balance.model.dto.ApiResponse;
import com.jdc.balance.model.dto.PageResult;
import com.jdc.balance.model.dto.TransactionDetailsDto;
import com.jdc.balance.model.dto.TransactionListDto;
import com.jdc.balance.model.enums.LedgerType;
import com.jdc.balance.model.form.TransactionForm;

@RequestMapping("transaction")
public class TransactionApi {

	@GetMapping
	ApiResponse<PageResult<TransactionListDto>> search(
			@RequestParam Optional<LedgerType> type,
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to,
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int pageSize) {
		return null;
	}
	
	@PostMapping
	ApiResponse<Long> create(@RequestBody TransactionForm form) {
		return null;
	}
	
	@PutMapping("{id}")
	ApiResponse<Long> update(@PathVariable long id, @RequestBody TransactionForm form) {
		return null;
	}
	
	@GetMapping("{id}")
	ApiResponse<TransactionDetailsDto> findById(@PathVariable long id) {
		return null;
	}
}
