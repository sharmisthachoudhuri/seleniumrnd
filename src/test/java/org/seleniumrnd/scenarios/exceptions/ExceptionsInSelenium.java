package org.seleniumrnd.scenarios.exceptions;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionsInSelenium {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("https://demo.nopcommerce.com/login");
				
		//NoSuchElementException - Webdriver is not able to determine the elements during runtime
		/*try
		{
		WebElement usernametxt=driver.findElement(By.name("email"));
		usernametxt.sendKeys("abc@gmail.com");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element is Not Available...");
		}*/

		
		
		//StaleElementReferenceException -The referenced element is no longer present on the DOM page 
		/*WebElement userEmail=driver.findElement(By.name("Email"));
		userEmail.sendKeys("abc@gmail.com");
		
		WebElement password=driver.findElement(By.name("Password"));
		password.sendKeys("xyz");
		
		driver.navigate().refresh();
		
		try
		{
		userEmail.sendKeys("abc@gmail.com");
		}
		catch(StaleElementReferenceException e)
		{
			userEmail=driver.findElement(By.name("Email"));
			userEmail.sendKeys("abc@gmail.com");
			
		}*/
	
		
		//ElementNotInteractableException
			//Element present in the DOM & type ="hidden"
			//cannot be interactive
			
	    WebElement chbox_rememberMe=driver.findElement(By.xpath("//input[@value='false']"));
        try
        {
	    chbox_rememberMe.click();
        }
        catch(ElementNotInteractableException e)
        {
        	JavascriptExecutor js = (JavascriptExecutor) driver; 
        	js.executeScript("arguments[0].click();", chbox_rememberMe);
        }
        
        
        
	}

}
