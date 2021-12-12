package org.seleniumrnd.scenarios.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.seleniumrnd.base.BaseTest;
import org.testng.annotations.Test;

public class HandleDropDown extends BaseTest {

	@Test
	public void testDropDown() throws InterruptedException {
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement drpCountryEle=driver.findElement(By.id("input-country"));
		Select drpCountry=new Select(drpCountryEle);
		
		//1) Selecting option from DropDown
		drpCountry.selectByVisibleText("United States");
		Thread.sleep(3000);
		
		drpCountry.selectByValue("222");  //United Kingdom
		Thread.sleep(3000);
		
		drpCountry.selectByIndex(10);  //Argentina
		Thread.sleep(3000);
		
		//2) Finding Number of Options
		int noOfOptions=drpCountry.getOptions().size();
		System.out.println("Number Of Country options:"+noOfOptions);
		
		//3) Capture all the options - Choosing option without using built-in method
		List<WebElement>alloptions=drpCountry.getOptions();
		
		for(WebElement option:alloptions)
		{
			if(option.getText().equals("Canada"))
			{
				option.click();
				break;
			}
		}
		
		
	}

}
