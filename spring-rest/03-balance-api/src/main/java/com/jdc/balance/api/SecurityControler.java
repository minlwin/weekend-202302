package com.jdc.balance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.dto.LoginResultDto;
import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.form.SignInForm;
import com.jdc.balance.model.form.SignUpForm;
import com.jdc.balance.service.LoginUserService;
import com.jdc.balance.utils.exceptions.BalanceBusinessException;
import com.jdc.balance.utils.security.JwtTokenProvider;

@RestController
@RequestMapping("public")
public class SecurityControler {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private LoginUserService loginUserService;
	
	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("authenticate")
	@Transactional(readOnly = true)
	ApiResponse<LoginResultDto> signIn(@Validated @RequestBody SignInForm form, BindingResult result) {
		return ApiResponse.from(signIn(form));
	}
	
	@PostMapping("register")
	@Transactional
	ApiResponse<LoginResultDto> signUp(@Validated @RequestBody SignUpForm form, BindingResult result) {
		loginUserService.signUp(form);
		return ApiResponse.from(signIn(form.signIn()));
	}
	
	private LoginResultDto signIn(SignInForm form) {
		var authentication = authenticationManager.authenticate(form.token());
		if(null == authentication) {
			throw new BalanceBusinessException("Fail to authenticate.");
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		var result = loginUserService.getLoginUser();
		
		
		return LoginResultDto.from(result).token(tokenProvider.generate(authentication));
	}
	
}
