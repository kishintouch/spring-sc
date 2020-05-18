package com.ecommerce.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;
import com.ecommerce.order.entity.*;

public interface OrderRepo extends JpaRepository<OrderEntity, BigInteger>{

}
