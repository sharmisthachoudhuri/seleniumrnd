package org.seleniumrnd.scenarios.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopupOrAlert {

	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.get("http://the-internet.herokuapp.com/basic_auth"); //Popup will appear
		

		// Approach1
		// Syntax: http://username:password@test.com
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		// Approach2
		String username="admin";
		String password="admin";
		driver.get("http://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		//validation
		String text = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text);
	}

}
