package org.seleniumrnd.nop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumrnd.base.BaseTest;
import org.seleniumrnd.testnglisteners.FrameworkTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGLogin extends BaseTest{

	@Test(priority = 1,description = "Login Test")
	public  void testLogin() throws InterruptedException {
		driver.get("https://admin-demo.nopcommerce.com/");
		
		
		
		WebElement email= driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");

	      
	      WebElement pwd= driver.findElement(By.id("Password"));
	      pwd.clear();
			pwd.sendKeys("admin");

		      
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
	  
				
		

	}
	@Test(priority = 2, description = "Logout Test")
	public  void testLogout() {
		 WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		  logoutLink.click();
	}

}
