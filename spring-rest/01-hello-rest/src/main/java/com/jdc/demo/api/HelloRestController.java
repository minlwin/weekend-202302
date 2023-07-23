package com.jdc.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.demo.model.dto.Message;
import com.jdc.demo.model.dto.Message.Type;

@RestController
@RequestMapping("hello")
public class HelloRestController {

	@GetMapping
	Message sayHello() {
		return new Message(Type.Info, "Hello from REST Controller");
	}
}
