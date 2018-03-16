package testnglisteners;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TestClass1 extends BaseTest {
	private static final Logger log = LogManager.getLogger(TestClass1.class.getName());
	
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		super.driver = WebDrvUtil.getBrowser(browser);

	}

	@Test
	public void testClass1_test1() {
		extTest = ExtentManager.startTest("testClass1_test1", "");
		driver.get("http://www.facebook.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebDrvUtil.takeScreenShotAndAttachToExtent(driver, this.extTest, LogStatus.INFO, "screenshot");
		extTest.log(LogStatus.INFO, "At the end of testClass1_test1");

		/*
		 * Assert.assertTrue(true); log.info(browser +
		 * " : testClass1_test1: read... Passed");
		 */ }

	/*
	 * @Test public void testClass1_test2() { Assert.assertTrue(true);
	 * ExtentManager.getTest().log(LogStatus.PASS, "TestClass1_test2: passed"); }
	 */
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
