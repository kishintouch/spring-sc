package com.ecommerce.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.order.entity.*;
import com.ecommerce.order.repo.*;
import com.ecommerce.order.model.*;
import com.ecommerce.cart.repo.*;
import com.ecommerce.common.exception.AppException;
import com.ecommerce.common.exception.ProductError;
import com.ecommerce.common.exception.UserError;
import com.ecommerce.user.repo.*;
import com.ecommerce.cart.entity.*;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import com.ecommerce.email.service.*;
import com.ecommerce.user.entity.*;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo ;
	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	UserDetailsRepo userRepo;
	
	@Autowired
	EmailService emailService;
	
	public BigInteger placeOrder(BigInteger userId) {
		
		List<CartEntity> userCart = cartRepo.getCartDetailsByUser(userId.longValue());
		
		OrderEntity ordEntity = new OrderEntity();
		ordEntity.setOrderDesc("Order");
		ordEntity.setOrdertype("FastTrack");
		
		List<OrderDetailsEntity> orderdetailsEntities = new ArrayList<>();
		
		for(CartEntity cartEntity : userCart) {
			OrderDetailsEntity orderDet = new OrderDetailsEntity();
			orderDet.setUserId(cartEntity.getUserDetails().getId());
			orderDet.setProductId(cartEntity.getProdEntity().getId());	
			orderdetailsEntities.add(orderDet);
		}
		ordEntity.setDetailsEntities(orderdetailsEntities);
		
		OrderEntity placedOrder =  orderRepo.save(ordEntity);
		
		//Email Order Details to User
		UserDetailsEntity userDet = userRepo.findById(userId).orElseThrow(() -> new AppException(UserError.USER_NOT_FOUND));
		String subject = "Order Placed Successfully";
		String body = "Dear Customer Your Order with Reference Number " + placedOrder.getId() + " .Is Placed Successfully .Your Shipment will reach you to Shipping Address";
		
		emailService.send(userDet.getEmailAddress(), subject, body);
		// Clear Cart
		//cartRepo.c
		
		return placedOrder.getId();
	}

}
