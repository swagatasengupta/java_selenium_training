package webelems;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Autocomplete {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		//GeckoDriverService service = new GeckoDriverService(null, 0, null, null);
		driver = new FirefoxDriver();
		//driver = 
		baseUrl = "http://www.southwest.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testAutocomplete() throws Exception {
		driver.get(baseUrl);
		String searchingText = "New York/Newark, NJ"; //="New York/Newark, NJ - EWR"
		String partialText = "New York";

		WebElement text = driver.findElement(By.id("air-city-departure"));
		text.sendKeys(partialText);

		WebElement element = driver.findElement(By.id("air-city-departure-menu"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();

		System.out.println("The size of the list is: " + size);

/*		for (int i = 0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}
*/
		Thread.sleep(3000);
		for (WebElement result : results) {
			if (result.getText().contains(searchingText)) {
				System.out.println("Selected: " + result.getText());
				result.click();
				break;
			}
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//driver.quit();
	}
}
