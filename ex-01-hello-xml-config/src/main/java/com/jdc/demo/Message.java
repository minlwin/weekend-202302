package com.jdc.demo;

import lombok.Data;

@Data
public class Message implements ValueHolder{

	private String value;
	private String type;

	public Message(String value) {
		super();
		this.value = value;
	}
}
