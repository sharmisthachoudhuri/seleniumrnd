package org.seleniumrnd.scenarios.datepicker;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker_dropdown {

	public static void main(String[] args) throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='dob']")).click();

		Select datepicker_month=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		datepicker_month.selectByVisibleText("Jul");
		
		Select datepicker_year=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		datepicker_year.selectByVisibleText("1990");
		
		String date="10";
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (date.equalsIgnoreCase(dt)) {
				ele.click();
				break;
			}
		}
		
		
	}


	

}
