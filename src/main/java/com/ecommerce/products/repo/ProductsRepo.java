package com.ecommerce.products.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;

import com.ecommerce.products.entity.ProductsEntity;

public interface ProductsRepo extends JpaRepository<ProductsEntity, BigInteger> {

	
}
