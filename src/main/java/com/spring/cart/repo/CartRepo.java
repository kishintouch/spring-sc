package com.ecommerce.cart.repo;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.cart.entity.CartEntity;


public interface CartRepo extends JpaRepository<CartEntity, BigInteger> {

	@Query("SELECT cart FROM CartEntity cart WHERE cart.userDetails.Id = ?1")
	List<CartEntity> getCartDetailsByUser(BigInteger id);
	
	@Query("SELECT cart FROM CartEntity cart WHERE cart.userDetails.Id = ?1 AND cart.prodEntity.Id = ?2")
	CartEntity getProductByUser(BigInteger userId,BigInteger productId);
}
