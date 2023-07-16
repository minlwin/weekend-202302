package com.jdc.demo.binding.domain.dto.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseSummaryVO {

	private int count;
	private int subTotal;
	private int tax;
	private int total;
}
