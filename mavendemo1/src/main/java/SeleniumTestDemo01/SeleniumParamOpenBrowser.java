package SeleniumTestDemo01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SeleniumParamOpenBrowser {

	public static final String CHROME_DRIVER_PATH = "E:\\eclipse\\Work-Space\\browserDrivers\\chromedriver.exe";
	// download latest one from https://sites.google.com/a/chromium.org/chromedriver/downloads
	public static final String MOZILLA_DRIVER_PATH = "E:\\eclipse\\Work-Space\\browserDrivers\\geckodriver.exe";
	//download from https://github.com/mozilla/geckodriver/releases
	public static final String IE_DRIVER_PATH = "E:\\eclipse\\Work-Space\\browserDrivers\\IEDriverServer.exe";
	// download from http://www.seleniumhq.org/download/ --> "The Internet Explorer Driver Server" section
	// disable protected mode check box from iE settings for all - Internet, Local Intranet, Trusted Sites and Restricted Sites.
			 
	protected static String baseURL;
	protected static WebDriver driver;
	
	SeleniumParamOpenBrowser(){
		baseURL = "http://www.google.com";// default value
		driver = null; // default driver assignment is null
	}
	
	// This function receives browser code and URL and uses the same to open appropriate browser driver and navigate to the given URL.
	//The system.setProperty statements can be omitted if the 'PATH' system variable is set contain the driver paths. System restart may be required.
	public int openBrowser(String strBrowser, String strURL) {

		baseURL = strURL;
		
		switch (strBrowser) {
	    case "chrome":
	    	//System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
	    	driver = new ChromeDriver();
	        break;

	    case "mozilla":
	    	//System.setProperty("webdriver.gecko.driver", MOZILLA_DRIVER_PATH);
	    	driver = new FirefoxDriver();
	        break;

	    case "ie":
	    	//System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
	    	driver = new InternetExplorerDriver();
	        break;
		}

    	driver.get(baseURL);
		return 0;
	}
	
	
	public static void main(String[] args) {
		// Instantiate the SeleniumParamOpenBrowser class and call its openBrowser function to open different browsers and URLs

		SeleniumParamOpenBrowser TestOpenBrowser = new SeleniumParamOpenBrowser();
		TestOpenBrowser.openBrowser("chrome", "https://in.bookmyshow.com/hyderabad");
		TestOpenBrowser.openBrowser("ie", "http://www.microsoft.com");
		TestOpenBrowser.openBrowser("mozilla", "http://www.facebook.com");
		
	}

}

