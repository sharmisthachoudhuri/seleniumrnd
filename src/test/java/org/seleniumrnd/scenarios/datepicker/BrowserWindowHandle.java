package org.seleniumrnd.scenarios.datepicker;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent window
		
		String windowID=driver.getWindowHandle(); // Returns ID of single browser window
			
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windwIDs = driver.getWindowHandles(); // Returns ID's of Multiple browser windows
		
		//First method - Iterator
			
			/*Iterator<String> it = windwIDs.iterator();
			
			String parentWidnowId = it.next();
			System.out.println("parent window id is : " + parentWidnowId); // Getting Parent window ID
			
			String childWindowId = it.next();
			System.out.println("child window id is : " + childWindowId); // Getting Child window ID
			
			
		//Second method - Using List
		 
			List<String> windowIDsList = new ArrayList(windwIDs);
			
			String parentWindowId = windowIDsList.get(0);
			String childWindowId = windowIDsList.get(1);
			
			System.out.println(parentWindowId);
			System.out.println(childWindowId);
			
			
		//How to use window ID's -  Switching	& getting title
			
			driver.switchTo().window(childWindowId); 
			System.out.println("child window title is : " + driver.getTitle());
					
			driver.switchTo().window(parentWidnowId);//switching
			System.out.println("parent window title is : " + driver.getTitle());*/
				


		//3) By using single for each loop	-Switching	& getting title
					
			/*for(String handle:windwIDs)  // Prints Window ID'S, Switching, printing page titles
			{
				System.out.println(handle);
				driver.switchTo().window(handle).getTitle();
			}*/
			
		//4) Close Specific Browser Window
		
			/*for(String handle:windwIDs)  // Prints Window ID'S, Switching, printing page titles
				{
					String title=driver.switchTo().window(handle).getTitle();
					if(title.equals("OrangeHRM"))
						driver.close();
				}*/
				
				
		//driver.quit();
		
	}

}
