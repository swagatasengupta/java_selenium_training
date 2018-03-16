package webelems;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ExplicitWaitDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
/*		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
*/		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement loginLink = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
		loginLink.click();

		WebElement emailField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailField.sendKeys("test");
		
		//driver.findElement(By.id("user_email")).sendKeys("test");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
}
