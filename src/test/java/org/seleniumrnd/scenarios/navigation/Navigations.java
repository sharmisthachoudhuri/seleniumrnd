package org.seleniumrnd.scenarios.navigation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com");
		driver.get("http://www.amazon.com");
		
		//driver.navigate().to("http://www.amazon.com");

		driver.navigate().back();
		driver.navigate().forward();
	
		driver.navigate().refresh();

		driver.quit();

	}

}
