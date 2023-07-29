package com.jdc.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.demo.model.dto.AccountForm;
import com.jdc.demo.model.dto.BusinessError;
import com.jdc.demo.model.entity.Account;
import com.jdc.demo.model.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountApi {
	
	@Autowired
	private AccountService service;

	@GetMapping
	List<Account> getAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	Account findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	
	@PostMapping
	ResponseEntity<?> create(@Validated AccountForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body(BusinessError.validation(
					result.getFieldErrors().stream()
					.map(a -> a.getDefaultMessage()).toList())); 
		}
		
		return ResponseEntity.ok().body(service.save(form));
	}
}
