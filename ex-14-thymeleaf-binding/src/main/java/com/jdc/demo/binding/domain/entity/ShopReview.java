package com.jdc.demo.binding.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SHOP_REVIEW")
public class ShopReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	private Account reviewer;
	@ManyToOne(optional = false)
	private Shop shop;
	
	@Column(nullable = false)
	private int rating;
	@Column(nullable = false)
	private String comment;
	
	@Column(name = "review_at")
	private LocalDateTime reviewAt;
}
