package com.jdc.demo.binding.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AuditInfo {

	@Column(columnDefinition = "boolean default false")
	private boolean deleted;
	
	@CreatedDate
	@Column(name = "create_at")
	private LocalDateTime createAt;

	@CreatedBy
	@Column(name = "create_by")
	private String createBy;

	@LastModifiedDate
	@Column(name = "update_at")
	private LocalDateTime updateAt;

	@LastModifiedBy
	@Column(name = "update_by")
	private String updateBy;

}