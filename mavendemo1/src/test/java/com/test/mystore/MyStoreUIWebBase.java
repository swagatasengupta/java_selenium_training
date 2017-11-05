package com.test.mystore;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class MyStoreUIWebBase {
	

	public MyStoreUIWebBase() {
		System.out.println("MyStoreUIWebBase Constructor called");
	}

	@BeforeSuite
	public void beforeMyStoreUIWebSuite() {
		System.out.println("MyStoreUIWebBase @BeforeSuite called");
	}

	@BeforeTest
	public void beforeMyStoreUIWebTest() {
		//before every test
		System.out.println("MyStoreUIWebBase @BeforeTest called");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("MyStoreUIWebBase @BeforeClass called");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("MyStoreUIWebBase @AfterClass called");
	}

	
	@AfterTest
	public void afterMyStoreUIWebTest() {
		System.out.println("MyStoreUIWebBase @AfterTest called");
	}

	@AfterSuite
	public void afterMyStoreUIWebSuite() {
		System.out.println("MyStoreUIWebBase @AfterSuite called");
	}

}
