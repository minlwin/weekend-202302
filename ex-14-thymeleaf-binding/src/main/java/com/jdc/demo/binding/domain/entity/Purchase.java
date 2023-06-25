package com.jdc.demo.binding.domain.entity;

import java.time.LocalDateTime;

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

@Data
@Entity
@Table(name = "PURCHASE")
@EntityListeners(value = AuditingEntityListener.class)
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private Account customer;

	@Column(name = "sale_at")
	private LocalDateTime saleTime;

	@Column(nullable = false)
	private Status status;

	private int subTotal;

	private int tax;
	
	private AuditInfo audit = new AuditInfo();

	public enum Status {
		Ordered,
		Delivered,
		Cancel,
		Finished
	}

}