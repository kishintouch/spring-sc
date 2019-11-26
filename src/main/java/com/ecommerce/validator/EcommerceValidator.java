package com.ecommerce.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



@Component
public abstract class EcommerceValidator implements Validator  {
	
	 public Errors validate(Object target,String bindExceptionName){
			BindException errors= new BindException(target, bindExceptionName);
			validate(target, errors);
			return errors;
	}

}
