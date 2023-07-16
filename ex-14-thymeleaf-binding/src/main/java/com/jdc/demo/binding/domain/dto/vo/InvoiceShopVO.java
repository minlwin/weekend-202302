package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.InvoiceShop;

public class InvoiceShopVO implements Serializable{

	private static final long serialVersionUID = 1L;

	public static InvoiceShopVO from(InvoiceShop entity) {
		var vo = new InvoiceShopVO();
		
		return vo;
	}

}
