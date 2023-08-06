package com.jdc.balance.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Auditor {

	private String auditorId;
	private String auditorName;
}
