package org.seleniumrnd.scenarios.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium");//Search box
		Thread.sleep(5000);
				
		List <WebElement> list=driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
			
		System.out.println(list.size());
		
		for(WebElement item:list)
		{
			if(item.getText().equals("selenium"))
			{
				item.click();
				break;
			}
		}
		
	}

}
