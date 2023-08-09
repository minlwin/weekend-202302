package com.jdc.balance.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Auditor {

	private int auditorId;
	private String auditorName;
	
	public static Auditor of(Member member) {
		
		if(null != member) {
			var dto = new Auditor();
			dto.setAuditorId(member.getId());
			dto.setAuditorName(member.getName());
			return dto;
		}
		
		return null;
	}
}
