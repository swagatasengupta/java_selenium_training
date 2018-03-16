package SeleniumTestDemo01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarDatePickerSouthwest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.southwest.com/");
		
		WebElement depDate = driver.findElement(By.id("air-date-departure"));
		depDate.click();
		Thread.sleep(2000);
		//WebElement currMonth = driver.findElements(By.xpath("//div[@class='calendar-month']")).get(0);
		//List<WebElement> currMonthDates = currMonth.findElements(By.xpath("//td[contains(@class, 'js-available')]"));
		List<WebElement> currMonthDates = driver.findElements(By.xpath("(//div[@class='calendar-month'])[1]//td[contains(@class, 'js-available')]"));
		System.out.println("available dates in current month: " + currMonthDates.size());
		for(WebElement date : currMonthDates) {
			if(date.getText().equals("27")) {
				date.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
