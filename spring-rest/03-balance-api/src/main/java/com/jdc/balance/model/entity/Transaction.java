package com.jdc.balance.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "seq_transaction", allocationSize = 1)
public class Transaction {

	@Id
	@GeneratedValue(generator = "seq_transaction")
	private long id;
	
	@ManyToOne(optional = false)
	private Member member;
	@ManyToOne(optional = false)
	private Ledger ledger;
	
	@Column(nullable = false)
	private LocalDate issueDate;
	@Column(nullable = false)
	private String issueUser;
	
	private boolean deleted;
	
	@CreatedDate
	private LocalDateTime createAt;
	
	@CreatedBy
	@AttributeOverride(name = "auditorId", column = @Column(name = "create_user_id"))
	@AttributeOverride(name = "auditorName", column = @Column(name = "create_user_name"))
	private Auditor createUser;

	@LastModifiedDate
	private LocalDateTime updateAt;
	
	@LastModifiedBy
	@AttributeOverride(name = "auditorId", column = @Column(name = "update_user_id"))
	@AttributeOverride(name = "auditorName", column = @Column(name = "update_user_name"))
	private Auditor updateUser;
}
