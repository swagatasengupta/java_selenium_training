package com.test.mystore.pageobjects;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyStore_LoginPage {
	WebDriver driver;

	@FindBy(how=How.ID, using="email")
	public WebElement username;
	
	@FindBy(how=How.ID, using="passwd")
	public WebElement password;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	public WebElement submit;



	public MyStore_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean login(String userName, String encodedPassword) {
		boolean retVal = true;
		try{
			username.clear();
			username.sendKeys(userName);
			password.clear();
			String decodedPwd = new String(Base64.getDecoder().decode(encodedPassword));
			password.sendKeys(decodedPwd);
			submit.click();

		}
		catch (Exception e) {
			System.out.println("Could not login. " + e.toString());
			retVal = false;
		}
		return retVal;
	}


}
