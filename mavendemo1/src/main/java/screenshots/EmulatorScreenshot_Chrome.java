package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmulatorScreenshot_Chrome {

	public static void main(String[] args) throws IOException, JSONException {

		String url = "http://www.mytritechsolutions.com/";
		String [] devices = {"desktop", "iPad", "iPhone 6" };
		
		List <JSONObject> jsonResponses = new ArrayList<JSONObject>();
		
		for (String device : devices) {
			JSONObject returnJsonObj = getLoadTimeAndScreenshot(url, device);
			jsonResponses.add(returnJsonObj);
		}
		
		//Print all the responses together
		for (JSONObject jsonResponse: jsonResponses) {
			System.out.println("Page load started on emulator: " + jsonResponse.get("device") + " at "
					+ jsonResponse.get("pageLoadStartTime") + " milli seconds");
			System.out.println("Page load completed on emulator: " + jsonResponse.get("device") + " at "
					+ jsonResponse.get("pageLoadEndTime") + " milli seconds");
			System.out.println("Time taken to load page on emulator: " + jsonResponse.get("device") + " = "
					+ jsonResponse.get("pageLoadTime") + " milli seconds");
			System.out.println("Screenshot for emulator: " + jsonResponse.get("device") + " is at "
					+ jsonResponse.get("screenshotPath"));
		}

		
	}

	/*
	 * This function is to take screenshot of a given URL on a given device type
	 * It can be browser or mobile. It uses chrome emulator to take screenshots in headless mode
	 * and also returns page load star and end times in milliseconds
	 * 
	 * Note: deviceType is case sensitive. Valid values are defined in
	 * https://cs.chromium.org/chromium/src/chrome/test/chromedriver/chrome/mobile_device_list.cc
	 * In the below example, following are handled "iPad", "iPhone 6" and "desktop"
	 *
	 *DEPENDENCIES
	 *
	 *http://chromedriver.storage.googleapis.com/index.html?path=2.33/
	 *download http://chromedriver.storage.googleapis.com/2.33/chromedriver_linux64.zip
	 *and unzip in any directory that is already PATH (or set the path accordingly
	 *
	 * Please add this in POM.xml
	 *<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.6.0</version>
		</dependency>

	 * 
	 */
	
	public static JSONObject getLoadTimeAndScreenshot(String url, String device) throws IOException, JSONException {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true);
		Dimension dim = new Dimension(1440, 900);
		//screenshot destination path
		String destPath = System.getProperty("user.home")+ File.separator + device + "_screenshot.png";
		
		//If device is not a desktop, enable mobile emulation
		if(!device.equals("desktop")) {
			Map<String, String> mobileEmulation = new HashMap<>();
			//device is used as provided by the calling function.
			//May result in invalid device name unless called properly
			mobileEmulation.put("deviceName", device);
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);			
		}
		
		
		WebDriver driver = new ChromeDriver(chromeOptions);

		//if device is desktop, set window size
		if(device.equals("desktop")) {
			driver.manage().window().setSize(dim);
		}
		
		long starttime = System.currentTimeMillis();
		
		driver.get(url);
		
		//30 is timeout in seconds. Wait till javascript returns page loaded completely
		// below lambda expression needs Java 8+
		new WebDriverWait(driver, 30).until(webdrv -> ((JavascriptExecutor) webdrv).executeScript("return document.readyState").equals("complete"));				
		
		long endtime = System.currentTimeMillis();
		
		//Take screenshot, 
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(destPath));
		System.out.println("total page load time: " + (endtime - starttime) + "milli seconds");
		driver.quit();
		
		JSONObject json = new JSONObject();
			json.put("device",device);
			json.put("pageLoadStartTime", starttime);
			json.put("pageLoadEndTime", endtime);
			json.put("pageLoadTime", (endtime - starttime));
			json.put("screenshotPath", destPath);

		return json;
	}
	
}
