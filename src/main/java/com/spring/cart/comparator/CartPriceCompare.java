package com.ecommerce.cart.comparator;
import java.util.*;

import org.springframework.stereotype.Component;
import com.ecommerce.cart.model.*;


@Component
public class CartPriceCompare implements Comparator<CartProductModel> 
{ 

	@Override
	public int compare(CartProductModel o1, CartProductModel o2) {
		int res =  o1.getProductPrice().compareTo(o2.getProductPrice());
		System.out.println("res " + res);
		 return res;
	} 
} 