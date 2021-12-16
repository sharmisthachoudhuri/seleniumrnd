package org.seleniumrnd.nop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.seleniumrnd.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.InvokeMethodRunnable.TestNGRuntimeException;

public class TestSearchAndDeleteCustomer extends BaseTest{

	@Test(priority = 1,description = "Search Customer Test")
	public  void testSearchAndDelete() throws InterruptedException {
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
	  
	  WebElement emailSearch= driver.findElement(By.xpath("//input[@id='SearchEmail']"));
	  emailSearch.sendKeys("S12345.dutta12345@gmail.com");
	 
	 
	  WebElement Searchbtn= driver.findElement(By.xpath("//button[@id='search-customers']"));
	  Searchbtn.click();
	 
	  WebElement Editbtn= driver.findElement(By.xpath("//a[@class='btn btn-default']"));
	  Editbtn.click();
	
	  WebElement Delbtn= driver.findElement(By.xpath("//i[@class='far fa-trash-alt']"));
	  Delbtn.click();
	  
	  WebElement DelAlert= driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
	  DelAlert.click();
	  
	  WebElement msg= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"));
		 //  //div[@class='alert alert-success alert-dismissable']
	//div[@class='alert alert-success alert-dismissable']
	  
		 String divInnerHTML= msg.getAttribute("innerHTML");
		 boolean successMsdPresent =divInnerHTML.contains("The customer has been deleted successfully.");
		 
		 //System.out.println(divInnerHTML);
		 Assert.assertEquals(successMsdPresent, true);
	  
	  ////button[normalize-space()='Delete']
	
	}
	

}
