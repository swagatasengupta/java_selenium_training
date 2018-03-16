package extentreports;

import java.time.LocalDateTime;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsDemo01 {

	public static ExtentReports extRep;
	public static ExtentTest extTest;
	public static ExtentTest extTest2;
	
	public static void main(String[] args) {
		extRep = ExtentManager.getReporter();
		extRep.assignProject("My Project");
		extRep.addSystemInfo("Selenium Version", "3.3.0");
		
		extTest = extRep.startTest("My Extent Test 1");
		extTest.setDescription("Description of the Test 1");
		
		extTest.log(LogStatus.INFO, "Step 1", "Hello");
		extTest.log(LogStatus.INFO, "Step 2", "This is my first extent report");
		extTest.log(LogStatus.INFO, "Some Information");
		extTest.log(LogStatus.PASS, "Something passed");
		extTest.log(LogStatus.FAIL, "Something failed");
		extTest.log(LogStatus.ERROR, "Some Error");
		extTest.log(LogStatus.WARNING, "Some Warning");
		extTest.log(LogStatus.SKIP, "Some test skipped");
		extTest.log(LogStatus.FATAL, "Some fatal error");
		extTest.log(LogStatus.UNKNOWN, "Something unknown status");
		
		try {
			int a = Integer.parseInt("Text");
		} catch(NumberFormatException nfe) {
			extTest.log(LogStatus.ERROR, nfe);
			extTest.log(LogStatus.ERROR, "Error in step x", nfe);
		}
		
		delay(1);
		
		extTest.setEndedTime(new Date());
		extTest = extRep.startTest("My Extent Test 2");
		delay(1);
		extTest.log(LogStatus.PASS, "Successful! This test case passed");
		extTest.log(LogStatus.INFO, "Now will flush the extent test and save the report");
		
		extTest2 = extRep.startTest("My Extent Test 2.1 - nested test");
		extTest2.log(LogStatus.INFO, "Some details of third test");
		extTest2.log(LogStatus.PASS, "Passed step of third test");
		extTest2.log(LogStatus.FAIL, "Failed step of third test");
		delay(1);
		extTest2.setEndedTime(new Date());
		extTest.appendChild(extTest2);
		
		extRep.endTest(extTest);
		extRep.flush();
		
	}

	 public static void delay(int timeInSecs) {
		
		try {
			Thread.sleep(timeInSecs * 1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
}
}
