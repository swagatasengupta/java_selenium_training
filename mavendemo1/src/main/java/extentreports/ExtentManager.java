package extentreports;

import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

  private static ExtentReports extent;
//getReported function returns extent report. If report is not initialized, it initializes report and then returns the initialized object.
  public static ExtentReports getReporter(){
      if(extent == null){
          //Set HTML reporting file location
          String path = "E:\\GIT\\java_selenium_training\\mavendemo1\\src\\main\\java\\logs\\testReport1.html";
          
          extent = new ExtentReports(path, true); 
      }
      return extent;
  }
}