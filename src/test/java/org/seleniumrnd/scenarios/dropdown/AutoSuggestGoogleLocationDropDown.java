package org.seleniumrnd.scenarios.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestGoogleLocationDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
				
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		WebElement searchbox=driver.findElement(By.id("autocomplete"));
		
		searchbox.clear();
		searchbox.sendKeys("Toronto");
	
		String text;
		do
		{			
				searchbox.sendKeys(Keys.ARROW_DOWN);
				text=searchbox.getAttribute("value");
				System.out.println(text);
				
				if(text.equals("Toronto, OH, USA"))
				{
					searchbox.sendKeys(Keys.ENTER);
					break;
				}
				Thread.sleep(2000);
			
		}while(!text.isEmpty());
		
		
	}

}
