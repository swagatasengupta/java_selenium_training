package headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ChromeHeadlessDemo {

	public static void takeScreenshot(WebDriver driver, File saveFileAbsPath) throws IOException {

		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, saveFileAbsPath);
	}
	
	@Test
	public void test1() throws InterruptedException, IOException {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("headless");
		opts.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(opts);
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.get("https://letskodeit.teachable.com/p/practice");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 900)");
		Thread.sleep(2000);
		takeScreenshot(driver, new File("E:\\BitBucket\\swa_autfrwrk\\swa_autfrwrk\\src\\test\\java\\result\\scr1.png"));
		String confButtonType = driver.findElement(By.id("confirmbtn")).getAttribute("type");
		System.out.println("Some console content");
		System.out.println(confButtonType);
		WebElement mainElement = driver.findElement(By.id("mousehover"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		Thread.sleep(2000);
		takeScreenshot(driver, new File("E:\\BitBucket\\swa_autfrwrk\\swa_autfrwrk\\src\\test\\java\\result\\scr2.png"));
		//WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		action.moveToElement(
				driver.findElement(
						By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']")
						)
				).click().perform();
		Thread.sleep(2000);
		takeScreenshot(driver, new File("E:\\BitBucket\\swa_autfrwrk\\swa_autfrwrk\\src\\test\\java\\result\\scr3.png"));

		driver.quit();
	}
	
}
