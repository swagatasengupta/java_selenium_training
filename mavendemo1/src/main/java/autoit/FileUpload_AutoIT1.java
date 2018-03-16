package autoit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload_AutoIT1 {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseUrl = "https://www.gmail.com/";
		driver = new FirefoxDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void fileUpload() throws AWTException, InterruptedException {
		driver.findElement(By.id("identifierId")).sendKeys("swagatasengupta");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		String decodedPassword = new String(Base64.getDecoder().decode("R3JlYXQkaDB3MQ=="));
		driver.findElement(By.xpath("//*[@id='password']//input[@autocomplete='current-password']")).clear();
		driver.findElement(By.xpath("//*[@id='password']//input[@autocomplete='current-password']")).sendKeys(decodedPassword); // Enter your password
		driver.findElement(By.id("passwordNext")).click();
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		//driver.findElement(By.name("to")).sendKeys("swagatasengupta@gmail.com");
		//driver.findElement(By.name("subjectbox")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@data-tooltip='Attach files']"));
		fileInput.click();
		
		StringSelection ss = new StringSelection("C:\\Users\\Swagat\\Desktop\\testfile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

	@AfterClass
	public void afterClass() {
	}

}