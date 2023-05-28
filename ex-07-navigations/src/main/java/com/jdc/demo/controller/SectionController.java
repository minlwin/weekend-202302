package com.jdc.demo.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.demo.controller.commons.CourseConverter;
import com.jdc.demo.controller.commons.TeacherConverter;
import com.jdc.demo.service.CourseService;
import com.jdc.demo.service.SectionService;
import com.jdc.demo.service.TeacherService;
import com.jdc.demo.service.entity.Section;

@Controller
@RequestMapping("section")
public class SectionController {

	@Autowired
	private SectionService service;

	@Autowired
	private CourseService courseService;

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TeacherConverter taConverter;
	@Autowired
	private CourseConverter courseConverter;
	
	@InitBinder
	void init(WebDataBinder binder) {
		
		if(binder.getConversionService() instanceof ConfigurableConversionService conf) {
			conf.addConverter(taConverter);
			conf.addConverter(courseConverter);
		}
		
	}

	@GetMapping
	String index(
			@RequestParam Optional<LocalDate> dateFrom, 
			@RequestParam Optional<String> teacher,
			@RequestParam Optional<String> course, 
			ModelMap model) {

		model.put("list", service.search(dateFrom, teacher, course));
		return "section";
	}

	@GetMapping("edit")
	String edit(ModelMap model) {

		// courses
		model.put("courses", courseService.searchAll());
		// teachers
		model.put("teachers", teacherService.searchAll());
		// days
		model.put("days", DayOfWeek.values());

		return "section-edit";
	}

	@GetMapping("{id}")
	String showDetails(@PathVariable int id, ModelMap model) {
		model.put("data", service.findById(id));
		return "section-details";
	}

	@PostMapping
	String save(@Validated @ModelAttribute("form") Section form, 
			BindingResult result, 
			RedirectAttributes redirect,
			ModelMap model) {

		if (result.hasErrors()) {
			// courses
			model.put("courses", courseService.searchAll());
			// teachers
			model.put("teachers", teacherService.searchAll());
			// days
			model.put("days", DayOfWeek.values());
			return "section-edit";
		}
		
		var operation = form.getId() == 0 ? "Created" : "Updated";
		
		var id = service.save(form);
		
		redirect.addFlashAttribute("message", 
				"Section has been %s successfully.".formatted(operation));
		
		return "redirect:/section/%s".formatted(id);
	}

	@ModelAttribute(name = "form")
	Section form(@RequestParam(required = false) Integer id) {
		return id != null && id > 0 ? service.findById(id) : new Section();
	}

}
