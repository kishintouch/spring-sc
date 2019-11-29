package com.shoppingcart.functionaltest;


import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class AddUser {
	
	@BeforeClass
	public static void setup() {
		
	    RestAssured.baseURI = "http://localhost:9999/shoppingcart";
	    //RestAssured.port = 443;
	}

	@Test
	public void addUser()
	{
		//RestAssured.baseURI="" ;
		
		Map<String,String> userData = new HashMap<>();
		userData.put("name", "kishore");
		userData.put("emailAddress", "uishintouch@gmail.com");
		userData.put("age", "20");
		userData.put("password","Server@39");
		userData.put("gender", "male");
		userData.put("deliveryAddress","298 PM road");
		userData.put("billingAddress","298 pm road");
		
		Response response=  RestAssured.given().body(userData).with()
		.contentType("application/json").then().expect()
		.when().post("/user").andReturn();
		
		System.out.println("Response " +  response);
		JsonPath jsonPathEvaluator = response.jsonPath();

		String id = jsonPathEvaluator.get("id");
		 
		 //Assert.assertEquals("Invalid id name received in the Response" ,"Rahmu" ,id);
	       System.out.println(id);
				
				
	}
	
	
}
