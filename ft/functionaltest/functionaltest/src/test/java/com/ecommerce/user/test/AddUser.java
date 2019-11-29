package com.ecommerce.user.test;


import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.File;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
		try {
			
		RequestSpecification httpRequest = RestAssured.given();
		FileInputStream fileInputStream = new FileInputStream(new File(".//TestData//AddUserRequest"));
				
		/*Map<String,String> userData = new HashMap<>();
		userData.put("name", "kishore");
		userData.put("emailAddress", "uishintouch@gmail.com");
		userData.put("age", "20");
		userData.put("password","Server@39");
		userData.put("gender", "male");
		userData.put("deliveryAddress","298 PM road");
		userData.put("billingAddress","298 pm road"); */
		
		
		httpRequest.header("Content-Type","application/json").accept("application/json");
		httpRequest.body(IOUtils.toString(fileInputStream,"UTF-8"));
		Response response=httpRequest.post("/user");
		int statysCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		Gson gson = new Gson();
		
		
		/*Response response=  RestAssured.given().body(userData).with()
		.contentType("application/json").then().expect()
		.when().post("/user").andReturn(); */
		
		
		
		System.out.println("Response " +  response);
		JsonPath jsonPathEvaluator = response.jsonPath();

		String id = jsonPathEvaluator.get("id");
		 
		 //Assert.assertEquals("Invalid id name received in the Response" ,"Rahmu" ,id);
	       System.out.println(id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
				
	}
	
	
}
