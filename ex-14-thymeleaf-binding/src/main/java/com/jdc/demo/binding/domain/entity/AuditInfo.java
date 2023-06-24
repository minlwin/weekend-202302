package com.jdc.demo.binding.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AuditInfo {

	@Column(columnDefinition = "boolean default false")
	private boolean deleted;
	
	@Column(name = "create_at")
	private LocalDateTime createAt;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "update_at")
	private LocalDateTime updateAt;

	@Column(name = "update_by")
	private String updateBy;

}