package com.jdc.balance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.dto.MemberDetailsDto;
import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.form.MemberForm;
import com.jdc.balance.service.LoginUserService;
import com.jdc.balance.service.MemberService;

@RestController
@RequestMapping("profile")
public class MemberProfileApi {

	@Autowired
	private MemberService service;
	
	@Autowired
	private LoginUserService loginUserService;
	
	@GetMapping
	ApiResponse<MemberDetailsDto> getProfile() {
		var loginUser = loginUserService.getLoginUser();
		return ApiResponse.from(service.findById(loginUser.getId()));
	}

	@PutMapping
	ApiResponse<Integer> update( 
			@Validated @RequestBody MemberForm form, BindingResult result) {
		
		var loginUser = loginUserService.getLoginUser();
		return ApiResponse.from(service.update(loginUser.getId(), form));
	}

}
