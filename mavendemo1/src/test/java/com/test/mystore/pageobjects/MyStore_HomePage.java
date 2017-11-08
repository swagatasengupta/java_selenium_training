package com.test.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lib.util.LogUtil;
import com.lib.util.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.test.BaseTest;

public class MyStore_HomePage extends BaseTest {

	@FindBy(how=How.LINK_TEXT, using="Sign in")
	public WebElement signInLink;

	@FindBy(how=How.CSS, using="#editorial_block_center>h1")
	public WebElement elemEditorialBlockCenterHeading;


	public MyStore_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean clickSignIn() {
		boolean retVal = true;
		try{
			signInLink.click();
		}
		catch (Exception e) {
			LogUtil.log("ERROR", "Could not click on sign in link.", e);
			retVal = false;
		}
		return retVal;
	}

	public boolean openHomePage(String URL) {
		boolean retVal = true;
		try{
			driver.get(URL);
		}
		catch (Exception e) {
			LogUtil.log("ERROR", "Could not open home page. ", e);
			retVal = false;
		}
		return retVal;
	}
	

}
