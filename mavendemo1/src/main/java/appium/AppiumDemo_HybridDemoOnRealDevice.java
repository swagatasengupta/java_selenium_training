package appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDemo_HybridDemoOnRealDevice {

	public static void main(String[] args) throws InterruptedException, IOException {
		String deviceName = "Android Device";
		
		AndroidDriver<AndroidElement> driver;
		//String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		//cap.setCapability(MobileCapabilityType.APP, appPath);

/*		cap.setCapability("appPackage", "com.ionicframework.newoneorbt187185");
		cap.setCapability("appActivity", "com.ionicframework.newoneorbt187185.MainActivity");*/
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
		Thread.sleep(2000);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);

		TouchAction tAct = new TouchAction(driver);
		AndroidElement pref = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		tAct.tap(pref).perform();
		
		Thread.sleep(2000); 

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));");
		
		AndroidElement webView = driver.findElementByXPath("//android.widget.TextView[@text='WebView']");
		tAct.tap(webView).perform();
		
/*		Thread.sleep(2000);
		
		driver.findElementById("com.snc.test.webview2:id/action_go_website").click();
		
		driver.findElementById("com.snc.test.webview2:id/input_url").sendKeys("www.automationpractice.com");
		
		driver.findElementById("android:id/button1").click();
		
		Thread.sleep(3000);*/
		Thread.sleep(3000);
		System.out.println(driver.getContextHandles());
		
		//driver.findElementByXPath("//android.widget.Button[@text='lock']").click();
		//Thread.sleep(2000);
		//System.out.println(driver.getContextHandles());
		
/*		driver.pressKeyCode(AndroidKeyCode.HOME); //sends Home button press command
		Thread.sleep(1000);
		String scrShotFileName = System.getProperty("user.home") + File.separator + "TestScreenshot03.jpg";
		saveScreenShotAsFile(scrShotFileName, driver);*/
		
		
	}


	private static void saveScreenShotAsFile(String path, AndroidDriver<AndroidElement> driver) throws IOException {
		File scrShotSrc = driver.getScreenshotAs(OutputType.FILE);
		File scrShotDest = new File(path);
		FileUtil.copyFile(scrShotSrc, scrShotDest);


	}
	
}
