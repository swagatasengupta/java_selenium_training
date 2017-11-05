package com.test.mystore.ui_tests;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class MyAcctLinkNavigations extends MyStoreUIWebBase {

	String addrAlias;
	WebDriver driver;
	Properties prop;
	SoftAssert sAssert;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) {
		driver = SelWebDriverUtil.getBrowser(browser, true);
		prop = PropUtil.getProp("MYSTORE");
		driver.get(prop.getProperty("myStoreURL"));
		sAssert = new SoftAssert();
	}

	@Test
	public void t01_goToMyAccountLinks() {
		Assert.assertTrue(MyStoreReusableFunctions.myStore_Login(driver, prop.getProperty("userName"),
				prop.getProperty("encodedPassword")));
		List<WebElement> myAccLinks = driver.findElements(By.cssSelector(".myaccount-link-list>li>a"));
		System.out.println(myAccLinks.size() + " links found under myAccLinks under class myaccount-link-list");

		//Go to order history page, verify page header and come back 
		Assert.assertTrue(MyStoreReusableFunctions.myStore_MyAccountNavigation(driver, "ORDER_HISTORY"));
		sAssert.assertEquals(driver.findElement(By.cssSelector(".navigation_page")).getText().trim(), "Order history");
		driver.findElement(By.xpath("//li/a[contains(@href,'controller=my-account')]")).click();
		
		//Go to order history page, verify page header and come back 
		Assert.assertTrue(MyStoreReusableFunctions.myStore_MyAccountNavigation(driver, "CREDIT_SLIPS"));
		sAssert.assertEquals(driver.findElement(By.cssSelector(".navigation_page")).getText().trim(), "Credit slips");
		driver.findElement(By.xpath("//li/a[contains(@href,'controller=my-account')]")).click();

		//Go to addresses page, verify page header and come back 
		Assert.assertTrue(MyStoreReusableFunctions.myStore_MyAccountNavigation(driver, "ADDRESSES"));
		sAssert.assertEquals(driver.findElement(By.cssSelector(".navigation_page")).getText().trim(), "My addresses");
		driver.findElement(By.xpath("//li/a[contains(@href,'controller=my-account')]")).click();

		//Go to personal information page, verify page header and come back 
		Assert.assertTrue(MyStoreReusableFunctions.myStore_MyAccountNavigation(driver, "PERSONAL_INFORMATION"));
		sAssert.assertEquals(driver.findElement(By.cssSelector(".navigation_page")).getText().trim(), "Your personal information");
		driver.findElement(By.xpath("//li/a[contains(@href,'controller=my-account')]")).click();
		
		//Go to wishlist page, verify page header and come back 
		Assert.assertTrue(MyStoreReusableFunctions.myStore_MyAccountNavigation(driver, "WISHLIST"));
		sAssert.assertEquals(driver.findElement(By.cssSelector(".navigation_page")).getText().trim(), "My wishlists");
		driver.findElement(By.xpath("//li/a[contains(@href,'controller=my-account')]")).click();
		
		sAssert.assertAll();
		
		/*		for (int i=0; i< myAccLinks.size(); i++) {
			myAccLinks.get(i).click();
			System.out.println(driver.findElement(By.className("navigation_page")).getText());
			driver.findElement(By.xpath("//li/a[contains(@href,'controller=my-account')]")).click();
			try {
				Thread.sleep(2 * 1000);
			} catch (Exception e) {
				e.printStackTrace();
			} 		
		}*/
/*		for (WebElement elem : myAccLinks ) {
			elem.click();
			System.out.println(driver.findElement(By.className("navigation_page")).getText());
			driver.findElement(By.xpath("//li/a[contains(@href,'controller=my-account')]")).click();
			try {
				Thread.sleep(2 * 1000);
			} catch (Exception e) {
				e.printStackTrace();
			} 		
		}
*/	
	}

	@AfterMethod
	public void logoutAndClose() {
		try { 
			MyStoreReusableFunctions.myStore_logOut(driver);
			Thread.sleep(Long.parseLong(prop.getProperty("GLOBAL_WAIT_BEFORE_BROWSER_CLOSE")) * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}
}
