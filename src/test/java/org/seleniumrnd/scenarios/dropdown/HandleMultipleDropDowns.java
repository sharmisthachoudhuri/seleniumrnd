package org.seleniumrnd.scenarios.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {

	static WebDriver driver;
	
	public static void main(String[] args)  
		{
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

			WebElement noOfEmpsDrp=driver.findElement(By.xpath("//select[@id='Form_submitForm_NoOfEmployees']"));
			WebElement industryDrp=driver.findElement(By.xpath("//select[@id='Form_submitForm_Industry']"));
			WebElement countryDrp=driver.findElement(By.xpath("//select[@id='Form_submitForm_Country']"));

			// Calling Generic method for all the dropdowns
			selectOptionFromDropDown(noOfEmpsDrp,"21 - 25");
			selectOptionFromDropDown(industryDrp, "Healthcare");
			selectOptionFromDropDown(countryDrp, "United States");

		}

		
		public static void selectOptionFromDropDown(WebElement element, String value) 
			{
			    Select drpdown=new Select(element);
				List<WebElement> optionsList = drpdown.getOptions();
	
				for (WebElement e : optionsList) 
				{
					if (e.getText().equals(value)) 
					{
						e.click();
						break;
					}
				}
		}
		
		
	}
