package com.jdc.demo.binding.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "INVOICE")
@EntityListeners(value = AuditingEntityListener.class)
public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private Account customer;

	@Column(name = "sale_at")
	private LocalDateTime saleTime;

	@ManyToOne
	private Address shipping;
	
	@OneToMany(mappedBy = "invoice", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<InvoiceShop> invoicesForShops = new ArrayList<>();
	
	private AuditInfo audit = new AuditInfo();

	public enum Status {
		Ordered,
		Delivered,
		Cancel,
		Finished
	}
	
	public void addInvoiceForShop(InvoiceShop shop) {
		shop.setInvoice(this);
		invoicesForShops.add(shop);
	}

}