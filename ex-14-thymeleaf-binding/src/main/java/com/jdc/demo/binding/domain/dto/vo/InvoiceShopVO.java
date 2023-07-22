package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.binding.domain.dto.form.AddressForm;
import com.jdc.demo.binding.domain.entity.InvoiceShop;

import lombok.Data;

@Data
public class InvoiceShopVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String email;
	private String customerName;
	private List<InvoiceItemVO> items = new ArrayList<>();
	private InvoiceSummaryVO summary;
	private AddressForm shipping;
	
	public static InvoiceShopVO from(InvoiceShop entity) {
		var vo = new InvoiceShopVO();
		vo.id = entity.getId();
		vo.email = entity.getInvoice().getCustomer().getEmail();
		vo.customerName = entity.getInvoice().getCustomer().getName();
		vo.items = entity.getItems().stream().map(InvoiceItemVO::from).toList();
		vo.summary = InvoiceSummaryVO.from(entity);
		vo.shipping = AddressForm.from(entity.getInvoice().getShipping());
		return vo;
	}

}
