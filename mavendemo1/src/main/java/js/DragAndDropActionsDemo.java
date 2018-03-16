package js;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropActionsDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://jqueryui.com/droppable/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testDragAndDrop() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.switchTo().frame(0);

		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement toElement = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		// Drag and drop
		//action.dragAndDrop(fromElement, toElement).build().perform();
		
		// Click and hold, move to element, release, build and perform
		action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// driver.quit();
	}
}