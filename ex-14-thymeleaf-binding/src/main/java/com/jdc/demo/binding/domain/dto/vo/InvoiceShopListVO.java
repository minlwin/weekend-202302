package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jdc.demo.binding.domain.entity.Invoice.Status;
import com.jdc.demo.binding.domain.entity.InvoiceShop;

import lombok.Data;

@Data
public class InvoiceShopListVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int invoiceId;
	private int shopId;
	private String shop;
	private Status status;
	private LocalDateTime invoiceTime;
	private String customer;
	private String email;
	private int items;
	private int subTotal;
	
	public int getTax() {
		return subTotal / 100 * 5;
	}
	
	public int getTotal() {
		return subTotal + getTax();
	}

	public static InvoiceShopListVO from(InvoiceShop entity) {
		var vo = new InvoiceShopListVO();
		vo.id = entity.getId();
		vo.invoiceId = entity.getInvoice().getId();
		vo.shopId = entity.getId();
		vo.shop = entity.getShop().getName();
		vo.status = entity.getStatus();
		vo.invoiceTime = entity.getInvoice().getSaleTime();
		vo.email = entity.getInvoice().getCustomer().getEmail();
		vo.customer = entity.getInvoice().getCustomer().getName();
		vo.items = entity.getItems().stream().mapToInt(a -> a.getQuentity()).sum();
		vo.subTotal = entity.getItems().stream().mapToInt(a -> a.getQuentity() * a.getSalePrice()).sum();
		return vo;
	}
}
