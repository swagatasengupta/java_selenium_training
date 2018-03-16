package SeleniumTestDemo01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestJUnit {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.letskodeit.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testSelenium() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("i90scv3glabel")).click();
		driver.findElement(By.linkText("Practice")).click();
	}

	@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		// driver.quit();
	}
}