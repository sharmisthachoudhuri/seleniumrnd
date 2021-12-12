package org.seleniumrnd.nop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.seleniumrnd.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddCustomer extends BaseTest{

	@Test(priority = 1,description = "Add Customer Test")
	public  void testLogin() throws InterruptedException {
		driver.get("https://admin-demo.nopcommerce.com/");
		
		
		
		WebElement email= driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		// wait time added
	      //Thread.sleep(200);
	      
	      WebElement pwd= driver.findElement(By.id("Password"));
	      pwd.clear();
			pwd.sendKeys("admin");
			// wait time added
		      //Thread.sleep(2000);
		     
		      
		      WebElement btn= driver.findElement(By.xpath("//*[@type=\"submit\"] "));
		      //WebElement btn= driver.findElement(By.className("button-1 login-button"));
				btn.click();     
				//Thread.sleep(2000);
/*
		WebElement textbox= driver.findElement(By.id(textboxid));
		textbox.sendKeys= ("");
		
		WebElement btn= driver.findElement(By.id(btn id));
		btn.click();*/

	  WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	  Assert.assertEquals(true, logoutLink.isDisplayed());
	  
	  WebElement customer1= driver.findElement(By.xpath("(//p[contains(text(),'Customers')])[1]"));
	  customer1.click();
		
	  WebElement customer2= driver.findElement(By.xpath("(//p[contains(text(),'Customers')])[2]"));
	  customer2.click();
	  
	  WebElement AddCustomer= driver.findElement(By.xpath("//a[@href='/Admin/Customer/Create']"));
	 AddCustomer.click();
		
	}
	

}
