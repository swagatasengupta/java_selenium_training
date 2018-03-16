package headless;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HTMLUnitDemo {

	@Test
	public void test1() throws InterruptedException {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 600)");
		String confButtonType = driver.findElement(By.id("confirmbtn")).getAttribute("type");
		System.out.println("Some console content");
		System.out.println(confButtonType);
		WebElement mainElement = driver.findElement(By.id("mousehover"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		Thread.sleep(2000);
		
		//WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		action.moveToElement(
				driver.findElement(
						By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']")
						)
				).click().perform();
		driver.quit();
	}
	
}
