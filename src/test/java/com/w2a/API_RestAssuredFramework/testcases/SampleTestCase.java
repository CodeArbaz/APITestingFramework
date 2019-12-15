package com.w2a.API_RestAssuredFramework.testcases;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.w2a.API_RestAssuredFramework.setUp.TestSetup;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class SampleTestCase extends TestSetup {

	
	@Test
	public void ValidateCreateCusyomerAPIWithValidKey(){

		
		
		Response response=given().auth().basic("sk_test_tEfoEYWZ0rk9JqAeFD1OBThA00eNtf23RR", "")
		.formParam("email", "rest@gmail.com")
		.formParam("description", "Test user")
		.post("/customers");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());


	}
	
	@Test
	public void ValidateCreateCusyomerAPIWithInvalidKey()
	{
		
		
		
		Response response=given().auth().basic("sk_test_tEfoEYghfgfgWZ0rk9JqAeFD1OBThA00eNtf23RR", "")
				.formParam("email", "rest@gmail.com")
				.formParam("description", "Test user")
				.post("/customers");
				
				System.out.println(response.prettyPrint());
				System.out.println(response.getStatusCode());
	}

}
