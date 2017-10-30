package SeleniumTestDemo01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lib.genWeb.UIWebDriver;

public class WebDriverDemo {

/*	public static WebDriver driver;
	public static final String CHROME_DRIVER_PATH = "E:\\eclipse\\Work-Space\\browserDrivers\\chromedriver.exe";
	
*/	
	public static void main(String[] args) {
		UIWebDriver chromedrv = new UIWebDriver("chrome",true);
		WebDriver drv1;
		drv1 = chromedrv.getBrowser();
		drv1.get("http://www.facebook.com");

		UIWebDriver mozdrv = new UIWebDriver("mozilla",false);
		mozdrv.getBrowser().get("http://www.seleniumhq.org");

		UIWebDriver iedrv = new UIWebDriver("IE",false);
		iedrv.getBrowser().get("http://www.netelixir.com");

	}

}
