package com.ecommerce.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ecommerce.user.entity.UserDetailsEntity;
import com.ecommerce.user.entity.UserLoginEntity;
import com.ecommerce.user.model.UserDetailsModel;
import com.ecommerce.user.model.UserLoginModel;
import com.ecommerce.user.repo.UserDetailsRepo;
import com.ecommerce.user.repo.UserLoginRepo;
import com.ecommerce.user.mapper.UserMapper;
import com.ecommerce.common.exception.*;

@Component
public class UserService {
		
	@Autowired
	UserDetailsRepo userRepo ;
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserMapper userMapper ;
	
	public void save(UserDetailsModel userDetailsModel) {
		UserDetailsEntity userDetails = userRepo.findByEmailAddress(userDetailsModel.getEmailAddress());
		if(userDetails == null) {
			UserDetailsEntity userDetailsEntity = userMapper.toUserDetailsEntity(userDetailsModel);
			userRepo.save(userDetailsEntity);
		}else {
			throw new AppException(UserError.USER_EXISTS);
		}
	}
	
    public UserLoginModel getUserForLogin(String username) {
        UserLoginEntity userEntity = userLoginRepo.findByUsername(username);
        if (userEntity == null) {
            throw new AppException(UserError.USER_NOT_FOUND);
        }

        UserLoginModel user = userMapper.toUserLoginDetails(userEntity);
        user.setPassword(userEntity.getPassword());
        return user;
    }
}
