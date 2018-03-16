package js;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.Credentials;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchAlertDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("Anil");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void test2() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("Anil");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();

		alert.accept();
		//alert.dismiss();
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
}
