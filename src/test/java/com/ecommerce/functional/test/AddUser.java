package com.ecommerce.functional.test;


import java.util.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import  io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class AddUser {
	
	@BeforeClass
	public static void setup() {
		
		String port = System.getProperty("server.port");
		System.out.println("port " + port);
	    RestAssured.baseURI = "http://localhost:8080/";
	    //RestAssured.port = 443;
	}

	@Test
	public void addUser()
	{
		//RestAssured.baseURI="" ;
		
		Map<String,String> userData = new HashMap<>();
		userData.put("name", "kishore");
		userData.put("emailAddress", "kishintouch@gmail.com");
		userData.put("age", "20");
		userData.put("password","test");
		userData.put("gender", "male");
		userData.put("deliveryAddress","298 PM road");
		userData.put("billingAddress","298 pm road");
		
		Response response=  given().body(userData).with()
		.contentType("application/json").then().expect()
		.when().post("/user").andReturn();
		
		System.out.println("Response " +  response);
		JsonPath jsonPathEvaluator = response.jsonPath();

		String id = jsonPathEvaluator.get("id");
		 
		 //Assert.assertEquals("Invalid id name received in the Response" ,"Rahmu" ,id);
	       System.out.println(id);
				
				
	}
	
	
}
