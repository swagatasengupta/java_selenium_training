package com.lib.util.listeners;

import com.relevantcodes.extentreports.LogStatus;

import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.test.mystore.BaseTest;
import com.lib.genWeb.SelWebDriverUtil;
import com.lib.util.LogUtil;
import com.lib.util.extent.ExtentManager;
import com.lib.util.extent.ExtentTestManager;

public class TestListener extends BaseTest implements ITestListener {

	private String suiteName;

	private boolean isCurrentTestTypeWebUI(ITestResult iTestResult) {
		boolean retVal;
		Map<String, String> paramList = iTestResult.getTestContext().getCurrentXmlTest().getAllParameters();
		if (paramList.isEmpty()) {
			retVal = false;
		} else {
			String valTestType = paramList.get("testType");
			if (valTestType != null && valTestType == "UIWeb") {
				retVal = true;
			} else {
				retVal = false;
			}

		}
		return retVal;
	}

	private static int getTestDurationInMilliSec(ITestResult iTestResult) {
		return (int) (iTestResult.getEndMillis() - iTestResult.getStartMillis());
	}

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Before starting all tests, below method runs.
	@Override
	public void onStart(ITestContext iTestContext) {
		LogUtil.log("TRACE","TestListener >> onStart method" + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.driver);
		suiteName = iTestContext.getSuite().getName();
	}

	// After ending all tests, below method runs.
	@Override
	public void onFinish(ITestContext iTestContext) {
		LogUtil.log("TRACE","TestListener >> onFinish method " + iTestContext.getName());
		// Do tear down operations for extentreports reporting!
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		LogUtil.log("TRACE","TestListener >> onTestStart method, test: " + getTestMethodName(iTestResult) + " start");
		// Start operation for extentreports.
		ExtentTestManager.startTest(
				suiteName + " : "
				+ iTestResult.getTestContext().getCurrentXmlTest().getName() + " : " 
				+ iTestResult.getMethod().getMethodName(),
				"Test Parameters: " + iTestResult.getTestContext().getCurrentXmlTest().getAllParameters().toString());
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {

		LogUtil.log("TRACE","TestListener >> onTestSuccess method, test: " + getTestMethodName(iTestResult) + " succeed");
		// Extentreports log operation for passed tests.
		ExtentTestManager.getTest().log(LogStatus.PASS, getTestMethodName(iTestResult) + " Test passed. "
				+ "Duration (milli seconds): " + getTestDurationInMilliSec(iTestResult));
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		LogUtil.log("TRACE","TestListener >> onTestFailure method, test: " + getTestMethodName(iTestResult) + " failed");

		if(isCurrentTestTypeWebUI(iTestResult)) {
			// Get driver from BaseTest and assign to local webdriver variable.
			Object testClass = iTestResult.getInstance();
			WebDriver webDriver = ((BaseTest) testClass).driver;

			SelWebDriverUtil.takeScreenShotAndAttachToExtent(webDriver,
					LogStatus.FAIL,
					getTestMethodName(iTestResult) + " Test failed.");
			LogUtil.log("FAIL", getTestMethodName(iTestResult) + " Test failed. Screenshot is attached.");
/*			// Take base64Screenshot screenshot.
			String base64Screenshot = "data:image/png;base64,"
					+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);

			// Extentreports log and screenshot operations for failed tests.
			ExtentTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(iTestResult) + " Test Failed",
					ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
*/			
		} else {
			LogUtil.log("FAIL", getTestMethodName(iTestResult) + " failed");
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

		LogUtil.log("WARNING", "TestListener >> onTestSkipped method, test: " + getTestMethodName(iTestResult) + " skipped");
		// Extentreports log operation for skipped tests.
		ExtentTestManager.getTest().log(LogStatus.SKIP, getTestMethodName(iTestResult) + " Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		LogUtil.log("WARNING", "Test failed but it is in defined success ratio: "
				+ ITestResult.SUCCESS_PERCENTAGE_FAILURE
				+ ", test: "+ getTestMethodName(iTestResult));
	}

}
