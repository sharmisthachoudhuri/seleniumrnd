package org.seleniumrnd.scenarios.webtable;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable_OpenCart_Dynamic_Pagination {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.opencart.com/admin/index.php");
		
		driver.manage().window().maximize();
		
		//Login
		
		WebElement username=driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[text()=' Login']")).click();
		
		//Sales-->Orders
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		
		//Total Pages
		String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text); //Showing 1 to 20 of 8511 (426 Pages)
		
		int total_pages = Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
        System.out.println(total_pages);
		
		for(int p=1;p<=3;p++)
		 {
			WebElement active_Page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("active page:"+active_Page.getText());
			active_Page.click();
								
			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println(rows);
			
			//to read all the table data
				for(int r=1;r<=rows;r++)
				{
					String orderID=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
					String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
					String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[4]")).getText();
				
					if(status.equals("Pending")) // printing only pending orders
					{
					System.out.println(orderID+"  "+customerName+"  "+status);
					}
				}
			
			String pageno=Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();
			Thread.sleep(3000);
						
		}
		
	}

	}

