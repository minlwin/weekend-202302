package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({
	"/student/section",
	"/teacher/section"
})
public class MySectionController {

	@GetMapping
	String index() {
		return "my-sections";
	}
}
