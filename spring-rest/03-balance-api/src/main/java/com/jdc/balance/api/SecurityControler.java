package com.jdc.balance.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.dto.ApiResponse;
import com.jdc.balance.model.dto.LoginResult;
import com.jdc.balance.model.form.SignInForm;
import com.jdc.balance.model.form.SignUpForm;

@RestController
@RequestMapping("public")
public class SecurityControler {

	@PostMapping("authenticate")
	ApiResponse<LoginResult> signIn(SignInForm form) {
		return null;
	}
	
	@PostMapping("register")
	ApiResponse<LoginResult> signUp(SignUpForm form) {
		return null;
	}
	
}
