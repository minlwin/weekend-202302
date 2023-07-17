package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jdc.demo.binding.domain.entity.Invoice;
import com.jdc.demo.binding.domain.entity.Invoice.Status;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InvoiceSummaryVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final int count;
	private final int subTotal;

	private Integer id;
	private LocalDateTime time;
	private Status status;
	
	public int getTax() {
		return subTotal / 100 * 5;
	}
	
	public int getTotal() {
		return subTotal + getTax();
	}
	
	public InvoiceSummaryVO id(int id) {
		this.id = id;
		return this;
	}
	
	public InvoiceSummaryVO time(LocalDateTime time) {
		this.time = time;
		return this;
	}
	
	public InvoiceSummaryVO status(Status status) {
		this.status = status;
		return this;
	}
	
	public static InvoiceSummaryVO from(Invoice entity) {
		var count = entity.getInvoicesForShops().stream()
				.flatMap(a -> a.getItems().stream()).mapToInt(a -> a.getQuentity()).sum();
		var subTotal = entity.getInvoicesForShops().stream()
				.flatMap(a -> a.getItems().stream()).mapToInt(a -> a.getQuentity() * a.getSalePrice()).sum();
		var status = entity.getInvoicesForShops().stream().map(a -> a.getStatus())
				.sorted((a, b) -> b.compareTo(a)).findFirst().get();
		return new InvoiceSummaryVO(count, subTotal).id(entity.getId())
				.status(status).time(entity.getSaleTime());
	}
}
