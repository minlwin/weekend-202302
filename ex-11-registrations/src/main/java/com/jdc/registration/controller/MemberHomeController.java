package com.jdc.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.registration.service.MemberService;
import com.jdc.registration.service.entity.Section;

@Controller
@RequestMapping({
	"member/home"
})
public class MemberHomeController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping
	String index(ModelMap model) {
		
		// Profile
		
		// My Sections
		List<Section> mySections = service.findOwnSections();
		model.put("mySections", mySections);
		
		return "member/home";
	}	

}
