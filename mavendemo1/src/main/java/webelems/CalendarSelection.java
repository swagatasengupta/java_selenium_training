package webelems;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarSelection {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.co.in/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws Exception {
		driver.get(baseUrl);
		// Click flights tab
		driver.findElement(By.id("primary-header-flight")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.id("flight-departing"));
		// Click departing field
		departingField.click();
		Thread.sleep(2000);
		// Find the date to be selected
		List<WebElement> datesInCurrMonth = driver.findElements(By.xpath("//div[@class='datepicker-cal-month'][1]//button[@class='datepicker-cal-date']"));
		for (WebElement elem : datesInCurrMonth) {
			if(elem.getText().compareTo("28")==0) {
				elem.click();
			}
		}
		
		//WebElement dateToSelect = driver.findElement(By.xpath("//section[@class='cal-month'][position()=1]//a[text()='31']"));
		// Click the date
		//dateToSelect.click();
	}

/*	@Test
	public void autocomplete() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.id("hotel-destination")).click();
		//driver.findElement(By.id("hotel-destination")).clear();
		driver.findElement(By.id("hotel-destination")).sendKeys("Hyder");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='results']//a[@data-value='Hyderabad Hitech City Station, India']")).click();
		
	}
	*/
/*	@Test
	public void test2() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("tab-flight-tab")).click();
		WebElement departingField = driver.findElement(By.id("flight-departing"));
		departingField.click();
		WebElement calMonth = driver.findElement(By.xpath("//section[@class='cal-month'][position()=1]"));
		
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("a"));
		
		Thread.sleep(3000);
		
		for (WebElement date : allValidDates) {
			if (date.getText().equals("31")) {
				date.click();
				break;
			}
		}
	}*/

	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(3000);
		//driver.quit();
	}
}