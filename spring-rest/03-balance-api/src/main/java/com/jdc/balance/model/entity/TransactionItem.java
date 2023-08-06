package com.jdc.balance.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_transaction_item", allocationSize = 1)
public class TransactionItem {
	
	@Id
	@GeneratedValue(generator = "seq_transaction_item")
	private long id;
	
	@ManyToOne(optional = false)
	private Transaction transaction;
	
	@Column(nullable = false)
	private int unitPrice;
	@Column(nullable = false)
	private int quantity;

}
