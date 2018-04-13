package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumAndroidPreInstalledApps2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		//String deviceName = "AVD_Nexus5X_API27x86";
		String deviceName = "Android Device";
		
		//String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver <AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		//cap.setCapability(MobileCapabilityType.APP, appPath);
		//Refer to: https://appium.io/docs/en/writing-running-appium/caps/
		cap.setCapability("appPackage", "com.google.android.calculator"); //note in my emulator it is different package name
		cap.setCapability("appActivity", "com.android.calculator2.CalculatorGoogle");
		
		//If you are not sure about package and activity name, On command line type :
		// (Open the application first)
		// adb shell "dumpsys window windows | grep -E 'mCurrentFocus | mFocusedApp'"
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);

	}

}
