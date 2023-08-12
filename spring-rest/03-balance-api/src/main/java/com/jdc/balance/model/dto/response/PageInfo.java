package com.jdc.balance.model.dto.response;

import org.springframework.data.domain.Page;

public record PageInfo(
		int currentPage,
		int pageSize,
		long totalSize) {
	
	public long totalPage() {
		var remain = totalSize % pageSize;
		var totalPage = totalSize / pageSize;
		return remain > 0 ? totalPage + 1 : totalPage;
	}

	public static<T> PageInfo of(Page<T> page) {
		return new PageInfo(page.getNumber(), page.getSize(), page.getTotalElements());
	}

}
