package org.seleniumrnd.scenarios.datepicker;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker_redbus {

	public static void main(String[] args) throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.redbus.in/");

		driver.manage().window().maximize();

		String year = "2021";
		String month= "July"; 
		String date="10";

				
		//Direct - didnt work
		driver.findElement(By.xpath("//input[@id='onward_cal']")).sendKeys("10-Jul-2021");  //MM/DD/YYYY
		

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

		while (true) {
			String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			String arr[]=monthyear.split(" ");
			String mon=arr[0];
			String yr=arr[1];
			
			if (month.equalsIgnoreCase(mon) && year.equals(yr))
				break;

			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
			}

		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (date.equalsIgnoreCase(dt)) {
				ele.click();
				break;
			}
		}
	}


	

}
