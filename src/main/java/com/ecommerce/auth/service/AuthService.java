package com.ecommerce.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.ecommerce.user.model.PermissionModel;
import com.ecommerce.user.model.UserLoginModel;
import com.ecommerce.user.service.UserService;
import com.ecommerce.auth.model.*;
import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.stream.Collectors;

@Component
public class AuthService implements UserDetailsService {
	
	@Autowired
	UserService userservice ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLoginModel loginModel = userservice.getUserForLogin(username);
		
        if (loginModel == null) {
            //throw new UsernameNotFoundException(username);
        }
        List<PermissionModel> permissions = new ArrayList<PermissionModel>();
        
        PermissionModel per = new PermissionModel();
        per.setId((long) 1);
        per.setName("user");
        per.setDescription("default user");
        

        permissions.add(per);

        Set<GrantedAuthority> authorities = permissions.stream().map((permission) -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(permission.getName());
            return authority;
        }).collect(Collectors.toSet());
        
        AppUserDetails userDetails = new AppUserDetails(username, loginModel.getPassword(), authorities);
        userDetails.setFirstname(loginModel.getUsername());
        userDetails.setUserId(loginModel.getId());
		return userDetails;
	}

}
