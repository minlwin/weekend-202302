package com.jdc.location.validation;

import com.jdc.location.model.repo.DivisionRepo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DivisionIdConstraint implements ConstraintValidator<DivisionId, Integer>{

	private final DivisionRepo repo;
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return repo.countById(value) > 0;
	}

}
