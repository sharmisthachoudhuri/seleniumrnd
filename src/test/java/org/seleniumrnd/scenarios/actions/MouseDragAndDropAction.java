package org.seleniumrnd.scenarios.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropAction {

	public static void main(String[] args) throws InterruptedException {

		//Chrome --> Working Well
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		WebElement italy=driver.findElement(By.id("box6"));
		WebElement rome=driver.findElement(By.id("box106"));
				
		act.dragAndDrop(italy, rome).perform(); //drag and drop
		Thread.sleep(3000);

		WebElement washington=driver.findElement(By.id("box3"));
		WebElement unitedstates=driver.findElement(By.id("box103"));
		
		act.dragAndDrop(washington, unitedstates).perform(); //drag and drop
		Thread.sleep(3000);
		
		driver.close();
	}

}




