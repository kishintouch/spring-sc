package com.ecommerce.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ecommerce.auth.config.TokenAuthenticationService;
import com.ecommerce.auth.model.AuthRequest;
import com.ecommerce.auth.model.AppUserDetails;
import  com.ecommerce.auth.model.AuthResponse;

@RestController
public class AuthController {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public AuthResponse login(@Valid @RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            AuthResponse authResponse = new AuthResponse();
            AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();
            authResponse.setFirstname(appUserDetails.getFirstname());
            authResponse.setToken(TokenAuthenticationService.getJWTToken(request.getUsername()));
            authResponse.setId(appUserDetails.getUserId());
            return authResponse;
        }

        return null;

    }
}
