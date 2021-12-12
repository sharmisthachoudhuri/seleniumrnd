package org.seleniumrnd.scenarios.dropdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSortedOptions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
				
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		
		WebElement drpElement = driver.findElement(By.name("category_id"));
		Select drpSelect=new Select(drpElement);
		
		
		List<WebElement>options=drpSelect.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for (WebElement option : options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}

		System.out.println("this is originalList before Sorting	:"+ originalList);
		System.out.println("this is tempList before Sorting		:"+ tempList);
		
		Collections.sort(tempList);
		
		System.out.println("this is originalList after Sorting	:"+ originalList);
		System.out.println("this is tempList after Sorting		:"+ tempList);
				
		if(originalList.equals(tempList))
		{
			System.out.println("Dropdown sorted");
		}
		else
		{
			System.out.println("Dropdown Not sorted");
			
		}
		driver.close();
	}

}
