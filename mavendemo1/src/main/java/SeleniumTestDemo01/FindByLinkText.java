package SeleniumTestDemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByLinkText {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "http://www.google.com/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.linkText("Gmail")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Sign")).click();
		
	}
}