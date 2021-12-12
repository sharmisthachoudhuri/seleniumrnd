package org.seleniumrnd.scenarios.datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//findElement() ---> Returns Single WebElement
		
		//1)
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']")); //Locator matching single web element
		searchbox.sendKeys("Apple MacBook Pro 13-inch");
		
		//2)
		WebElement image=driver.findElement(By.xpath("//div[@class='footer-upper']//a")); //Locator matching multiple web elements - footer links
		System.out.println(image.getText());
		
		//3) 
		//WebElement searchbtn=driver.findElement(By.xpath("button[type='login']"));  // Element not available then throw NoSuchElementException
		
		
		
		//findElements() ---> Returns Multiple WebElements
		
		//1)
		List<WebElement> elements=driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']")); //Locator matching single web element
		System.out.println(elements.size());  // returns 1
		
		//2)
		List<WebElement> links=driver.findElements(By.xpath("//div[@class='footer-upper']//a")); //Locator matching multiple web elements - footer links
		System.out.println(links.size());
		
		//3) iterating elements
		for(WebElement e:links)
		{
			System.out.println(e.getText());
		}

		//4 - No Exception - Zero returns
		List<WebElement> electronicImges=driver.findElements(By.xpath("//img[contains(title,'Electronics')]")); 
		
		System.out.println(electronicImges.size());
	}

}
