package com.jdc.demo.binding.domain.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.demo.binding.domain.entity.Invoice.Status;

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
@Table(name = "PURCHASE_SHOP")
@EntityListeners(value = AuditingEntityListener.class)
public class InvoiceShop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Invoice purchase;

	private Status status;

	private int subTotal;

	private int tax;
	
	private AuditInfo audit = new AuditInfo();

}
