package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumAndroidChrome01 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		//String deviceName = "AVD_Nexus5X_API27x86";
		String deviceName = "Android Device";
		
		//String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver <AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.automationpractice.com");
		
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("swagatasengupta@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("SubmitLogin")).click();
		
		Thread.sleep(2000);

	}

}
