package com.lib.genWeb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class UIWebDriver {

	private String browserType;
	private boolean maximize;
	private int implicitWait;
	private boolean anyExceptions = false;
	private static final String CONFIG_FILE_PATH = "\\com\\config\\master_config.properties";
	private Properties prop;
	private String frameworkBaseFolder;

	public UIWebDriver(String browserType, boolean maximize) {
		this.browserType = browserType;
		this.maximize = maximize;
		prop = new Properties();
		readDriverPaths();
	}

	public UIWebDriver(String browserType, boolean maximize, int implicitWait) {
		this.browserType = browserType;
		this.maximize = maximize;
		this.implicitWait = implicitWait;
		prop = new Properties();
		readDriverPaths();
	}

	private void readDriverPaths() {
		try {
			frameworkBaseFolder = System.getenv("LXR_TEST_AUT_FRW");
			System.out.println("Framework base folder: " + frameworkBaseFolder);
			FileInputStream fis = new FileInputStream(frameworkBaseFolder + CONFIG_FILE_PATH);
			prop.load(fis);
		} catch (IOException e) {
			anyExceptions = true;
			System.out.println("Exception Occured: " + e.toString());
		}
	} // readDriverPaths ends

	public WebDriver getBrowser() {
		
		WebDriver driver = null;
		
		if (anyExceptions == true) return driver;
/*		String globBrowserType;
		if((globBrowserType = prop.getProperty("CURR_BROWSER")).length() > 0) 
			browserType = globBrowserType;
*/		
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					frameworkBaseFolder + prop.getProperty("CHROME_DRIVER_PATH"));
			driver = new ChromeDriver();
			break;

		case "mozilla":
			System.setProperty("webdriver.gecko.driver",
					frameworkBaseFolder + prop.getProperty("GECKO_DRIVER_PATH"));
			driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver",
					frameworkBaseFolder + prop.getProperty("IE_DRIVER_PATH"));
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("\'" + browserType + "\' browser type is unrecognized/ unsupported");
			break;
		}
		
		if(implicitWait !=0) driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		if(maximize) driver.manage().window().maximize();
		
		return driver;

	}
}
