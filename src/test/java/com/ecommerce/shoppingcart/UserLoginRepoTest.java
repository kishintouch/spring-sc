package com.ecommerce.shoppingcart;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.*;

import com.ecommerce.user.repo.UserLoginRepo;
import com.ecommerce.user.entity.UserLoginEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserLoginRepoTest {

    @Autowired
    UserLoginRepo userLoginRepo;

    @Test
    public void myTest() throws Exception {
    	
    	//UserLoginEntity userLoginEntity = userLoginRepo.findByUsername("kishintouch@gmail.com");
    	
    	UserLoginEntity userLoginEntity = userLoginRepo.findByUsername("kishintouch@gmail.com");
    	
    	
    	if(userLoginEntity == null) {
    		System.out.println("User Not Retrieved");
    	}else {
    		System.out.println("User : " + userLoginEntity.getUsername());
    	}
        
    }
}