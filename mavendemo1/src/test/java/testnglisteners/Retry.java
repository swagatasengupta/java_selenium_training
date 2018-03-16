package testnglisteners;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Retry extends BaseTest implements IRetryAnalyzer {

	private int count = 1;
	private static int maxTry = 1; // Run the failed test 2 times (count = 1, 2) at max
	
	@Override
	public boolean retry(ITestResult iTestResult) {

		if (!iTestResult.isSuccess()) { // Check if test not succeed
			if (count <= maxTry) { // Check if maxtry count is reached
				iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed
				count++; // Increase the maxTry count by 1
				extReportsAttachScreenshotOnFailure(iTestResult); // ExtentReports fail operations
				return true; // Tells TestNG to re-run the test
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
		}
		return false;
	}
	public synchronized void extReportsAttachScreenshotOnFailure(ITestResult iTestResult) {

		Object testClass;
		WebDriver webDriver;

		testClass = iTestResult.getInstance();
		webDriver = ((BaseTest) testClass).driver;
		WebDrvUtil.takeScreenShotAndAttachToExtent(webDriver, ExtentManager.getTest(), LogStatus.FAIL,
					iTestResult.getTestContext().getCurrentXmlTest().getName() + " test failed.");

	}


}