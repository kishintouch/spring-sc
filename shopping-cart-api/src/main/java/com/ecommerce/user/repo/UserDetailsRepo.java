package com.ecommerce.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.cart.entity.CartEntity;
import com.ecommerce.user.entity.UserDetailsEntity;
import com.ecommerce.user.entity.UserLoginEntity;

import java.math.BigInteger;

public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity, BigInteger> {

	UserDetailsEntity findByEmailAddress(String emailAddress);
	
	@Query("SELECT userDetailsEntity FROM UserDetailsEntity userDetailsEntity WHERE userDetailsEntity.userloginEntity.id = ?1 ")
	UserDetailsEntity getUserByLoginId(Long userId);
	
}
