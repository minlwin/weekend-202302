package com.jdc.demo.binding.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/member")
public class AdminMemberManagementController {

	@GetMapping
	void index(ModelMap model) {
		
	}
}
