package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.Invoice;

public class InvoiceDetailsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public static InvoiceDetailsVO from(Invoice entity) {
		var vo = new InvoiceDetailsVO();
		
		return vo;
	}
}
