package com.ecommerce.user.test;


import java.util.*;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AddUser {
	
	public static void setup() {
	    //RestAssured.baseURI = "http://localhost:9999/shoppingcart";
	    RestAssured.baseURI = "http://localhost:8080/";
	}

	
	public void addUser()
	{
		try {
			
			RequestSpecification httpRequest = RestAssured.given();
			FileInputStream fileInputStream = new FileInputStream(new File(".//TestData//AddUserRequest.json"));
							
			httpRequest.header("Content-Type","application/json").accept("application/json");
			httpRequest.body(IOUtils.toString(fileInputStream,"UTF-8"));
			Response response=httpRequest.post("/user");
			int statusCode = response.getStatusCode();
			System.out.println("Response " + response.getBody().toString());
			assertEquals(204, statusCode,"Invalid Code Received");
			
			assertEquals(400, statusCode,"User Already Exists");
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
	}
}
