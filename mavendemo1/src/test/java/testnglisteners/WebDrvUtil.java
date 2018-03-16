package testnglisteners;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebDrvUtil {
	private static final Logger log = LogManager.getLogger(WebDrvUtil.class.getName());
	
	public static WebDriver getBrowser(String browserType) {
		
		String chromeDriverPath = "E:\\BitBucket\\swa_autfrwrk\\swa_autfrwrk\\src\\main\\java\\drivers\\chromedriver.exe"; 
		String geckoDriverPath = "E:\\BitBucket\\swa_autfrwrk\\swa_autfrwrk\\src\\main\\java\\drivers\\geckodriver.exe";

		WebDriver driver;
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;

		case "mozilla":
			System.setProperty("webdriver.gecko.driver",geckoDriverPath);
			driver = new FirefoxDriver();
			break;
		default:
			log.warn("WARNING", "\'" + browserType + "\' browser type is unrecognized/ unsupported... defaulting to chrome");
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			driver = new ChromeDriver();
			break;
		}
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
		return driver;

	}

	public static synchronized boolean takeScreenShotAndAttachToExtent(WebDriver driver, ExtentTest ext, LogStatus status, String msg) {
		
		boolean retVal = true;
		
		try {
			// Take base64Screenshot screenshot.
			String base64Screenshot = "data:image/png;base64,"
					+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			// Extentreports log and screenshot operations for failed tests.
			ext.log(status, msg, ext.addBase64ScreenShot(base64Screenshot));

		} catch (Exception e) {
			retVal = false;
			log.error("Error occured while taking screenshot", e);
		}
		
		return retVal;
	}

}
