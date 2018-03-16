package js;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowSize {
	private WebDriver driver;
	private JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testJavaScriptExecution() throws Exception {
		// Navigation
		js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice'");
		Thread.sleep(6000);
		
		// Size of window
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");
		
		System.out.println("Height is: " + height);
		System.out.println("Width is: " + width);
		
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
