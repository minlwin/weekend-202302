package com.jdc.demo.binding.domain.dto.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceSummaryVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int count;
	private int subTotal;
	private int tax;
	private int total;
}
