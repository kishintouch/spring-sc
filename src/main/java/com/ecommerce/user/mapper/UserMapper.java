package com.ecommerce.user.mapper;

import org.springframework.stereotype.Component;

import com.ecommerce.user.entity.UserDetailsEntity;
import com.ecommerce.user.entity.UserLoginEntity;
import com.ecommerce.user.model.UserDetailsModel;
import com.ecommerce.user.model.UserLoginModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
	
	
	public UserDetailsModel toUserDetails(UserDetailsEntity entity){
		
		UserDetailsModel userModel = new UserDetailsModel();
		return toUserDetails(entity,userModel);
		
	}
	
	public UserDetailsModel toUserDetails(UserDetailsEntity entity,UserDetailsModel userModel){
		userModel.setId(entity.getId());
		userModel.setName(entity.getName());
		userModel.setEmailAddress(entity.getEmailAddress());
		userModel.setAge(entity.getAge());
		userModel.setGender(entity.getGender());
	
		return userModel;
		
	}
	
   public List<UserDetailsModel> toUserDetails(List<UserDetailsEntity> userDetailsEntities) {
        if (userDetailsEntities == null) {
            return new ArrayList<>();
        }

        List<UserDetailsModel> users = userDetailsEntities.stream().map(this::toUserDetails).collect(Collectors.toList());

        return users;
    }
   
   
	public UserDetailsEntity toUserDetailsEntity(UserDetailsModel model, UserDetailsEntity entity) {
		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setAge(model.getAge());
		entity.setBillingAddress(model.getBillingAddress());
		entity.setDeliveryAddress(model.getDeliveryAddress());
		entity.setEmailAddress(model.getEmailAddress());
		entity.setGender(model.getGender());
		
		UserLoginEntity loginEntity = new UserLoginEntity();
		//loginEntity.setId(id);
		loginEntity.setUsername(model.getEmailAddress());
		loginEntity.setPassword(model.getPassword());
		
		entity.setUserloginEntity(loginEntity);
		
		
		return entity;

	}
	
	public UserDetailsEntity toUserDetailsEntity(UserDetailsModel model) {
		UserDetailsEntity userDetail = new UserDetailsEntity();
		return toUserDetailsEntity(model, userDetail);
	}
   
	public UserLoginModel toUserLoginDetails(UserLoginEntity entity){
		
		UserLoginModel userModel = new UserLoginModel();
		return toUserLoginDetails(entity,userModel);
		
	}
	
	public UserLoginModel toUserLoginDetails(UserLoginEntity entity,UserLoginModel loginModel){
		loginModel.setId(entity.getId());
		loginModel.setUsername(entity.getUsername());
		loginModel.setPassword(entity.getPassword());
		
		return loginModel;
		
	}
	


}
