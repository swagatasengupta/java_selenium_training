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
import com.lib.util.TimeUtil;
import com.lib.util.extent.ExtentManager;
import com.lib.util.extent.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.test.mystore.BaseTest;
import com.test.mystore.MyStoreUIWebTestData;
import com.test.mystore.pageobjects.MyStore_CommonPage;
import com.test.mystore.pageobjects.MyStore_HomePage;
import com.test.mystore.pageobjects.MyStore_LoginPage;
import com.test.mystore.pageobjects.MyStore_MyAccountPage;

public class CreateAddress extends BaseTest {
	WebDriver driver;
	String addrAlias;
	Properties prop;

	ExtentReports extent = ExtentManager.getReporter();

	MyStore_HomePage hp;// = new MyStore_HomePage(driver);;
	MyStore_LoginPage lgn;// = new MyStore_LoginPage(driver);
	MyStore_CommonPage cmn;// = new MyStore_CommonPage(driver);
	MyStore_MyAccountPage myacc;// = new MyStore_MyAccountPage(driver);

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

	@Test(dataProvider = "test_createAddress", dataProviderClass = MyStoreUIWebTestData.class)
	public void t02_NavigateToAddresses(String fName, String lName, String addr1, String city, String state, String pin,
			String country, String homPhone, String mobPhone, String addrAliasPrefix) {

		retVal = hp.openHomePage(prop.getProperty("myStoreURL"));
		Assert.assertTrue(retVal);

		retVal = hp.clickSignIn();
		Assert.assertTrue(retVal);

		retVal = lgn.login(prop.getProperty("userName"), prop.getProperty("encodedPassword"));
		Assert.assertTrue(retVal);

		retVal = myacc.myAccountNavigation("ADDRESSES");
		Assert.assertTrue(retVal);
		LogUtil.log("INFO",  "Logged in to the application as " + prop.getProperty("userName"));
		LogUtil.log("PASS",  "Successfully clicked on My Addresses link on My Account Page");

		addrAlias = addrAliasPrefix + TimeUtil.getTimeStamp();

		retVal = myacc.myStore_FillNewAddress(fName, lName, addr1, city, state, pin, country, homPhone, mobPhone,
				addrAlias);
		Assert.assertTrue(retVal);

		retVal = myacc.myStore_submitAddress();
		Assert.assertTrue(retVal);
		LogUtil.log("PASS",   "Successfully filled address fields and submitted");

		retVal = myacc.myStore_verifyAddedAddress(addrAlias);
		Assert.assertTrue(retVal);
		LogUtil.log("PASS",   "Successfully verified added address " + addrAlias);

	}

	@AfterMethod
	public void logoutAndClose() {
		try {
			retVal = cmn.logout();
			Assert.assertTrue(retVal);
			LogUtil.log("INFO",  "Logged out of the application");

			Thread.sleep(Long.parseLong(prop.getProperty("GLOBAL_WAIT_BEFORE_BROWSER_CLOSE")) * 1000);
		} catch (Exception e) {

			LogUtil.log("ERROR", "Error occured during logout and close", e);  
		}

	}
}
