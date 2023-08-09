package com.jdc.balance.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jdc.balance.model.dto.LedgerDto;
import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.enums.LedgerType;
import com.jdc.balance.model.form.LedgerForm;
import com.jdc.balance.service.LedgerService;

@RestController
@RequestMapping("ledger")
public class LedgerApi {
	
	@Autowired
	private LedgerService service;

	@GetMapping
	ApiResponse<List<LedgerDto>> search(
			@RequestParam Optional<LedgerType> type, 
			@RequestParam(required = false, defaultValue = "") String keyword) {
		return ApiResponse.from(service.search(type, keyword));
	}
	
	@PostMapping
	ApiResponse<Integer> create(@Validated @RequestBody LedgerForm form, BindingResult result) {
		return ApiResponse.from(service.create(form));
	}

	@PutMapping("{id}")
	ApiResponse<Integer> update(@PathVariable int id, @RequestBody LedgerForm form, BindingResult result) {
		return ApiResponse.from(service.update(id, form));
	}
}
