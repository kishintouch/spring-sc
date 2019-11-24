package com.ecommerce.cart.service.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.cart.model.CartModel;
import com.ecommerce.cart.model.CartProductModel;
import com.ecommerce.cart.repo.CartRepo;
import com.ecommerce.cart.service.CartService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {
	
	@Mock
	CartRepo cartRepo;

	@InjectMocks
	CartService cartService = new CartService();
	
	@Test
	public void testSaveCartWithNull() {
		cartService.save(null);
	}
	

	@Test
	public void testSaveCartWithEmpty() {
		CartModel model = new CartModel();
		cartService.save(model);
	}
	

	@Test
	public void testSaveCart() {
		CartModel model = new CartModel();
		model.setCartProducts(new CartProductModel());
		cartService.save(model);
	}
	
}
