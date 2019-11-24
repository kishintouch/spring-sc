package com.ecommerce.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import com.ecommerce.user.model.*;

import com.ecommerce.user.service.UserService;

@RestController
public class UserController {

	
	@Autowired UserService userService ;
	
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDetailsModel userDetailsModel) {
    	userService.save(userDetailsModel);
        return ResponseEntity.noContent().build();
    }
    
}
