package com.jdc.balance.model.entity;

import com.jdc.balance.model.enums.LedgerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "seq_ledger", allocationSize = 1)
public class Ledger {

	@Id
	@GeneratedValue(generator = "seq_ledger")
	private int id;
	
	@Column(nullable = false)
	private LedgerType type;
	@Column(nullable = false)
	private String name;
	
	@ManyToOne(optional = false)
	private Member owner;
}
