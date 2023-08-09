package com.jdc.balance.api;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.dto.TransactionDetailsDto;
import com.jdc.balance.model.dto.TransactionListDto;
import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.dto.response.PageResult;
import com.jdc.balance.model.enums.LedgerType;
import com.jdc.balance.model.form.TransactionForm;
import com.jdc.balance.service.TransactionService;

@RestController
@RequestMapping("transaction")
public class TransactionApi {
	
	@Autowired
	private TransactionService service;

	@GetMapping
	ApiResponse<PageResult<TransactionListDto>> search(
			@RequestParam Optional<LedgerType> type,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> from,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> to,
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		return ApiResponse.from(service.search(type, from, to, keyword, page, pageSize));
	}
	
	@PostMapping
	ApiResponse<Long> create(@Validated @RequestBody TransactionForm form, BindingResult result) {
		return ApiResponse.from(service.create(form));
	}
	
	@PutMapping("{id}")
	ApiResponse<Long> update(@PathVariable long id, 
			@Validated @RequestBody TransactionForm form, BindingResult result) {
		return ApiResponse.from(service.update(id, form));
	}
	
	@GetMapping("{id}")
	ApiResponse<TransactionDetailsDto> findById(@PathVariable long id) {
		return ApiResponse.from(service.findById(id));
	}
}
