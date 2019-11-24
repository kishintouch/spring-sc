package com.ecommerce.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.user.entity.UserLoginEntity;

public interface UserLoginRepo extends JpaRepository<UserLoginEntity,Long >{
	
	UserLoginEntity findByUsername(String username);
}
