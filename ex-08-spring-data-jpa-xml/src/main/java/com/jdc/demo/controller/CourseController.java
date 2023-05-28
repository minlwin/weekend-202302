package com.jdc.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.demo.service.CourseService;
import com.jdc.demo.service.entity.Course;
import com.jdc.demo.service.entity.Course.Level;

@Controller
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService service;

	@GetMapping
	String index(
			@RequestParam Optional<Level> level,
			@RequestParam Optional<String> keyword,
			ModelMap model) {
		model.put("list", service.search(level, keyword));
		return "course";
	}
	
	@GetMapping("edit")
	String edit() {
		return "course-edit";
	}
	
	@PostMapping
	String save(
			@Validated @ModelAttribute("form") Course course, 
			BindingResult result,
			RedirectAttributes redirect) {
		
		// validate inputs
		if(result.hasErrors()) {
			return "course-edit";
		}
		
		var isNewEntity = course.getId() == 0;
		
		// save to database
		var id = service.save(course);
		
		redirect.addFlashAttribute("message", 
				"Course has benn %s successfully.".formatted(isNewEntity ? "Created" : "Updated"));
		
		// redirect to details page
		return "redirect:/course/%d".formatted(id);
	}
	
	@GetMapping("{id}")
	String showDetails(@PathVariable int id, ModelMap model) {
		model.put("data", service.findById(id));
		return "course-details";
	}
	
	
	@ModelAttribute("form")
	Course getForm(@RequestParam Optional<Integer> id) {
		return id.filter(a -> a > 0).isEmpty() ? new Course() : 
			service.findById(id.get());
	}
	
	
	@ModelAttribute("levels")
	Level[] getLevels() {
		return Level.values();
	}
}
