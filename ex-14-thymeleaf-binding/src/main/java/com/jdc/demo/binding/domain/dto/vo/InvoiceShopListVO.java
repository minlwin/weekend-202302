package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.InvoiceShop;

public class InvoiceShopListVO implements Serializable{

	private static final long serialVersionUID = 1L;

	public static InvoiceShopListVO from(InvoiceShop entity) {
		var vo = new InvoiceShopListVO();
		return vo;
	}
}
