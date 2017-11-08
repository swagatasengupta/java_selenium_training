package com.test.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lib.util.LogUtil;
import com.lib.util.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class MyStore_CommonPage extends MyStore_BasePage{
	@FindBy(how=How.CLASS_NAME, using="logout")
	public WebElement lnk_signOut;
	
	@FindBy(how=How.CLASS_NAME, using="page-heading")
	public WebElement elem_pageHeading;

	@FindBy(how=How.CSS, using=".navigation_page")
	public WebElement elem_navigationPage;
	
	@FindBy(how=How.XPATH, using="//li/a[contains(@href,'controller=my-account')]")
	public WebElement btn_backToMyAccount;
	

	public MyStore_CommonPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean logout() {
		boolean retVal = true;
		try{
			lnk_signOut.click();

		}
		catch (Exception e) {
			LogUtil.log("ERROR", "Could not click on Sign Out link. ", e);
			retVal = false;
		}
		return retVal;
	}
}
