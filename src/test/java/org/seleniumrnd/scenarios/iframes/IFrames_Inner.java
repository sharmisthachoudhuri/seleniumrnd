package org.seleniumrnd.scenarios.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames_Inner {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
         
          driver.switchTo().frame("iframeResult");
          driver.switchTo().frame(0);
         
         System.out.println(driver.findElement(By.xpath("//h1")).getText());
         
          driver.switchTo().parentFrame();
         
         System.out.println(driver.findElement(By.xpath("//p")).getText());
         
          driver.close();
		
	}

}
