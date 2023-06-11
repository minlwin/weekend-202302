package com.jdc.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.registration.service.CourseService;
import com.jdc.registration.service.entity.Course;
import com.jdc.registration.service.entity.Course.Level;

@Controller
@RequestMapping("office/course")
public class OfficeCourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	String index(ModelMap model) {
		model.put("list", service.findAll());
		return "course/list";
	}

	@GetMapping("edit")
	String edit(ModelMap model) {
		model.put("levels", Level.values());
		return "course/edit";
	}
	
	@PostMapping("edit")
	String save(@Validated @ModelAttribute("form") Course dto, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			model.put("levels", Level.values());
			return "course/edit";
		}
		
		service.save(dto);
		
		return "redirect:/office/course";
	}
	
	@ModelAttribute("form")
	Course dto(@RequestParam Optional<Integer> id) {
		if(id.filter(a -> a > 0).isPresent()) {
			return service.findById(id.get());
		}
		
		return new Course();
	}
	

}
