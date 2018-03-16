package testnglisteners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	public ExtentReports extRep = ExtentManager.getReporter();

	public ExtentTest extTest;
	public WebDriver driver;
	//public static final Logger log = LogManager.getLogger(PropUtil.getProp("MASTER").getProperty("LOGGER_NAME"));
	public static final Logger log = LogManager.getLogger(BaseTest.class.getName());
	public BaseTest() {

	}

	@BeforeSuite
	public void beforeSuite() {
	}
	
	
	@BeforeClass
	public void beforeClass() {

	}

	@AfterClass
	public void afterClass() {
			if(driver!=null) driver.quit();			

	}

	@AfterSuite
	public void afterSuite() {

	}

}
