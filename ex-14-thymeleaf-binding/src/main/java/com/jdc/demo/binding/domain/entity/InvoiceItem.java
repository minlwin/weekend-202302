package com.jdc.demo.binding.domain.entity;

import java.io.Serializable;

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
@Table(name = "INVOICE_ITEM")
public class InvoiceItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private InvoiceShop shop;

	@ManyToOne(optional = false)
	private Product product;
	
	@Column(name = "sale_price", nullable = false)
	private int salePrice;

	@Column(nullable = false)
	private int quentity;

}