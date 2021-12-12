package org.seleniumrnd.scenarios.datepicker;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/datepicker/");

		driver.manage().window().maximize();

		String year = "2020";
		String month= "March"; 
		String date="10";

		driver.switchTo().frame(0);
		
		//Direct
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("03/15/2021");  //MM/DD/YYYY
		

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (month.equalsIgnoreCase(mon) && year.equals(yr))
				break;

			else
				//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Future
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Past
			}

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
