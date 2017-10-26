package SeleniumTestDemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelSearchGoogle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().window().maximize(); // command to ensure window opens maximized.
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Umika Sengupta");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).click();
		
	}

}
