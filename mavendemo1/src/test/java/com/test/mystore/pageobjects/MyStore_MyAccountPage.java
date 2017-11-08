package com.test.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lib.util.LogUtil;
import com.lib.util.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class MyStore_MyAccountPage extends MyStore_BasePage{

	@FindBy(how=How.XPATH, using="//*/span[text()='Order history and details']")
	public WebElement lnk_orderHistory;
	
	@FindBy(how=How.XPATH, using="//*/span[text()='My credit slips']")
	public WebElement lnk_CreditSlips;

	@FindBy(how=How.XPATH, using="//*/span[text()='My addresses']")
	public WebElement lnk_myAddresses;

	@FindBy(how=How.XPATH, using="//*/span[text()='My personal information']")
	public WebElement lnk_personalInfo;

	@FindBy(how=How.XPATH, using="//*/span[text()='My wishlists']")
	public WebElement lnk_wishList;

	@FindBy(how=How.XPATH, using="//*[@id='center_column']//a[contains(@title,'Add an address')]")
	public WebElement btn_addAddress;
	
	@FindBy(how=How.ID, using="firstname")
	public WebElement inp_firstName;
	
	@FindBy(how=How.ID, using="lastname")
	public WebElement inp_lastName;
	
	@FindBy(how=How.ID, using="address1")
	public WebElement inp_address1;
	
	@FindBy(how=How.ID, using="city")
	public WebElement inp_city;
	
	@FindBy(how=How.ID, using="id_state")
	public WebElement sel_state;
	
	@FindBy(how=How.ID, using="postcode")
	public WebElement inp_postalCode;
	
	@FindBy(how=How.ID, using="id_country")
	public WebElement sel_country;
	
	@FindBy(how=How.ID, using="phone")
	public WebElement inp_phone;
	
	@FindBy(how=How.ID, using="phone_mobile")
	public WebElement inp_mobilePhone;
	
	@FindBy(how=How.ID, using="alias")
	public WebElement inp_alias;
	
	@FindBy(how=How.ID, using="submitAddress")
	public WebElement btn_submit;
	
	
	public MyStore_MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("finally")
	public boolean myAccountNavigation(String navigateTo) {
		boolean retVal = true;
		try {
			switch (navigateTo.toUpperCase()) {
			case "ORDER_HISTORY":
				lnk_orderHistory.click();
				break;
			case "CREDIT_SLIPS":
				lnk_CreditSlips.click();
				break;
			case "ADDRESSES":
				lnk_myAddresses.click();
				break;
			case "PERSONAL_INFORMATION":
				lnk_personalInfo.click();
				break;
			case "WISHLIST":
				lnk_wishList.click();
				break;

			default:
				retVal = false;
			}
			return retVal;
		} catch (Exception e) {
			LogUtil.log("ERROR", "Error occured while working on My Account Page elements. ", e);
			retVal = false;
		} finally {

			return retVal;

		}

	}
	
	@SuppressWarnings("finally")
	public boolean myStore_FillNewAddress(String fName, String lName, String addr1, String city,
			String state, String pin, String country, String homPhone, String mobPhone, String addrAlias) {
		boolean retVal = true;
		try {
			btn_addAddress.click();
			
			inp_firstName.clear();
			inp_firstName.sendKeys(fName);
			
			inp_lastName.clear();
			inp_lastName.sendKeys(lName);
			
			inp_address1.sendKeys(addr1);
			inp_city.sendKeys(city);
			new Select(sel_state).selectByVisibleText(state);
			inp_postalCode.sendKeys(pin);
			new Select(sel_country).selectByVisibleText(country);
			inp_phone.sendKeys(homPhone);
			inp_mobilePhone.sendKeys(mobPhone);
			inp_alias.clear();	
			inp_alias.sendKeys(addrAlias);

		} catch (

		Exception e) {
			LogUtil.log("ERROR", "Error occured while filling address form.", e);
			retVal = false;
		} finally {

			return retVal;

		}

	}

	@SuppressWarnings("finally")
	public boolean myStore_submitAddress() {
		boolean retVal = true;
		try {
			btn_submit.click();

		} catch (

		Exception e) {
			LogUtil.log("ERROR", "Error occured while clicking on Submit Address button", e);
			retVal = false;
		} finally {

			return retVal;

		}

	}

	@SuppressWarnings("finally")
	public boolean myStore_verifyAddedAddress(String addrAlias) {
		boolean retVal = true;
		try {
			WebElement addr = driver.findElement(By.xpath("//h3[contains(text(),\'" + addrAlias + "\')]"));
			return addr.isDisplayed();

		} catch (

		Exception e) {
			LogUtil.log("ERROR", "Error occured while verifying address alias " + addrAlias, e);
			retVal = false;
		} finally {

			return retVal;

		}
		
	}


}
