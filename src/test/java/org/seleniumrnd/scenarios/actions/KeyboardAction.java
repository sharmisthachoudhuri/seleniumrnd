package org.seleniumrnd.scenarios.actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class KeyboardAction {

	public static void main(String args[]){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ESCAPE).perform();
		action.sendKeys(Keys.TAB).perform();
		
		
	}

}