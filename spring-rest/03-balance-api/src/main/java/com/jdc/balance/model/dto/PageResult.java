package com.jdc.balance.model.dto;

import java.util.List;

public record PageResult<T>(
		List<T> content,
		PageInfo page
 		) {

}
