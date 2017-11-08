

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.lib.util.TimeUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.lib.util.FileUtil;
import com.lib.util.PathUtil;


public class Temp {
private static Logger log = LogManager.getLogger(Temp.class.getName());

	public static void main(String[] args) {

		
		if("beforeClass".toUpperCase().matches(".*BEFORE.*CLASS.*")) System.out.println("Before Class Called");
		if("beforeMyStoreUIWebClass".toUpperCase().matches(".*BEFORE.*CLASS.*")) System.out.println("Before Class Called");
		if("AfterMethod".toUpperCase().matches(".*AFTER.*CLASS.*")) System.out.println("After Class Called");
		
		
/*				String extentPath;
		ExtentReports extRep;
		ExtentTest extTest;
		ExtentTest extTest2, extTest3;
		extentPath = PathUtil.getPath("FRW_BASE")
				+ PathUtil.getPath("MYSTORE_EXTENT_REP_PATH")
				+ TimeUtil.getTimeStamp()
				+ ".html";
		extRep = new ExtentReports(extentPath, false);
		extRep.addSystemInfo("Selenium Version", "2.52");
		extRep.addSystemInfo("Platform", "Windows");
		//extRep.addSystemInfo("OS: ", System.getenv("os.name"));
		extTest = extRep.startTest("Started test");
		extTest.log(LogStatus.INFO, "some info");
		extTest2 = extRep.startTest("Started test 1.1");
		extTest.appendChild(extTest2);
		extTest2.log(LogStatus.PASS, "child 1.1 test passed");
		extTest3 = extRep.startTest("Started test 1.2");
		extTest3.log(LogStatus.FAIL, "child 1.2 test failed");
		extTest.appendChild(extTest3);
		extTest.log(LogStatus.PASS, "some pass");
		extTest.log(LogStatus.FAIL, "some fail");
		extRep.endTest(extTest);
		extRep.flush();
*/		//log.fatal("message");
		//
		//System.out.println(TimeUtil.getTimeStamp());
		//System.out.println(TimeUtil.getTimeStamp("HH-mm-ss-SS, dd/MMM/yyyy"));
		//FileUtil.copyAllFiles("E:\\test_e", "F:\\Music\\Mashups", false);
/*		FileUtil.moveFile("E:\\test_e\\test1.txt", "F:\\Music\\Mashups", true);
		FileUtil.moveFile("E:\\test_e\\test2.txt", "F:\\Music\\Mashups", "test123.txt", true);
		FileUtil.moveFile("E:\\test_e\\test3.txt", "F:\\Music\\Mashups", true);*/
		
		//FileUtil.moveAllFiles("E:\\test_e", "F:\\Music\\Mashups", true);
		//cleanUpEmptyDirectoryHeirarchy("E:\\test_e");
/*		try {
			deleteRecursive(new File("E:\\test_e"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println(new File("F:\\Music\\Mashups\\folder1").isDirectory());
		
/*		System.out.println(System.getProperty("os.name").toLowerCase().contains("windows"));
		System.out.println(File.separator);
*/
/*		System.out.println("encodedBytes "+ Base64.getEncoder().encodeToString("12345".getBytes()));
		byte[] decodedPwd = Base64.getDecoder().decode("MTIzNDU=");
		System.out.println(new String(decodedPwd));*/
/*		File allDirs = new File("C:\\Users\\Swagat\\Desktop\\Dir1\\Dir2\\Dir3");
		if(allDirs.mkdirs()) {
			System.out.println("created all directories successfully");
		
		}	
*/
	}

}
