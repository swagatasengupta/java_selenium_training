package testnglisteners;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CustomITestListener extends BaseTest implements ITestListener {

	private static final Logger log = LogManager.getLogger(CustomITestListener.class.getName());

	@Override
	public void onStart(ITestContext context) {
		context.setAttribute("WebDriver", this.driver);	
		log.info("onStart ==> Test : " + context.getCurrentXmlTest().getName());
		System.out.println("onStart");
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		log.info("onTestStart: " + getFormedTestName(result));
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//extTest.log(LogStatus.PASS, "Test: " + getFormedTestName(result) + " has passed.");
		ExtentManager.getTest().setEndedTime(new Date());
		ExtentManager.getTest().log(LogStatus.PASS, getFormedTestName(result) + " has passed.");
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//extTest.log(LogStatus.FAIL, "Test: " + getFormedTestName(result) + " has failed.");
		ExtentManager.getTest().setEndedTime(new Date());
		ExtentManager.getTest().log(LogStatus.FAIL, getFormedTestName(result) + " has failed.");
		System.out.println("onTestFailure");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//extTest.log(LogStatus.SKIP, "Test: " + getFormedTestName(result) + " has been skipped.");
		ExtentManager.getTest().setEndedTime(new Date());
		ExtentManager.getTest().log(LogStatus.SKIP, getFormedTestName(result) + " has been skipped.");
		System.out.println("onTestSkipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("onTestFailedButWithinSuccessPercentage : " + "Test: "
				+ getFormedTestName(result)
				+ " has failed but with success percentage");
		ExtentManager.getTest().log(LogStatus.FAIL, getFormedTestName(result) + " has failed with success percentage.");
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("onFinish ==> Test : " + context.getCurrentXmlTest().getName());
		
		System.out.println("onFinish");
		ExtentManager.endTest();
		ExtentManager.getReporter().flush();


	}

	private static String getFormedTestName(ITestResult iTestResult) {
		
		String testName = iTestResult.getTestContext().getCurrentXmlTest().getName()
				+ " ==> " + iTestResult.getMethod().getMethodName()
				+ "\n Parameters: " + iTestResult.getTestContext().getCurrentXmlTest().getAllParameters().toString();
		return testName;
	}
}
