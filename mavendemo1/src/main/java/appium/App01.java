package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class App01 {

	public static void main(String[] args) {
		AndroidDriver<AndroidElement> driver;
		File app = new File("C:\\Users\\Swagat\\Downloads\\API Demos for Android_v1.9.0_apkpure.com.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("device","Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"SwagatNexus5XAPI27");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Swagat\\Downloads\\ApiDemos-debug.apk");
        System.out.println(capabilities.toString());
        //mandatory capabilities
/*        capabilities.setCapability("deviceName","Swagat Sengupta (Galaxy Note3)");
        capabilities.setCapability("platformName","Android");
*/
        //other caps
/*        capabilities.setCapability("app", app.getAbsolutePath());
*/        try {
			driver =  new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
