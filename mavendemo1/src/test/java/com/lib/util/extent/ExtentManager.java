package com.lib.util.extent;

import com.lib.util.PathUtil;
import com.lib.util.TimeUtil;
import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

  private static ExtentReports extent;
//getReported function returns extent report. If report is not initialized, it initializes report and then returns the initialized object.
  public synchronized static ExtentReports getReporter(){
      if(extent == null){
          //Set HTML reporting file location
          String path = PathUtil.getPath("FRW_BASE") 
        		  + PathUtil.getPath("MYSTORE_EXTENT_REP_PATH")
        		  + TimeUtil.getTimeStamp() 
        		  + ".html";
          
          extent = new ExtentReports(path, true);
      }
      return extent;
  }
}