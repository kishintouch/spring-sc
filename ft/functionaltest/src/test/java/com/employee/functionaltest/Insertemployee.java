package com.employee.functionaltest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import org.junit.Test;
import org.json.*;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Insertemployee {

	
	@Test
	public  void insertdetails() throws IOException
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		
		FileInputStream fileInputStream = new FileInputStream(new File (".//jsonInput//test.json") );
		//create json objects to send the parameters
		/*JSONObject requestParams = new JSONObject();
		
		requestParams.put("name",  "ameren");
		requestParams.put("salary", 45121);
		requestParams.put("age", 27); */
			
		httpRequest.header("Content-Type","application/json").accept("application/json");
		httpRequest.body(IOUtils.toString(fileInputStream,"UTF-8"));
		Response response=httpRequest.post("/api/v1/create");
		System.out.println(response.contentType());
		
		
		
		//Employee emp = response.getBody().as(Employee.class);
		//System.out.println("Deseriliation of json to java object " + emp.getName());
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		
		Gson gson = new Gson();
		Employee emp = gson.fromJson(responseBody, Employee.class);
		
		
		
		System.out.println(emp.getName());
		System.out.println("Response Body is =>  " + responseBody);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
	//	String successCode = response.jsonPath().get("SuccessCode");
	//	Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");

	}

}