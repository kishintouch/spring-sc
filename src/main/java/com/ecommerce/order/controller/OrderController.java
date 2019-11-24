package com.ecommerce.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.order.service.*;
import java.math.BigInteger;;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(path = "/order/{userId}", method = RequestMethod.POST)
	public BigInteger placeOrder(@PathVariable("userId") BigInteger userId) {
		return orderService.placeOrder(userId);
	}
}
