package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jdc.demo.binding.domain.entity.Invoice;
import com.jdc.demo.binding.domain.entity.Invoice.Status;

import lombok.Data;

@Data
public class InvoiceListVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private LocalDateTime time;
	private Status status;
	private int count;
	private int subTotal;
	
	public int getTax() {
		return subTotal / 100 * 5;
	}
	
	public int getTotal() {
		return getTax() + subTotal;
	}

	public static InvoiceListVO from(Invoice entity) {
		var vo = new InvoiceListVO();
		vo.id = entity.getId();
		vo.time = entity.getSaleTime();
		vo.status = entity.getInvoicesForShops().stream().map(a -> a.getStatus())
				.sorted((a, b) -> b.compareTo(a)).findFirst().get();
		vo.count = entity.getInvoicesForShops().stream().flatMap(a -> a.getItems().stream())
				.mapToInt(a -> a.getQuentity()).sum();
		vo.subTotal = entity.getInvoicesForShops().stream().flatMap(a -> a.getItems().stream())
				.mapToInt(a -> a.getQuentity() * a.getSalePrice()).sum();
		return vo;
	}
}
