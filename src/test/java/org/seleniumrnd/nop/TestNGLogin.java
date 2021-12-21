package org.seleniumrnd.nop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.seleniumrnd.base.BaseTest;
import org.seleniumrnd.util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Map;


public class TestNGLogin extends BaseTest{

	@Test(priority = 1,description = "Login Test",dataProvider = "Map Data Test")
	//public  void testLogin() throws InterruptedException {
	public  void testLogin(Map<String,String> paramMap) throws InterruptedException {
		System.out.println("paramMap:"+paramMap);
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
	@Ignore
	@Test(priority = 2, description = "Logout Test")
	public  void testLogout() {
		 WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(),'Logout123')]"));
		  logoutLink.click();
	}

	@DataProvider(name = "Map Data Test")
	public Object[][] readMapDataFromExcel() throws Exception {
		String filePath ="C://All_Projects//test_data.xlsx";
		//System.out.println(getExcelDataArray(filePath,"login"));
		Map<String, String> dataMap =ExcelUtil.getExcelDataMap(filePath,"login");
		Object[][] objData = new Object[1][1];
		objData[0][0]= dataMap;
		return objData;
	}

}
