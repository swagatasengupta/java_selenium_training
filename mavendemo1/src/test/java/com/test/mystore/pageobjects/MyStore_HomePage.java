package com.test.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyStore_HomePage {
	WebDriver driver;

	@FindBy(how=How.LINK_TEXT, using="Sign in")
	public WebElement signInLink;


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
			System.out.println("Could not click on sign in link. " + e.toString());
			retVal = false;
		}
		return retVal;
	}


}
