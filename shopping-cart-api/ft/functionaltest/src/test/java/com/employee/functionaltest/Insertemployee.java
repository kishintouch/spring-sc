package com.employee.functionaltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.json.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Insertemployee {

	@BeforeAll
	public static void setup() {

		RestAssured.baseURI = "http://dummy.restapiexample.com";

	}

	//@Test
	public void insertEmployee() throws IOException {

		RequestSpecification httpRequest = RestAssured.given();
		FileInputStream fileInputStream = new FileInputStream(new File(".//TestData//AddEmployee.json"));

		httpRequest.header("Content-Type", "application/json").accept("application/json");
		httpRequest.body(IOUtils.toString(fileInputStream, "UTF-8"));
		Response response = httpRequest.post("/api/v1/create");

		String responseBody = response.getBody().asString();

		// Deseriliation of json to java object
		Gson gson = new Gson();
		Employee emp = gson.fromJson(responseBody, Employee.class);

		System.out.println(emp.getName());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		// Serialize the data as Json and Save it as Json

		String saveEmployee = new Gson().toJson(emp);
		OutputStream outputStream = new FileOutputStream(".//TestData//SavedEmployee.json");
		outputStream.write(saveEmployee.getBytes());
		outputStream.close();

		// GET Request
		FileInputStream inputStream = new FileInputStream(new File(".//TestData//SavedEmployee.json"));
		String getEmployee = IOUtils.toString(inputStream, "UTF-8");
		Employee getEmployeeObject = gson.fromJson(getEmployee, Employee.class);

		Response getResponse = httpRequest.pathParam("id", getEmployeeObject.getId()).get("/api/v1/create");
		Employee getEmployeeResponse = gson.fromJson(getResponse.getBody().asString(), Employee.class);
		Assert.assertEquals("Employee Name is Incorrect", getEmployeeResponse.getName(), "jodi");

		// PUT Request
		/*Employee updateEmployee = new Employee();
		updateEmployee.setAge(34);
		updateEmployee.setName("Testtt");
		
		httpRequest.header("Content-Type", "application/json").accept("application/json");
		httpRequest.body(new Gson().toJson(updateEmployee));
		Response putResponse = httpRequest.pathParam("id", getEmployeeObject.getId()).get("/api/v1/create");
		
		updateEmployee = gson.fromJson(putResponse.getBody().asString(), Employee.class);
		System.out.println("updated Employee " + updateEmployee.getSalary());
		Assert.assertEquals("Employee Name is Incorrect", updateEmployee.getSalary(), null); */
	}
	

	@Test
	public void getEmployee() throws IOException {

		RequestSpecification httpRequest = RestAssured.given();

		// GET Request
		httpRequest.header("Content-Type", "application/json").accept("application/json");
		Response getResponse = httpRequest.basePath("/api/v1/employee").get("/{id}",137247);
		Gson gson = new Gson();
		System.out.println("getResponse.getBody().asString() " + getResponse.getBody().asString());
		Employee getEmployeeResponse = gson.fromJson(getResponse.getBody().asString(), Employee.class);
		Assert.assertEquals("Employee Name is Incorrect", getEmployeeResponse.getName(), "kodi");

	}

}