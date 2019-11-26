package com.ecommerce.cart.service.test;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.Assert;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.products.entity.*;
import com.ecommerce.user.entity.UserDetailsEntity;
import com.ecommerce.cart.entity.CartEntity;
import com.ecommerce.cart.model.CartModel;
import com.ecommerce.cart.model.CartProductModel;
import com.ecommerce.cart.repo.CartRepo;
import com.ecommerce.cart.service.CartService;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

	@Mock
	CartRepo cartRepo;

	@InjectMocks
	CartService cartService ;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		// cartRepo = Mockito.mock(CartRepo.class);
	}

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

	@Test
	public void getCartProducts() {

		UserDetailsEntity userEntity = new UserDetailsEntity();

		userEntity.setId(BigInteger.valueOf(1));

		ProductsEntity prodEntity = new ProductsEntity();
		prodEntity.setId(BigInteger.valueOf(2));
		prodEntity.setProductName("Nokia");
		prodEntity.setProductPrice(BigInteger.valueOf(300));
		prodEntity.setProductCatageory("Mobile");
		prodEntity.setProductModel("123");

		CartEntity entity = new CartEntity();
		entity.setId(BigInteger.valueOf(2));
		entity.setQuantity(BigInteger.valueOf(4));
		entity.setProdEntity(prodEntity);
		entity.setUserDetails(userEntity);

		List<CartEntity> entities = new ArrayList<CartEntity>();
		entities.add(entity);

		Mockito.when(cartRepo.getCartDetailsByUser(BigInteger.valueOf(2))).thenReturn(entities);
		List<CartProductModel> cartProductModels = cartService.getCartProducts(BigInteger.valueOf(2));
		for (CartProductModel c : cartProductModels) {
			System.out.println(c.getProductName());
			Assert.assertEquals("Invalid Product Name","Nokia",c.getProductName());
		}
	}

}
