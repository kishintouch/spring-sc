package com.ecommerce.cart.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import com.ecommerce.cart.model.*;
import com.ecommerce.cart.service.CartService;
import com.ecommerce.products.entity.*;

@RestController
public class CartController {
	
	@Autowired CartService cartService ;
	
    @RequestMapping(path = "/cart", method = RequestMethod.POST)
    public ResponseEntity<?> saveCart(@Valid @RequestBody CartModel cartModel) {
    	cartService.save(cartModel);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(path = "/cart", method = RequestMethod.GET)
	public ResponseEntity<List<CartModel>> getAllCarts(){
    	List<CartModel> products = cartService.getAllCarts();
        return ResponseEntity.ok(products);
	}
    
    @RequestMapping(path = "/cart/{userid}", method = RequestMethod.GET)
	public ResponseEntity<List<CartProductModel>> getCartProducts(@PathVariable("userid") BigInteger userid){
    	List<CartProductModel> products = cartService.getCartProducts(userid);
        return ResponseEntity.ok(products);
	}
    
   
    
    @RequestMapping(path = "/cart/{cartid}", method = RequestMethod.PATCH)
    public ResponseEntity<List<CartProductModel>>  updateCartQuantity(@PathVariable("cartid") BigInteger cartid, @Valid @RequestBody CartModel cartModel) {
    	cartService.updateCartQuantity(cartid, cartModel);
    	List<CartProductModel> products = cartService.getCartProducts(cartModel.getUserId());
        return ResponseEntity.ok(products);
       
    }
    
    @RequestMapping(path = "/cart/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?>  updateCart(@PathVariable("id") BigInteger id, @Valid @RequestBody CartModel cartModel) {
    	cartService.update(id, cartModel);
    	//List<CartProductModel> products = cartService.getCartProducts(cartModel.getUserId());
    	return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(path = "/user/{userid}/cart/{cartid}", method = RequestMethod.DELETE)
    public  ResponseEntity<List<CartProductModel>> deleteCartItem(@PathVariable("cartid") BigInteger cartid,@PathVariable("userid") BigInteger userid) {
    	cartService.delete(cartid);
    	List<CartProductModel> products = cartService.getCartProducts(userid);
        return ResponseEntity.ok(products);
    }
    
    @RequestMapping(path = "/user/cart/{userid}", method = RequestMethod.DELETE)
    public  ResponseEntity<?> deleteCartByUser(@PathVariable("userid") BigInteger userid) {
    	cartService.deleteCartByUserId(userid);
    	return ResponseEntity.noContent().build();
    }
    
}
