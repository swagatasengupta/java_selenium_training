package com.test.mystore.ui_tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lib.genWeb.SelWebDriverUtil;
import com.lib.util.LogUtil;
import com.lib.util.PropUtil;
import com.lib.util.extent.ExtentManager;
import com.lib.util.extent.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.test.mystore.BaseTest;
import com.test.mystore.pageobjects.MyStore_CommonPage;
import com.test.mystore.pageobjects.MyStore_HomePage;
import com.test.mystore.pageobjects.MyStore_LoginPage;

public class Login_Logout extends BaseTest {
	WebDriver driver;
	Properties prop;
	ExtentReports extent = ExtentManager.getReporter();

	MyStore_HomePage hp;// = new MyStore_HomePage(driver);;
	MyStore_LoginPage lgn;//= new MyStore_LoginPage(driver);
	MyStore_CommonPage cmn;// = new MyStore_CommonPage(driver);

	boolean retVal = true;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) {
		driver = SelWebDriverUtil.getBrowser(browser, true);
		super.driver = this.driver;
		prop = PropUtil.getProp("MYSTORE");
		hp = new MyStore_HomePage(driver);;
		lgn= new MyStore_LoginPage(driver);
		cmn = new MyStore_CommonPage(driver);
	}

	@Test
	public void t01_Login() {
		
		try {
			hp.openHomePage(prop.getProperty("myStoreURL"));
			
			String pageTextToVerify = hp.elemEditorialBlockCenterHeading.getText();
			LogUtil.log("INFO",  "Home page text to verify: " + pageTextToVerify);
			//Check message on home page.
			Assert.assertEquals(pageTextToVerify, "Automation Practice Website");
			LogUtil.log("PASS",   "Verified \"Automation Practice Website\" text on home page");
			
			hp.signInLink.click();
			LogUtil.log("INFO",  "Clicked on Sign in on home page");
			
			
			retVal = lgn.login(prop.getProperty("userName"), prop.getProperty("encodedPassword"));
			Assert.assertTrue(retVal);

			// check my account page is displayed
			
			
			String actMyAccPageHeader = cmn.elem_pageHeading.getText();
			Assert.assertEquals(actMyAccPageHeader, "MY ACCOUNT");
			LogUtil.log("PASS", "Logged in to the application successfully as "
			+ prop.getProperty("userName")
			+ " and verified MY ACCOUNT page is displayed");

			boolean isLogoutDisplayed = cmn.lnk_signOut.isDisplayed();
			Assert.assertTrue(isLogoutDisplayed);
			Assert.assertTrue(cmn.logout());
			LogUtil.log("PASS", "Logout link displayed and was clicked.");
			// check that it comes back to login page
			String actAuthPageHeader = cmn.elem_pageHeading.getText();
			Assert.assertEquals(actAuthPageHeader, "AUTHENTICATION");
			LogUtil.log("PASS", "After logout, authentication page was displayed.");

			
		} catch (Exception e) {
			
			LogUtil.log("ERROR", "Exception occured while logging in." + this.getClass().getName(), e);
		}
	}

	@AfterMethod
	public void afterMethod() {
	}

}
