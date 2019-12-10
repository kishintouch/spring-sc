package com.ecommerce.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.user.entity.UserDetailsEntity;
import com.ecommerce.user.entity.UserLoginEntity;

import java.math.BigInteger;

public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity, BigInteger> {

	UserDetailsEntity findByEmailAddress(String emailAddress);
}