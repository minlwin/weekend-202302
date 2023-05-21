package com.jdc.demo.service.entity;

import lombok.Data;

@Data
public class Course {

	private int id;
	private String name;
	private Level level;
	private int price;
	private int hours;
	private String description;
	
	public enum Level {
		Basic, Intermediate, Advance, Professional
	}
}
