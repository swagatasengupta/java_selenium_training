package com.lib.util;

import com.lib.util.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.test.BaseTest;

public class LogUtil {

	public static synchronized void log(String msg) {
		BaseTest.log.trace(msg);
		// ExtentTestManager.getTest().log(LogStatus.INFO, msg);
	}

	public static synchronized void log(String msg, Exception e) {
		BaseTest.log.error(msg + "\n\nError: " + e.getStackTrace().toString());
		ExtentTestManager.getTest().log(LogStatus.ERROR, msg + "; Error: " + e.toString());
	}

	public static synchronized void log(String logLevel, String msg, Exception e) {
		String stackTrace = null;
		if (e != null) {
			stackTrace = "Stack Trace: \n" + e.getStackTrace().toString();
		}
		switch (logLevel.toUpperCase()) {
		case "TRACE":
			BaseTest.log.trace(msg + stackTrace);
			break;
		case "DEBUG":
			BaseTest.log.debug(msg + stackTrace);
			break;
		case "ERROR":
			BaseTest.log.error(msg + stackTrace);
			ExtentTestManager.getTest().log(LogStatus.ERROR, msg + e.toString() + " Please check log for more details");
			break;
		case "FATAL":
			BaseTest.log.fatal(msg + stackTrace);
			ExtentTestManager.getTest().log(LogStatus.FATAL, msg + e.toString() + " Please check log for more details");
			break;
		case "INFO":
			BaseTest.log.info(msg + stackTrace);
			ExtentTestManager.getTest().log(LogStatus.INFO, msg);
			break;
		case "WARNING":
			BaseTest.log.warn(msg + stackTrace);
			ExtentTestManager.getTest().log(LogStatus.WARNING,
					msg + e.toString() + " Please check log for more details");
			break;
		case "PASS":
			BaseTest.log.debug(msg + stackTrace);
			ExtentTestManager.getTest().log(LogStatus.PASS, msg);
			break;
		case "FAIL":
			BaseTest.log.error(msg + stackTrace);
			ExtentTestManager.getTest().log(LogStatus.FAIL, msg);
			break;
		default:
			BaseTest.log.warn(msg + stackTrace);
			break;
		}
	}

	public static synchronized void log(String logLevel, String msg) {
		log(logLevel, msg, null);
	}

}
