package org.seleniumrnd.scenarios.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseHoverAction {

	public static void main(String args[])throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		driver.get("https://demo.opencart.com/");
		
		WebElement desktopsMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement macMenuItem=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		// Mouse Hover action
		Actions act = new Actions(driver);
		act.moveToElement(desktopsMenu).moveToElement(macMenuItem).click().perform();   
		
	}
}
