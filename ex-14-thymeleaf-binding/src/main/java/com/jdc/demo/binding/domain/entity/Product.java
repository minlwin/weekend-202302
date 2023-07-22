package com.jdc.demo.binding.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
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
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@ManyToOne(optional = false)
	private Category category;
	
	@ManyToOne(optional = false)
	private Shop shop;
	
	@Column(nullable = false)
	private String brand;

	private String coverImage;
	private int price;

	@ElementCollection
	@CollectionTable(name = "PRODUCT_IMAGES")
	private List<String> images = new ArrayList<>();

	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PRODUCT_FEATURES")
	private List<Feature> features = new ArrayList<>();

	
	private AuditInfo audit = new AuditInfo();


	public void addImages(List<String> photos) {
		images.addAll(photos);
	}

}