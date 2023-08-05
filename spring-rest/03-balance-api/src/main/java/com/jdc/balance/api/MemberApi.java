package com.jdc.balance.api;

import java.util.Optional;

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
import com.jdc.balance.model.form.MemberForm;
import com.jdc.balance.model.form.MemberStatusForm;

@RestController
@RequestMapping("member")
public class MemberApi {

	@GetMapping
	ApiResponse<PageResult<MemberListDto>> search(
			@RequestParam Optional<MemberRole> role,
			@RequestParam Optional<Boolean> active,
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int pageSize) {
		return null;
	}
	
	@GetMapping("{id}")
	ApiResponse<MemberDetailsDto> findById(@PathVariable int id) {
		return null;
	}
	
	@PostMapping
	ApiResponse<Integer> create(@RequestBody MemberForm form) {
		return null;
	}
	
	@PutMapping("{id}")
	ApiResponse<Integer> update(@PathVariable int id, @RequestBody MemberForm form) {
		return null;
	}
	
	@PutMapping("{id}/status")
	ApiResponse<Integer> updateStatus(@PathVariable int id, @RequestBody MemberStatusForm form) {
		return null;
	}
}
