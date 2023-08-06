package com.jdc.balance.api;

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

import com.jdc.balance.model.dto.ApiResponse;
import com.jdc.balance.model.dto.MemberDetailsDto;
import com.jdc.balance.model.dto.MemberListDto;
import com.jdc.balance.model.dto.PageResult;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;
import com.jdc.balance.model.form.MemberForm;
import com.jdc.balance.model.form.MemberStatusForm;
import com.jdc.balance.service.MemberService;

@RestController
@RequestMapping("member")
public class MemberApi {
	
	@Autowired
	private MemberService service;

	@GetMapping
	ApiResponse<PageResult<MemberListDto>> search(
			@RequestParam Optional<MemberRole> role,
			@RequestParam Optional<MemberStatus> status,
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int pageSize) {
		return ApiResponse.from(service.search(role, status, keyword, page, pageSize));
	}
	
	@GetMapping("{id}")
	ApiResponse<MemberDetailsDto> findById(@PathVariable int id) {
		return ApiResponse.from(service.findById(id));
	}
	
	@PostMapping
	ApiResponse<Integer> create(@Validated @RequestBody MemberForm form, BindingResult result) {
		return null;
	}
	
	@PutMapping("{id}")
	ApiResponse<Integer> update(@PathVariable int id, 
			@Validated @RequestBody MemberForm form, BindingResult result) {
		return null;
	}
	
	@PutMapping("{id}/status")
	ApiResponse<Integer> updateStatus(@PathVariable int id, 
			@Validated @RequestBody MemberStatusForm form, BindingResult result) {
		return null;
	}
}
