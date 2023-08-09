package com.jdc.balance.model.entity;

import java.time.LocalDateTime;

import com.jdc.balance.model.enums.AccessStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_access_log", allocationSize = 1)
public class AccessLog {

	@Id
	@GeneratedValue(generator = "seq_access_log")
	private long id;
	private LocalDateTime access = LocalDateTime.now();
	private String username;
	private AccessStatus status;
	
}
