package org.seleniumrnd.scenarios.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfElement {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		
		//isDisplayed() & isEnabled()
		
		WebElement searchStore=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Display status:"+searchStore.isDisplayed());
		System.out.println("Enable Status:"+searchStore.isEnabled());
		
		//isSelected - for check box, radio buttons and dropdowns
		
		WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
				
		System.out.println(male.isSelected()); //false
		System.out.println(female.isSelected()); //false
		
		male.click(); //select male
		
		System.out.println(male.isSelected()); //true
		System.out.println(female.isSelected()); //false
		
		female.click();
		System.out.println(male.isSelected()); //false
		System.out.println(female.isSelected()); //true
		
	}

}
