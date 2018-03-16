package js;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderActionsDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://jqueryui.com/slider/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSliderActions() throws Exception {
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		// Using the actions class
		WebElement parentSlider = driver.findElement(By.xpath("//div[@id='slider']"));
		Dimension size = parentSlider.getSize();
		System.out.println(size.width);
		WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, (size.width - 20), 0).perform();
	}

	@AfterMethod
	public void tearDown() throws Exception {
	}
}
