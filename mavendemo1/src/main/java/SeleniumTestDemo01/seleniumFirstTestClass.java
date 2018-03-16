package SeleniumTestDemo01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumFirstTestClass {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseURL = "http://www.google.com";
		WebDriver driver;
		/* Download chrome driver if needed from
		 * https://chromedriver.storage.googleapis.com/index.html?path=2.32/
		 * OR latest one from https://sites.google.com/a/chromium.org/chromedriver/downloads
		 */
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse\\Work-Space\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		//open the URL
		driver.get(baseURL);
		
	}

}
