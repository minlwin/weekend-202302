package com.jdc.demo.binding.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.demo.binding.domain.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/product")
@RequiredArgsConstructor
public class MemberProductPhotoController {

	private final ProductService productService;

	@PostMapping("{id}/photo")
	String uploadPhoto(@PathVariable int id, @RequestParam("photos") MultipartFile [] files) {
		
		try {
			productService.uploadPhoto(id, files);
		} catch (Exception e) {
		}
		
		return "redirect:/public/product/%d".formatted(id);
	}
	
	String deletePhoto() {
		// TODO
		return "";
	}

}
