package org.seleniumrnd.scenarios.iframes;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames {

	public static void main(String[] args) {
	
		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("packageListFrame"); 	//switch to 1st frame
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		driver.switchTo().defaultContent(); // focus on page
		
		driver.switchTo().frame("packageFrame"); //switch to 2nd frame
		driver.findElement(By.linkText("WebDriver")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("classFrame"); //switch to 3rd frame
		driver.findElement(By.xpath("//a[text()='Index']")).click();

	}

}
