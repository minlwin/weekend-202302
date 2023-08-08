package com.jdc.balance.model.dto.response;

import org.springframework.data.domain.Page;

public record PageInfo(
		int currentPage,
		int pageSize,
		long totalSize) {

	public static<T> PageInfo of(Page<T> page) {
		return new PageInfo(page.getNumber(), page.getSize(), page.getTotalElements());
	}

}
