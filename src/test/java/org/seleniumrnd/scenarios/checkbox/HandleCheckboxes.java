package org.seleniumrnd.scenarios.checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		// 1) Select specific check box
		// driver.findElement(By.xpath("//input[@id='monday']")).click();

		// 2) select all the check boxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println(checkboxes.size());

		// using for loop
		/*for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
			System.out.println("clicked on:" + i);
		}*/

		// using for..each loop
		/*for (WebElement chbox : checkboxes) {
			chbox.click();
		}*/

		// 3) select multiple check boxes by choice
		
		 /* for(WebElement chbox:checkboxes) 
		  {
			  String  checkboxname=chbox.getAttribute("id");
			  System.out.println(checkboxname);
		   	  if(checkboxname.equals("monday") || checkboxname.equals("sunday") ) 
		   	  {
		        chbox.click(); 
		        } 
		  }*/
		 

		// 4) Select Last 2 check boxes

				 
		 /* System.out.println("Total checkboxes found: " + checkboxes.size()); //7
		  
		  // Starting index will be count of elements-2. i.e. 
		  //if there are 7 check  boxes, you need to go (7-2)=5th index 
		  for (int i = checkboxes.size() - 2; i < checkboxes.size(); i++) 
		  { 
			  checkboxes.get(i).click(); 
		 }*/
		 
		//  5) Select First 2 check boxes
		 
		/*for(int i = 0; i< checkboxes.size(); i++)
		{
			if(i<2)
			{
			checkboxes.get(i).click();
			}
		}*/
		
	}

}
