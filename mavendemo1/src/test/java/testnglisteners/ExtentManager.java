package testnglisteners;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {
	static Map extentTestMap = new HashMap();
	private static ExtentReports extent = getReporter();

	// getReported function returns extent report. If report is not initialized, it
	// initializes report and then returns the initialized object.
	public static ExtentReports getReporter() {
		if (extent == null) {
			// Set HTML reporting file location
			String path = "E:\\GIT\\java_selenium_training\\mavendemo1\\src\\main\\java\\logs\\testReport1.html";

			extent = new ExtentReports(path, true);
		}
		return extent;
	}

	public static synchronized ExtentTest getTest() {
		long currTestThreadID = Thread.currentThread().getId();
		return (ExtentTest) extentTestMap.get((int) currTestThreadID);
	}

	public static synchronized void endTest() {
		long currTestThreadID = Thread.currentThread().getId();
		extent.endTest((ExtentTest) extentTestMap.get((int) currTestThreadID));
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.startTest(testName, desc);
		long currTestThreadID = Thread.currentThread().getId();
		extentTestMap.put((int) currTestThreadID, test);
		return test;
	}
}