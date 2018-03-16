package js;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecution {
	private WebDriver driver;
	String baseUrl;
	private JavascriptExecutor js;


	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testJavaScriptExecution() throws Exception {
		// Navigation
		// driver.get(baseUrl);
		js.executeScript("window.location = \'"+ baseUrl +"\';");
		
		// driver.get() method waits for the page to load completely before going to the next statement
		// Adding Thread.sleep() because we are opening URL using js.executeScript() and it does not wait for the page to load completely
		// If we do not add wait, then Selenium WebDriver will immediately try to find the element and it might have issues with just a little slow connection
		Thread.sleep(5000);
		// Finding element
		// WebElement textBox = driver.findElement(By.id("name"));
		WebElement textBox = (WebElement) js.executeScript("return document.getElementById(\'name\');");
		Thread.sleep(2000);
		textBox.sendKeys("test");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
	}
}