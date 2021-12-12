package org.seleniumrnd.scenarios.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionMultipleKeys {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
		
		driver.get("https://text-compare.com/");
		
		WebElement input1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement input2=driver.findElement(By.xpath("//textarea[@id='inputText2']"));	
				
		input1.sendKeys("welcome to selenium");
		
		Actions act=new Actions(driver);
		
		 // Select the input1 using CTRL + A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
        
        // Copy the input1 using CTRL + C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
        
        //Press the TAB Key to Switch Focus to input2
		act.sendKeys(Keys.TAB);
		act.perform();
        
        //Paste the text in the input2 using CTRL + V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
        
        //Compare Text of input1 and input2
        if(input1.getAttribute("value").equals(input2.getAttribute("value")))
        	System.out.println("Text copied...");
        else
        	System.out.println("Not copied...");
		
		
		
	}

}
