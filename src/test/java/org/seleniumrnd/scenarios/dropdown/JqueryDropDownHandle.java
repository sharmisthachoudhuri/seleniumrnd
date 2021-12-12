package org.seleniumrnd.scenarios.dropdown;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(3000);

		// selectChoiceValues(driver, "choice 2", "choice 2 3", "choice 6", "choice 6 2
		// 1", "choice 6 2");
		// selectChoiceValues(driver, "choice 1");
		selectChoiceValues(driver, "All");

	}

	/*
	 * this method is used to select the drop down values: 1. select a single value
	 * "choice 1" 2. select multi values "choice 1", "choice 2", "choice 6 2" 3.
	 * select all the values - "all" or "All" or "ALL"
	 */

	public static void selectChoiceValues(WebDriver driver, String... value) throws InterruptedException {

		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		System.out.println(choiceList.size());

		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement item : choiceList) {
				String text = item.getText();
				// System.out.println(text);

				for (String val : value) {
					if (text.equals(val)) {
						item.click();
						break;
					}
				}
			}
		}

		// select all the values
		else {
			try
			{
				for (WebElement item : choiceList) {
					item.click();
				}
			}catch(Exception e)
			{
				
			}
			
		}
	}

}
