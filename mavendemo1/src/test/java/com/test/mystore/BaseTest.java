package com.test.mystore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.lib.genWeb.SelWebDriverUtil;
import com.lib.util.LogUtil;
import com.lib.util.PropUtil;

import log4jdemo.LoggingFile;

public class BaseTest {

	public WebDriver driver;
	//public static final Logger log = LogManager.getLogger(PropUtil.getProp("MASTER").getProperty("LOGGER_NAME"));
	public static final Logger log = LogManager.getLogger("mystore");
	public BaseTest() {
		LogUtil.log("BaseTest constructor called");
	}

	@BeforeClass
	public void beforeClass() {
//		driver = SelWebDriverUtil.getBrowser(browser, true);
		LogUtil.log("MyStoreUIWebBaseTest @BeforeClass called" );
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		LogUtil.log("MyStoreUIWebBaseTest @AfterClass called");
	}

}
