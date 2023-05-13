package com.jdc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mrBot")
public class ChatBot {
	
	@Autowired
	private Dictionary dictionary;
	
	private String keyword;
	
	public String talk(String message) {
		
		// Ask to robot
		if(null == keyword) {
			var answer = dictionary.search(message);
			
			if(answer == null) {
				keyword = message;
				return "I've no idea. Please teach me.";
			}
			
			return answer;
		}
		
		dictionary.register(keyword, message);
		keyword = null;
		
		return "Thank you for your kindness.";
	}
}
