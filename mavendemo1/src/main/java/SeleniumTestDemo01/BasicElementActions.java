package SeleniumTestDemo01;


import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class BasicElementActions {
	WebDriver driver;
	boolean maximizeWindow = true;
	String baseUrl;
	SoftAssert sAssert = new SoftAssert();
	String pageHeaderText = null;
	@BeforeClass
	public void setUp() throws Exception {
//		driver = new SelWebDriverUtil().getBrowser("chrome",maximizeWindow,20);
		baseUrl = "http://automationpractice.com/index.php";
	}
	
	@Test
	public void verifyLoginPageDisplayed() {
		driver.get(baseUrl);
		//driver.findElement(By.partialLinkText("Sign in")).click();
		//driver.findElement(By.cssSelector(".login")).click();
		//driver.findElement(By.xpath(".//*[@id='header']//nav/div[@class='header_user_info']/a[@class='login']")).click();
		driver.findElement(By.className("login")).click();
		pageHeaderText = driver.findElement(By.className("page-heading")).getText();
		//Assert.assertEquals(pageHeaderText, "AUTHENTICATION");
		sAssert.assertEquals(pageHeaderText, "Something else");
		Assert.assertEquals(driver.findElement(By.id("SubmitCreate")).isDisplayed(), true);
		sAssert.assertAll();
	}

	@Test
	public void verifyLoginSuccessful() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("swagatasengupta@yahoo.com");
		driver.findElement(By.id("passwd")).clear();
		//driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("passwd")).sendKeys(new String(Base64.getDecoder().decode("MTIzNDU=")));
		driver.findElement(By.id("SubmitLogin")).click();
		pageHeaderText = driver.findElement(By.className("page-heading")).getText();
		Assert.assertEquals(pageHeaderText, "MY ACCOUNT");
	}
	
	
	@AfterClass
	public void tearDown() throws Exception {
		
		driver.findElement(By.className("logout")).click();
		// driver.quit();
	}
}