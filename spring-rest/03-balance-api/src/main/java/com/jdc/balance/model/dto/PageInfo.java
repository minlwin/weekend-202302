package com.jdc.balance.model.dto;

public record PageInfo(
		int currentPage,
		int pageSize,
		int totalSize
		) {

}
