package com.jdc.registration.controller;

import java.time.DayOfWeek;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.registration.controller.convert.CourseConverter;
import com.jdc.registration.service.CourseService;
import com.jdc.registration.service.MemberService;
import com.jdc.registration.service.SectionService;
import com.jdc.registration.service.entity.Section;

@Controller
@RequestMapping("teacher/section")
public class TeacherSectionController {
	
	@Autowired
	private SectionService service;
	@Autowired
	private CourseService courseService;
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CourseConverter converter;
	
	
	@InitBinder
	void init(WebDataBinder binder) {
		if(binder.getConversionService() instanceof ConfigurableConversionService convert) {
			convert.addConverter(converter);
		}
	}
	
	@GetMapping
	String edit(ModelMap model) {
		model.put("courses", courseService.findAll());
		model.put("days", DayOfWeek.values());
		return "section/edit";
	}
	
	@PostMapping
	String save(@Validated @ModelAttribute("form") Section section, BindingResult bindingResult, ModelMap model) {
		
		if(bindingResult.hasErrors()) {
			model.put("courses", courseService.findAll());
			model.put("days", DayOfWeek.values());
			return "section/edit";
		}
		
		// find teacher and set
		section.setTeacher(memberService.getLoginTeacher());
		
		section = service.save(section);
		
		return "redirect:/teacher/section/%s".formatted(section.getId());
	}
	
	@GetMapping("{id}")
	String showDetails(@PathVariable int id, ModelMap model) {
		model.put("dto", service.findById(id));
		return "section/details";
	}
	
	
	@ModelAttribute("form")
	Section form(@RequestParam Optional<Integer> id) {
		if(id.filter(a -> a > 0).isPresent()) {
			return service.findById(id.get());
		}
		
		return new Section();
	}
	
}
