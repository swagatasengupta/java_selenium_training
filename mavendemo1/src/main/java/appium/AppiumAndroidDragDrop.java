package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumAndroidDragDrop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String deviceName = "Android Device";
		//String deviceName = "ZY22447WCX";
		String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver <AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.APP, appPath);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TouchAction tAct = new TouchAction(driver);
		AndroidElement pref = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		tAct.tap(pref).perform();
		
		Thread.sleep(2000); 

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));");
		
		AndroidElement visibility = driver.findElementByXPath("//android.widget.TextView[@text='Visibility']");
		tAct.tap(visibility).perform();

	}

}
