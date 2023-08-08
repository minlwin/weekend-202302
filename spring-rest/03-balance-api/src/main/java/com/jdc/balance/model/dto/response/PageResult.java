package com.jdc.balance.model.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;

public record PageResult<T>(
		List<T> content,
		PageInfo page) {
	
	public static<T> PageResult<T> of(Page<T> page) {
		return new PageResult<T>(page.getContent(), PageInfo.of(page));
	}
}
