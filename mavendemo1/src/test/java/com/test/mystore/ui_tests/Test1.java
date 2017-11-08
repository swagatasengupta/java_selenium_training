package com.test.mystore.ui_tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

	@BeforeClass
	public void beforeClass() {

	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@Test
	public void f1() {
		Assert.assertTrue(true);
	}

	@Test
	public void f2() {
		Assert.assertTrue(true);
	}

	@Test
	public void f3() {
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {

	}
}
