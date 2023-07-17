package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.binding.domain.dto.form.AddressForm;
import com.jdc.demo.binding.domain.entity.Invoice;

import lombok.Data;

@Data
public class InvoiceVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<InvoiceItemVO> items = new ArrayList<>();
	private InvoiceSummaryVO summary;
	private AddressForm shipping;
	
	public static InvoiceVO from(Invoice entity) {
		var vo = new InvoiceVO();
		vo.items = entity.getInvoicesForShops().stream().flatMap(a -> a.getItems().stream())
				.map(InvoiceItemVO::from).toList();
		vo.summary = InvoiceSummaryVO.from(entity);
		vo.shipping = AddressForm.from(entity.getShipping());
		return vo;
	}
}
