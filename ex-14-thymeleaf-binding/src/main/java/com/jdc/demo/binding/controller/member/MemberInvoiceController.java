package com.jdc.demo.binding.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/invoice")
public class MemberInvoiceController {

	@GetMapping("{id}")
	String showDetails(@PathVariable int id) {
		return "invoice/details";
	}
}
