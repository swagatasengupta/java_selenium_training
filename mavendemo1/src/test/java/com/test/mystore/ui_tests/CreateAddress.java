package com.test.mystore.ui_tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lib.genWeb.SelWebDriverUtil;
import com.lib.myStoreAppLib.MyStoreReusableFunctions;
import com.lib.util.PropUtil;
import com.lib.util.TimeUtil;
import com.test.mystore.MyStoreUIWebBase;
import com.test.mystore.MyStoreUIWebTestData;

public class CreateAddress extends MyStoreUIWebBase {

	String addrAlias;
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(String browser){
		driver = SelWebDriverUtil.getBrowser(browser,true);
		prop = PropUtil.getProp("MYSTORE");
		driver.get(prop.getProperty("myStoreURL"));
		}

	@Test(dataProvider="test_createAddress", dataProviderClass=MyStoreUIWebTestData.class)
	public void t02_NavigateToAddresses(String fName,
			String lName, String addr1, String city,
			String state, String pin, String country,
			String homPhone, String mobPhone,String addrAliasPrefix) {
		Assert.assertTrue(MyStoreReusableFunctions.myStore_Login(driver, prop.getProperty("userName"),
				prop.getProperty("encodedPassword")));
		Assert.assertTrue(MyStoreReusableFunctions.myStore_MyAccountNavigation(driver, "ADDRESSES"));
		addrAlias = addrAliasPrefix + TimeUtil.getTimeStamp();
		Assert.assertTrue(MyStoreReusableFunctions.myStore_addNewAddress(driver, fName,
				lName, addr1, city, state, pin, country,
				homPhone, mobPhone, addrAlias));
		Assert.assertTrue(MyStoreReusableFunctions.myStore_verifyAddedAddress(driver, addrAlias));
	}
	
	@AfterMethod
	public void logoutAndClose() {
	try {
		MyStoreReusableFunctions.myStore_logOut(driver);
		//System.out.println(myStoreAppProps.getProperty("GLOBAL_WAIT_BEFORE_BROWSER_CLOSE"));
		Thread.sleep(Long.parseLong(prop.getProperty("GLOBAL_WAIT_BEFORE_BROWSER_CLOSE")) * 1000);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		driver.quit();
	}

	}
}
