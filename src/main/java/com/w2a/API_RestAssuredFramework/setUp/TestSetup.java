package com.w2a.API_RestAssuredFramework.setUp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class TestSetup {
	
	@BeforeSuite
	public void setUp()
	{
		RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath="/v1";
	}
	
	@AfterSuite
	public void tearDown()
	{
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		
	}
	
	@AfterClass
	public void afterClass()
	{
		
	}
	
	@BeforeTest
	public void beforeTest()
	{
		
	}
	@AfterTest
	public void afterTest()
	{
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		
	}
	
	@AfterMethod
	
	public void afterMethod()
	{
		
	}

}
