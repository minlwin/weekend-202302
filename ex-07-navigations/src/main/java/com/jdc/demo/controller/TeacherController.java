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

import com.jdc.demo.service.TeacherService;
import com.jdc.demo.service.entity.Teacher;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService service;

	@GetMapping
	String index(
			@RequestParam Optional<String> name,
			@RequestParam Optional<String> phone,
			ModelMap model
			) {
		model.put("list", service.search(name, phone));
		return "teacher";
	}
	
	@GetMapping("edit")
	String edit() {
		return "teacher-edit";
	}
	
	@PostMapping
	String save(
			@Validated @ModelAttribute Teacher form, 
			BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			return "teacher-edit";
		}
		
		var isNewEntity = form.getId() == 0;
		
		var id = service.save(form);
		
		redirect.addFlashAttribute("message", "Teacher has been %s successfully!"
				.formatted(isNewEntity ? "Created" : "Updated"));
		
		return "redirect:/teacher/%d".formatted(id);
	}

	@GetMapping("{id}")
	String showDetails(@PathVariable int id, ModelMap model) {
		model.put("data", service.findById(id));
		return "teacher-details";
	}
	
	@ModelAttribute("form")
	Teacher form(@RequestParam Optional<Integer> id) {
		return id.filter(a -> a > 0).isEmpty() ? new Teacher() : 
			service.findById(id.get());
	}
	
}
