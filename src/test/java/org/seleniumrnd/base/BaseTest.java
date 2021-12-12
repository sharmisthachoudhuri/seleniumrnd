package org.seleniumrnd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumrnd.testnglisteners.FrameworkTestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Listeners;


@Listeners(FrameworkTestListener.class)
public class BaseTest {
	
	public WebDriver driver=null;
	
	@BeforeTest
	public void begin() {
		
		WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();
		driver= new ChromeDriver();
		
	}
	
	
	@AfterTest
	public void end() {
		
		driver.close();
		driver.quit();
	}
}