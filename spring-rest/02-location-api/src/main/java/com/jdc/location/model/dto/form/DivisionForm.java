package com.jdc.location.model.dto.form;

import jakarta.validation.constraints.NotBlank;

public record DivisionForm(
		@NotBlank(message = "Please enter division name.")
		String name,
		@NotBlank(message = "Please enter burmese name.")
		String burmese,
		@NotBlank(message = "Please enter region name.")
		String region,
		@NotBlank(message = "Please enter capital name.")
		String capital
		) {

}
