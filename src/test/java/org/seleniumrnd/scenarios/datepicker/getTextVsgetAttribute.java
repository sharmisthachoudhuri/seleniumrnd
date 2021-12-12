package org.seleniumrnd.scenarios.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttribute {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
				
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		WebElement emailinputbox=driver.findElement(By.xpath("//input[@id='Email']"));			
				
		emailinputbox.clear(); //clearing text box
		emailinputbox.sendKeys("admin@yourstore.com");  // Entering value
		
		
		System.out.println("Result from getText():"+emailinputbox.getText()); // No output bcoz there is no inner text
		System.out.println("Result from getAttribute():"+emailinputbox.getAttribute("value")); //Returns text bcoz value attribute is available in html
		
					
		WebElement buttontext=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		System.out.println("Result of getText() of Login Button:"+buttontext.getText());
		System.out.println("Result of getAttribute('type') of Login Button:"+buttontext.getAttribute("type"));
		
	
		driver.close();
	}

}
