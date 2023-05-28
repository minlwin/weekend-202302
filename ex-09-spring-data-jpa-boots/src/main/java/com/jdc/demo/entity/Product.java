package com.jdc.demo.entity;

import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Category category;
	private String name;
	private int price;
	private String brand;
	
	@ElementCollection
	@MapKeyColumn(name = "name")
	private Map<String, String> features;
	
}
