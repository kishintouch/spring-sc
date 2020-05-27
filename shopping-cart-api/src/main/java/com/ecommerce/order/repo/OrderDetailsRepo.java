package com.ecommerce.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;
import com.ecommerce.order.entity.*;
public interface OrderDetailsRepo extends JpaRepository<OrderDetailsEntity,BigInteger> {

}
