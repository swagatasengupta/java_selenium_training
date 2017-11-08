package com.test.mystore.pageobjects;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lib.util.LogUtil;

public class MyStore_LoginPage extends MyStore_BasePage{

	@FindBy(how=How.ID, using="email")
	public WebElement inp_userName;
	
	@FindBy(how=How.ID, using="passwd")
	public WebElement inp_password;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	public WebElement btn_submit;



	public MyStore_LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean login(String userName, String encodedPassword) {
		boolean retVal = true;
		try{
			inp_userName.clear();
			inp_userName.sendKeys(userName);
			inp_password.clear();
			String decodedPwd = new String(Base64.getDecoder().decode(encodedPassword));
			inp_password.sendKeys(decodedPwd);
			btn_submit.click();

		}
		catch (Exception e) {
			LogUtil.log("ERROR", "Could not login.", e);
			retVal = false;
		}
		return retVal;
	}


}
