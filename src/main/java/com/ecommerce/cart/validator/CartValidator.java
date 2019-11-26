package com.ecommerce.cart.validator;

import org.springframework.validation.Errors;

import com.ecommerce.validator.EcommerceValidator;

public class CartValidator extends EcommerceValidator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
