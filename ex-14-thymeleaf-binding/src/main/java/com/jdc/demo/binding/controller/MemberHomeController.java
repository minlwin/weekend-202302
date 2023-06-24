package com.jdc.demo.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/home")
public class MemberHomeController {

	@GetMapping
	public String index() {
		return "member/home";
	}
}
