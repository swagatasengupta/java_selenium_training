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

public class AppiumAndroidPreInstalledApps {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String deviceName = "AVD_Nexus5X_API27x86";

		
		AndroidDriver <AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

		//Refer to: https://appium.io/docs/en/writing-running-appium/caps/
		cap.setCapability("appPackage", "com.android.calculator2"); 
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		/*---------------- One way to write expression and send right input to calculator*/
		String[] evalExpression = {"1","2","x","6","="};
		String expectedResult = "72";
		
		TouchAction tAct = new TouchAction(driver);
		for(String inp : evalExpression) {
			tAct.tap(driver.findElementById(getID(inp))).perform();
		}
		
		String result = driver.findElementById(getID("result")).getAttribute("text");
		
		if(result.equals(expectedResult)) {
			System.out.println("Successfully verified result");
		} else {
			System.out.printf("Result is %d while expected is %d \n", result, expectedResult);
		}

		/*---------------- Another way to write expression and send right input to calculator*/
		String expression2 = "12.5x5=";
		String expRes2 = "62.5";
		
		for(char inp : expression2.toCharArray()) {
			String strInt = String.valueOf(inp);
			tAct.tap(driver.findElementById(getID(strInt))).perform();
		}
		result = driver.findElementById(getID("result")).getAttribute("text");
		if(result.equals(expRes2)) {
			System.out.println("Successfully verified result");
		} else {
			System.out.printf("Result is %d while expected is %d \n", result, expectedResult);
		}		

		//Finally press home
		driver.pressKeyCode(AndroidKeyCode.HOME);
	}

	private static String getID(String inp) {
		switch (inp.toLowerCase()) {
		case "1":
			return "com.android.calculator2:id/digit_1";
		case "2":
			return "com.android.calculator2:id/digit_2";
		case "3":
			return "com.android.calculator2:id/digit_3";
		case "4":
			return "com.android.calculator2:id/digit_4";
		case "5":
			return "com.android.calculator2:id/digit_5";
		case "6":
			return "com.android.calculator2:id/digit_6";
		case "7":
			return "com.android.calculator2:id/digit_7";
		case "8":
			return "com.android.calculator2:id/digit_8";
		case "9":
			return "com.android.calculator2:id/digit_9";
		case "0":
			return "com.android.calculator2:id/digit_0";
		case "+":
			return "com.android.calculator2:id/op_add";
		case ".":
			return "com.android.calculator2:id/dec_point";
		case "-":
			return "com.android.calculator2:id/op_sub";
		case "x":
			return "com.android.calculator2:id/op_mul";
		case "/":
			return "com.android.calculator2:id/op_div";
		case "=":
			return "com.android.calculator2:id/eq";
		case "result":
			return "com.android.calculator2:id/result";
		case "formula":
			return "com.android.calculator2:id/formula";
		default:
			return null;
		}

	}

}
