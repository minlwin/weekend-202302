package com.jdc.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dictionary {

	@Autowired
	private Map<String, String> memory;
	
	public String search(String keyword) {
		return memory.get(keyword);
	}
	
	public void register(String keyword, String definition) {
		memory.put(keyword, definition);
	}
}
