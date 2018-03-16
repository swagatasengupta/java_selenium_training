package SeleniumTestDemo01;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MyStoreDemo1 {
	public WebDriver drv;
	
	@BeforeClass
	public void beforeClass() {
/*		UIWebDriver uidriver = new UIWebDriver("chrome",true,20);
		drv = uidriver.getBrowser();*/
		//drv = new SelWebDriverUtil().getBrowser("chrome",true,20);
		drv.get("http://automationpractice.com/index.php");
	}

	@Test
	public void t01_verifyHomePage() {
	String pageTextToVerify = drv.findElement(By.cssSelector("#editorial_block_center>h1")).getText();
	System.out.println("pageTextToVerify: " + pageTextToVerify);
	Assert.assertEquals(pageTextToVerify, "Automation Practice Website");
	}

	@Test
	public void t02_verifyLoginPage() {
		drv.findElement(By.linkText("Sign in")).click();
		Assert.assertEquals(drv.findElement(By.className("page-heading")).getText(), "AUTHENTICATION");
	}

	@Test
	public void t03_verifyMyAccountPage() {
		drv.findElement(By.id("email")).clear();
		drv.findElement(By.id("email")).sendKeys("swagatasengupta@yahoo.com");
		drv.findElement(By.id("passwd")).clear();
		String decodedPwd = new String(Base64.getDecoder().decode("MTIzNDU="));
		drv.findElement(By.id("passwd")).sendKeys(decodedPwd);
		drv.findElement(By.id("SubmitLogin")).click();
		Assert.assertEquals(drv.findElement(By.className("page-heading")).getText(), "MY ACCOUNT");
	}
	@AfterClass
	public void afterClass() {
		drv.findElement(By.className("logout")).click();
		drv.quit();
	}

}
