package com.w2a.API_RestAssuredFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.CreateCustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest{

	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String,String> data)
	{
		
		
		Response response= CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String,String> data)
	{
		
		
		Response response= CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 401);
	}
	

}
