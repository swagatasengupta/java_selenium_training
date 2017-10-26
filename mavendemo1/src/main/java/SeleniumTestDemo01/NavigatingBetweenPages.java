package SeleniumTestDemo01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigatingBetweenPages {
	WebDriver driver;
	String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?reset_purchase_session=1";
		driver.navigate().to(urlToNavigate);
		System.out.println("Navigating To Login");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		System.out.println("Navigate Back");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		System.out.println("Navigate Forward");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		System.out.println("Navigate Back");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		driver.navigate().refresh();
		System.out.println("Navigate Refresh");
		driver.get(currentUrl);
		System.out.println("Navigate Refresh");
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		// driver.quit();
	}
}