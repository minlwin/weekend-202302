package com.jdc.location.api;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.location.model.dto.DivisionDTO;
import com.jdc.location.model.dto.form.DivisionForm;

@RestController
@RequestMapping("division")
public class DivisionApi {
	
	@GetMapping("region")
	public List<String> getAllRegions() {
		return null;
	}

	@GetMapping
	public List<DivisionDTO> search(
			@RequestParam Optional<String> region, 
			@RequestParam Optional<String> keyword) {
		return null;
	}
	
	@PostMapping
	public DivisionDTO create(
			@Validated @RequestBody DivisionForm form,
			BindingResult result) {
		
		return null;
	}
	
	@GetMapping("{id}")
	public DivisionDTO findById(@PathVariable int id) {
		return null;
	}
	
	@PutMapping("{id}")
	public DivisionDTO update(@PathVariable int id, 
			 @Validated @RequestBody DivisionForm form,
			 BindingResult result) {

		return null;
	}
}
