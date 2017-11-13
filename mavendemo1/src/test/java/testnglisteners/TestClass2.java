package testnglisteners;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TestClass2 extends BaseTest {
	private static final Logger log = LogManager.getLogger(TestClass2.class.getName());

	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		super.driver = WebDrvUtil.getBrowser(browser);
	}

	@Test
	public void testClass2_test1() {
		extTest = ExtentManager.startTest("testClass2_test1 started", "");
		driver.get("http://www.google.com");
		driver.findElement(By.className("IncorrectClassName")).sendKeys("Hello");
		/*
		 * Assert.assertTrue(true); log.info(browser +
		 * " : testClass1_test1: read... Passed");
		 */
	}

	@Test
	public void testClass2_test2() {
		driver.get("http://www.expedia.com");
		extTest = ExtentManager.startTest("testClass2_test2 started", "");		
		Assert.assertTrue(true);
		extTest.log(LogStatus.PASS, "Forced pass: testClass2_test2");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
