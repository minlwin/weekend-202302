package com.jdc.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	private Type type;
	private String message;

	public enum Type {
		Info, Warning, Error
	}
}
