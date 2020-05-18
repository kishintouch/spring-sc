package com.ecommerce.user.controller;

import javax.validation.Valid;
//import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import com.ecommerce.user.model.*;
import org.springframework.validation.BindException;
import com.ecommerce.user.service.UserService;
import com.ecommerce.validator.ValidatorFactory;
import com.ecommerce.user.validator.PasswordValidator;

@RestController
public class UserController {

	
	@Autowired UserService userService ;
	
	
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDetailsModel userDetailsModel) {
    	
    	PasswordValidator passwordValidator = ValidatorFactory.get(PasswordValidator.class);
    	BindException errors= new BindException( userDetailsModel,"passwordValidator");
    	passwordValidator.validate(userDetailsModel, errors);
    	
    	if(!errors.hasErrors()){
    		userService.save(userDetailsModel);
            return ResponseEntity.noContent().build();		
    	}else {
    		 return ResponseEntity.noContent().build();	
    	}
    	
    
    }
    
}
