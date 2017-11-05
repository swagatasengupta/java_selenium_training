package com.lib.genWeb;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.lib.util.PathUtil;
import com.lib.util.PropUtil;

public class SelWebDriverUtil {


	public static WebDriver getBrowser(String browserType, boolean maximize, int implicitWait) {
		
		WebDriver driver;
		Properties p = PropUtil.getProp("MASTER");
		String frameworkBaseFolder = PathUtil.getPath("FRW_BASE");

		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					frameworkBaseFolder + p.getProperty("CHROME_DRIVER_PATH"));
			driver = new ChromeDriver();
			break;

		case "mozilla":
			System.setProperty("webdriver.gecko.driver",
					frameworkBaseFolder + p.getProperty("GECKO_DRIVER_PATH"));
			driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver",
					frameworkBaseFolder + p.getProperty("IE_DRIVER_PATH"));
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("\'" + browserType + "\' browser type is unrecognized/ unsupported... defaulting to chrome");
			System.setProperty("webdriver.chrome.driver",
					frameworkBaseFolder + p.getProperty("CHROME_DRIVER_PATH"));
			driver = new ChromeDriver();
			break;
		}
		
		if(implicitWait !=0) {
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		} else {
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(p.getProperty("GLOBAL_IMPLICIT_WAIT_IN_SECS")),
					TimeUnit.SECONDS);
			
		}
		if(maximize) driver.manage().window().maximize();
		
		return driver;

	}

	public static WebDriver getBrowser(String browserType, boolean maximize) {
		return getBrowser(browserType, maximize,0);
	}
}
