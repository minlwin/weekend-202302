package com.jdc.demo.binding.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.demo.binding.domain.entity.Invoice.Status;

import jakarta.persistence.CascadeType;
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
@Table(name = "INVOICE_SHOP")
@EntityListeners(value = AuditingEntityListener.class)
public class InvoiceShop implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Invoice invoice;

	private Status status;

	@OneToMany(mappedBy = "shop", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<InvoiceItem> items = new ArrayList<>();
	
	private AuditInfo audit = new AuditInfo();
	
	public void addItem(InvoiceItem item) {
		item.setShop(this);
		items.add(item);
	}

}
