package com.test.mystore.ui_tests;

import java.util.Properties;

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
import com.test.BaseTest;
import com.test.mystore.pageobjects.MyStore_CommonPage;
import com.test.mystore.pageobjects.MyStore_HomePage;
import com.test.mystore.pageobjects.MyStore_LoginPage;
import com.test.mystore.pageobjects.MyStore_MyAccountPage;

public class MyAcctLinkNavigations extends BaseTest {
	WebDriver driver;

	String addrAlias;
	Properties prop;

	MyStore_HomePage hp;// = new MyStore_HomePage(driver);;
	MyStore_LoginPage lgn;// = new MyStore_LoginPage(driver);
	MyStore_CommonPage cmn;// = new MyStore_CommonPage(driver);
	MyStore_MyAccountPage myacc;// = new MyStore_MyAccountPage(driver);

	ExtentReports extent = ExtentManager.getReporter();
	
	boolean retVal = true;
	
	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) {
		driver = SelWebDriverUtil.getBrowser(browser, true);
		super.driver = this.driver;
		prop = PropUtil.getProp("MYSTORE");
		hp = new MyStore_HomePage(driver);;
		lgn = new MyStore_LoginPage(driver);
		cmn = new MyStore_CommonPage(driver);
		myacc = new MyStore_MyAccountPage(driver);
	}

	@Test
	public void t01_goToMyAccountLinks() {
	
		try {
			
		retVal = hp.openHomePage(prop.getProperty("myStoreURL"));
		Assert.assertTrue(retVal);

		retVal = hp.clickSignIn();
		Assert.assertTrue(retVal);

		retVal = lgn.login(prop.getProperty("userName"), prop.getProperty("encodedPassword"));
		Assert.assertTrue(retVal);


		//Go to order history page, verify page header and come back 

		retVal = myacc.myAccountNavigation("ORDER_HISTORY");
		LogUtil.log("INFO", "Successfully logged in as " + prop.getProperty("userName")
		+ " clicked on Order History on My Account page");

		Assert.assertTrue(retVal);
		String navigationPageText = cmn.elem_navigationPage.getText().trim();
		Assert.assertEquals(navigationPageText, "Order history");
		cmn.btn_backToMyAccount.click();
		LogUtil.log("PASS",  "Successfully navigated to Order History page and navigated back to My Account page");
		
		//Go to order history page, verify page header and come back 
		retVal = myacc.myAccountNavigation("CREDIT_SLIPS");
		Assert.assertTrue(retVal);
		navigationPageText = cmn.elem_navigationPage.getText().trim();
		Assert.assertEquals(navigationPageText, "Credit slips");
		cmn.btn_backToMyAccount.click();
		LogUtil.log("PASS",  "Successfully navigated to Credit Slips page and navigated back to My Account page");

		//Go to addresses page, verify page header and come back 
		retVal = myacc.myAccountNavigation("ADDRESSES");
		Assert.assertTrue(retVal);
		navigationPageText = cmn.elem_navigationPage.getText().trim();
		Assert.assertEquals(navigationPageText, "My addresses");
		cmn.btn_backToMyAccount.click();
		LogUtil.log("PASS", "Successfully navigated to My Addresses page and navigated back to My Account page");

		//Go to personal information page, verify page header and come back 
		retVal = myacc.myAccountNavigation("PERSONAL_INFORMATION");
		Assert.assertTrue(retVal);
		navigationPageText = cmn.elem_navigationPage.getText().trim();
		Assert.assertEquals(navigationPageText, "Your personal information");
		cmn.btn_backToMyAccount.click();
		LogUtil.log("PASS", "Successfully navigated to Personal Information page and navigated back to My Account page");
		
		//Go to wishlist page, verify page header and come back 
		retVal = myacc.myAccountNavigation("WISHLIST");
		Assert.assertTrue(retVal);
		navigationPageText = cmn.elem_navigationPage.getText().trim();
		Assert.assertEquals(navigationPageText, "My wishlists");
		cmn.btn_backToMyAccount.click();
		LogUtil.log("PASS", "Successfully navigated to My wishlists page and navigated back to My Account page");
		
		} catch (Exception e) {
			LogUtil.log("ERROR", "Error occured in " + this.getClass().getName(), e);
		}

	}

	@AfterMethod
	public void logoutAndClose() {
		try { 
			retVal = cmn.logout();
			Assert.assertTrue(retVal);
			Thread.sleep(Long.parseLong(prop.getProperty("GLOBAL_WAIT_BEFORE_BROWSER_CLOSE")) * 1000);
		} catch (Exception e) {
			LogUtil.log("ERROR", "Error occured while logging out " + this.getClass().getName(), e);
		}

	}
}
