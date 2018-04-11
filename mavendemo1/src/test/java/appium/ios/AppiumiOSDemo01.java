package appium.ios;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumiOSDemo01 {

	//public static String APP_PATH = "/Users/swagat/iOSTestApps/UICatalog.app";
	public static String APP_PATH = "/Users/swagat/Library/Developer/Xcode/DerivedData/UICatalog-aqgcratbeicdkpdxrrwmnbfbncnl/Build/Products/Debug-iphonesimulator/UICatalog.app";
	
	public static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Plus");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(MobileCapabilityType.APP,APP_PATH);
		
		IOSDriver<IOSElement> driver = new IOSDriver<>(new URL(APPIUM_SERVER_URL),cap);
		
		
		
		
		
		

	}

}
