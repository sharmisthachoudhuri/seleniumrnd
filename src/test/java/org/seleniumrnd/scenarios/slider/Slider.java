package org.seleniumrnd.scenarios.slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		
		WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
	
		System.out.println(min_slider.getLocation());   //(x,y) ==(59, 251)
		System.out.println(max_slider.getLocation());   //(x,y) ==(544, 251)
		
		Actions act=new Actions(driver);
		
		act.dragAndDropBy(min_slider, 100, 0).build().perform();
		act.dragAndDropBy(max_slider, -44, 0).build().perform();

		
	}

}
