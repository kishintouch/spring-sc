package com.ecommerce.products.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.model.ProductsModel;
import com.ecommerce.products.service.ProductService;


@RestController
public class ProductsController {
	
	@Autowired ProductService prodService ;
	
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> saveProducts(@Valid @RequestBody ProductsModel userDetailsModel) {
    	prodService.save(userDetailsModel);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(path = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<ProductsModel>> getAllProducts(){
    	List<ProductsModel> products = prodService.getAllProducts();
        return ResponseEntity.ok(products);
	}
}
