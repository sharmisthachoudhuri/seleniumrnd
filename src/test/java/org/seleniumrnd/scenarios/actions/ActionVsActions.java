package org.seleniumrnd.scenarios.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.seleniumrnd.base.BaseTest;
import org.testng.annotations.Test;


public class ActionVsActions extends BaseTest {

	@Test
	public void testActions()throws InterruptedException {

		// Navigate to site
		driver.get("http://automationpractice.com/index.php");
		WebElement features = driver.findElement(By.xpath("//a[@title='Women']"));

		//Actions is a class
		//Actions act = new Actions(driver);
		//act.moveToElement(features).perform();   // perform() includes build().perform()
		
		//Action is an Interface
		Actions act = new Actions(driver);
		Action action= act.moveToElement(features).build(); // build() returns an action
		action.perform();
		
		Thread.sleep(2000);
		
		
	}
}
