package com.lib.myStoreAppLib;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyStoreReusableFunctions {

	@SuppressWarnings("finally")
	public static boolean myStore_Login(WebDriver driver, String userName, String encodedPassowrd) {
		boolean retVal = true;
		try {
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(userName);
			driver.findElement(By.id("passwd")).clear();
			String decodedPwd = new String(Base64.getDecoder().decode(encodedPassowrd));
			driver.findElement(By.id("passwd")).sendKeys(decodedPwd);
			driver.findElement(By.id("SubmitLogin")).click();
			return retVal;
		} catch (Exception e) {
			retVal = false;
			e.printStackTrace();
		} finally {

			return retVal;

		}

	}

	@SuppressWarnings("finally")
	public static boolean myStore_MyAccountNavigation(WebDriver driver, String navigateTo) {
		boolean retVal = true;
		try {
			switch (navigateTo.toUpperCase()) {
			case "ORDER_HISTORY":
				driver.findElement(By.xpath("//*/span[text()='Order history and details']")).click();
				break;
			case "CREDIT_SLIPS":
				driver.findElement(By.xpath("//*/span[text()='My credit slips']")).click();
				break;
			case "ADDRESSES":
				driver.findElement(By.xpath("//*/span[text()='My addresses']")).click();
				break;
			case "PERSONAL_INFORMATION":
				driver.findElement(By.xpath("//*/span[text()='My personal information']")).click();
				break;
			case "WISHLIST":
				driver.findElement(By.xpath("//*/span[text()='My wishlists']")).click();
				break;

			default:
				retVal = false;
			}
			return retVal;
		} catch (Exception e) {
			retVal = false;
			e.printStackTrace();
		} finally {

			return retVal;

		}

	}

	@SuppressWarnings("finally")
	public static boolean myStore_addNewAddress(WebDriver driver, String fName, String lName, String addr1, String city,
			String state, String pin, String country, String homPhone, String mobPhone, String addrAlias) {
		boolean retVal = true;
		try {
			driver.findElement(By.xpath("//*[@id='center_column']//a[contains(@title,'Add an address')]")).click();
			WebElement fname = driver.findElement(By.id("firstname"));
			fname.clear();
			fname.sendKeys(fName);
			WebElement lname = driver.findElement(By.id("lastname"));
			lname.clear();
			lname.sendKeys(lName);
			driver.findElement(By.id("address1")).sendKeys(addr1);
			driver.findElement(By.id("city")).sendKeys(city);
			new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(state);
			driver.findElement(By.id("postcode")).sendKeys(pin);
			new Select(driver.findElement(By.id("id_country"))).selectByVisibleText(country);
			driver.findElement(By.id("phone")).sendKeys(homPhone);
			driver.findElement(By.id("phone_mobile")).sendKeys(mobPhone);
			WebElement alias = driver.findElement(By.id("alias"));
				alias.clear();	
				alias.sendKeys(addrAlias);
			driver.findElement(By.id("submitAddress")).click();

			return retVal;

		} catch (

		Exception e) {
			retVal = false;
			e.printStackTrace();
		} finally {

			return retVal;

		}

	}

	@SuppressWarnings("finally")
	public static boolean myStore_verifyAddedAddress(WebDriver driver, String addrAlias) {
		boolean retVal = true;
		try {
			WebElement addr = driver.findElement(By.xpath("//h3[contains(text(),\'" + addrAlias + "\')]"));
			return addr.isDisplayed();

		} catch (

		Exception e) {
			retVal = false;
			e.printStackTrace();
		} finally {

			return retVal;

		}
		
	}


	@SuppressWarnings("finally")
	public static boolean myStore_logOut(WebDriver driver) {
		boolean retVal = true;
		try {
			driver.findElement(By.className("logout")).click();
			return retVal;
		} catch (

		Exception e) {
			retVal = false;
			e.printStackTrace();
		} finally {

			return retVal;

		}
		
	}

}
