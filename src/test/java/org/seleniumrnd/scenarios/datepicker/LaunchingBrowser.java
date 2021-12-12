package org.seleniumrnd.scenarios.datepicker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {

	public static void main(String[] args) {

		//**************    Approach1 ****************
		// chrome
		// System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		// WebDriver driver=new ChromeDriver(); //ChromeDriver driver=new
		// ChromeDriver();

		// firefox
		// System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		// WebDriver driver=new FirefoxDriver();

		// Edge
		//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win32\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver(); // EdgeDriver driver=new EdgeDriver();

		//**************    Approach2 ****************
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");  //Open URL
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
		
		
	}

}
