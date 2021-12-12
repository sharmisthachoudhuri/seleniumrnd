package org.seleniumrnd.scenarios.links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws IOException {

		// Instantiating Driver
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.deadlinkcity.com/");
			
			
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		
		int brokenlinks=0;

		for (WebElement element: links) {
						
				String url = element.getAttribute("href");	// By using "href" attribute, we could get the url of the requried link
				if(url == null || url.isEmpty())
				{
					System.out.println("URL is empty");
					continue;
				}
				URL link= new URL(url);
				
				try
				{
					HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();	// Create a connection using URL object (i.e., link)
					httpConn.connect(); // connect using connect method
									
					if (httpConn.getResponseCode() >= 400) 
						{
						System.out.println(httpConn.getResponseCode()+":"+url + " -> " + "is Broken Link");
						brokenlinks++;
						}
					else 
					{
						System.out.println(httpConn.getResponseCode()+":"+url + " -> " + "Valid Link");
					}
				}
				catch(Exception e)
				{
				}
			}
		System.out.println("Number of broken links:"+brokenlinks);
		driver.quit();
}

}