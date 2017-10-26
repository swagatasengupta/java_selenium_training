package extentreports1;

import com.relevantcodes.extentreports.ExtentReports;
//Extent report version 2.41.2
public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "E:\\eclipse\\Work-Space\\SeleniumTraining01\\src\\extentreports\\report-demo.html";
		extent = new ExtentReports(Path, false);
		extent
	     .addSystemInfo("Selenium Version", "2.52")
	     .addSystemInfo("Platform", "Mac");

		return extent;
	}
}