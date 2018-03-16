package SeleniumTestDemo01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementStateDemo {
	WebDriver driver;
	String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com";
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	public void test() {
		WebElement e1 = driver.findElement(By.id("gs_htif0"));
		System.out.println("E1 is Enabled? " + e1.isEnabled());
		
		WebElement e2 = driver.findElement(By.id("gs_taif0"));
		System.out.println("E2 is Enabled? " + e2.isEnabled());
		
		WebElement e3 = driver.findElement(By.id("lst-ib"));
		System.out.println("E3 is Enabled? " + e3.isEnabled());
		
		e3.sendKeys("letskodeit");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}