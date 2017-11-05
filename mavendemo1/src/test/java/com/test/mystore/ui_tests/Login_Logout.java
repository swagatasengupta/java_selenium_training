package com.test.mystore.ui_tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lib.genWeb.SelWebDriverUtil;
import com.lib.myStoreAppLib.MyStoreReusableFunctions;
import com.lib.util.PropUtil;
import com.test.mystore.MyStoreUIWebBase;

public class Login_Logout extends MyStoreUIWebBase {
	SoftAssert sAssert = new SoftAssert();
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) {
		
		driver = SelWebDriverUtil.getBrowser(browser, true);
		prop = PropUtil.getProp("MYSTORE");
		driver.get(prop.getProperty("myStoreURL"));
	}

	@Test
	public void t01_Login() {
		String pageTextToVerify = driver.findElement(By.cssSelector("#editorial_block_center>h1")).getText();
		sAssert.assertEquals(pageTextToVerify, "Automation Practice Website");
		Assert.assertTrue(MyStoreReusableFunctions.myStore_Login(driver, prop.getProperty("userName"),
				prop.getProperty("encodedPassword")));
		// check my account page is displayed
		Assert.assertEquals(driver.findElement(By.className("page-heading")).getText(), "MY ACCOUNT");
		sAssert.assertAll();
	}

	public void t02_Logout() {
		sAssert.assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		driver.findElement(By.className("logout")).click();
		// check that it comes back to login page
		Assert.assertEquals(driver.findElement(By.className("page-heading")).getText(), "AUTHENTICATION");
		sAssert.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
