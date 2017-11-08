package com.test.mystore.ui_tests;

import java.util.Base64;
import java.util.Properties;

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
import com.test.mystore.pageobjects.MyStore_HomePage;
import com.test.mystore.pageobjects.MyStore_LoginPage;

public class LoginDemoPageFactory {

	SoftAssert sAssert = new SoftAssert();
	WebDriver driver;
	Properties prop;
	MyStore_HomePage homePage;
	MyStore_LoginPage loginPage;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) {

		driver = SelWebDriverUtil.getBrowser(browser, true);
		prop = PropUtil.getProp("MYSTORE");
		driver.get(prop.getProperty("myStoreURL"));
		homePage = new MyStore_HomePage(driver);
		loginPage = new MyStore_LoginPage(driver);
	}

	@Test
	public void t01_LoginPageFactoryDemo() {
	
		homePage.signInLink.click();
		homePage.clickSignIn();
		loginPage.inp_userName.clear();
		loginPage.inp_userName.sendKeys(prop.getProperty("userName"));
		loginPage.inp_password.clear();
		String decodedPwd = new String(Base64.getDecoder().decode(prop.getProperty("encodedPassword")));
		loginPage.inp_password.sendKeys(decodedPwd);
		loginPage.btn_submit.click();
		/*Assert.assertTrue(homePage.clickSignIn());
		Assert.assertTrue(loginPage.login(prop.getProperty("userName"),
				prop.getProperty("encodedPassword")));*/
	}

	@AfterMethod
	public void closeBrowser() {
		//MyStoreReusableFunctions.myStore_logOut(driver);
		driver.quit();
	}

}
