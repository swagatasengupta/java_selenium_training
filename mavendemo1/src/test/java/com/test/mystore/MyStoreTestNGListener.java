package com.test.mystore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.lib.util.PathUtil;
import com.lib.util.TimeUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyStoreTestNGListener implements ITestListener, ISuiteListener, IInvokedMethodListener  {

//	private Logger log = LogManager.getLogger(MyStoreTestNGListener.class.getName());
	private String extentPath;
	private ExtentReports extRep;
	private ExtentTest extTest, extChildTest1, extChildTest2;
	public MyStoreTestNGListener() {
		extentPath = PathUtil.getPath("FRW_BASE")
				+ PathUtil.getPath("MYSTORE_EXTENT_REP_PATH")
				+ TimeUtil.getTimeStamp()
				+ ".html";
		extRep = new ExtentReports(extentPath, false);
		extRep.assignProject("TestNG Listener Demo");
		System.out.println("MyStoreTestNGListener constructor: " + extentPath);
	}
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("ISuite onStart: " + suite.getName());
/*		extRep.addSystemInfo("Suite Name: ", suite.getName());
		extRep.addSystemInfo("Host: ", suite.getHost());*/
		//extRep.addSystemInfo("Browser: ", suite.getParameter("browser"));
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("ISuite onFinish: " + suite.getName());

	}


	@Override
	//For each Test tag in XML, start test
	public void onStart(ITestContext context) {

		extTest = extRep.startTest("Test Name: " + context.getCurrentXmlTest().getName());
		System.out.println("ITest onStart: " + context.getCurrentXmlTest().getName());

	}

	@Override
	//For each Test tag in XML, in the end, end test and flush
	public void onFinish(ITestContext context) {

		System.out.println("ITest onFinish");
		extRep.endTest(extTest);
		extRep.flush();
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
		System.out.println("IInvokedMethod beforeInvocation. " + method.getClass().getName());
		String methodName = method.getTestMethod().getMethodName();
		//If before class is being called, create a child test and append to main test
		if(methodName.toUpperCase().matches(".*BEFORE.*CLASS.*")) {
			extChildTest1 = extRep.startTest(method.getClass().getName() + "==>" + methodName);
			extTest.appendChild(extChildTest1);
		} else if (method.isTestMethod()){
			//if a @Test method is being invoked within the class
			extChildTest2 = extRep.startTest("@Test ->" + methodName);
			extChildTest1.appendChild(extChildTest2);
		}

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

		String methodName = method.getTestMethod().getMethodName();
		
		if(method.isTestMethod()) {
			extChildTest2.log(LogStatus.INFO, "End of test. Method: " + methodName);
		} else if(methodName.toUpperCase().matches(".*AFTER.*CLASS.*")){
			extChildTest1.log(LogStatus.INFO, "End of class. Method: " + methodName);
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("ITest onTestStart " + result.getTestName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extChildTest2.log(LogStatus.PASS, "ended and passed.");
		System.out.println("ITest onTestSuccess ");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//result.
		extChildTest2.log(LogStatus.FAIL, " ended and Failed");
		System.out.println("ITest onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extChildTest2.log(LogStatus.WARNING, "skipped");
		System.out.println("ITest onTestSkipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("ITest onTestFailedButWithinSuccessPercentage");

	}

}
