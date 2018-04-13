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
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumAndroidSwipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String deviceName = "AVD_Nexus5X_API27x86";
		
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

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gallery\"));");
		
		AndroidElement gallery = driver.findElementByXPath("//android.widget.TextView[@text='Gallery']");
		tAct.tap(gallery).perform();
		
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Photos')]").click();
		
		Thread.sleep(2000);
		AndroidElement galleryPhotoContainer = driver.findElementById("io.appium.android.apis:id/gallery");

		//Single Swipe
		List<AndroidElement> images = driver.findElementsByClassName("android.widget.ImageView");
			System.out.println("Images: " + images.size());
			tAct.press(images.get(1)).moveTo(images.get(0)).release().perform();
			Thread.sleep(1000);
		//continuous swipe

/*			//Hard coding
			for (int i = 1; i<=2; i++) {
				tAct.press(900, 300).moveTo(-100, 300).release().perform();
				Thread.sleep(1000);
			}		
*/		
		Dimension dim = galleryPhotoContainer.getSize();
		Coordinates coord = galleryPhotoContainer.getCoordinates();
		
		System.out.println("coordinates of gallery" + coord.toString());
		int height = dim.getHeight();
		int width = dim.getWidth();
		
		
		int swipeOrigX = (int)(width * 0.7);
		int swipeOrigY = (int)(height * 0.5) + galleryPhotoContainer.getLocation().y;
		int swipeDestOffsetX = -100;
		
		System.out.printf("Dimension of Gallery: %d , %d \n", width, height);
		System.out.printf("Swipe Coordinates: start x= %d, start y= %d, end offset x = %d \n", swipeOrigX, swipeOrigY, swipeDestOffsetX);
		
		for (int i = 1; i<=3; i++) {
			//note: moveTo acts differently with longPress and press. For longPress it is actual coordinate, for press, it is offset			tAct.press(swipeOrigX, swipeOrigY).moveTo(swipeDestOffsetX, swipeOrigY).release().perform();
			Thread.sleep(1500);
		}
		


	}

}
