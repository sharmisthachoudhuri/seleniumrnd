package org.seleniumrnd.scenarios.links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
							
		//1) click on the link  click()
		
		driver.findElement(By.linkText("Today's Deals")).click(); 
		driver.findElement(By.partialLinkText("Deals")).click(); 
				
		
		//2) Find Number of links
			List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println(links.size());  //338
				
		//2) Capture all the links 
			/*for(WebElement l:links)
				{
					System.out.println(l.getText()+"===>"+" "+l.getAttribute("href"));
					
				}
				
				/*for(int i=0;i<links.size();i++)
				{
					WebElement link=links.get(i);
					System.out.println(link.getText()+"  "+link.getAttribute("href"));
				}*/
				
		//Total images on web page
				
				/*List<WebElement> images=driver.findElements(By.tagName("img"));
				System.out.println(images.size());*/
				driver.close();
	}

}
