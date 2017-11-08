package com.test.mystore.ui_tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
	@BeforeClass
	public void f2_beforeClass() {

	}

	@BeforeMethod
	public void f2_beforeMethod() {

	}

	@Test
	public void f2_1() {
		Assert.assertTrue(true);
	}

	@Test
	public void f2_2() {
		Assert.assertTrue(false);
	}

	@Test
	public void f2_3() {
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void f2_afterMethod() {

	}

	@AfterClass
	public void f2_afterClass() {

	}

}
