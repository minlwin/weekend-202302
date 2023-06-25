package com.jdc.demo.binding.domain.entity;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT")
@EntityListeners(value = AuditingEntityListener.class)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@ManyToOne(optional = false)
	private Category category;
	
	@Column(nullable = false)
	private String brand;

	private String coverImage;
	private List<String> images;

	@ElementCollection
	@CollectionTable(name = "PRODUCT_FEATURES")
	private List<Feature> features;

	private int price;
	
	private AuditInfo audit = new AuditInfo();

}