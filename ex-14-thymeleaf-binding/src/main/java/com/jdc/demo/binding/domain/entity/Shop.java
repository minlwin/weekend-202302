package com.jdc.demo.binding.domain.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "SHOP")
@NoArgsConstructor
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NonNull
	@Column(nullable = false)
	private String name;

	@NonNull
	@Column(name = "cover_image")
	private String coverImage;

	@NonNull
	@Column(nullable = false)
	private String greeting;
	
	@ManyToOne(optional = false)
	private Account owner;
	
	private AuditInfo audit = new AuditInfo();

}