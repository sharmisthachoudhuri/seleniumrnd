package org.seleniumrnd.nop;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.seleniumrnd.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.InvokeMethodRunnable.TestNGRuntimeException;

public class TestAddCustomer extends BaseTest{

	@Test(priority = 1,description = "Add Customer Test")
	public  void testAddCustomer() throws InterruptedException {
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

		WebElement addCustomer= driver.findElement(By.xpath("//a[@href='/Admin/Customer/Create']"));
		addCustomer.click();

		WebElement email1= driver.findElement(By.xpath("//input[@id='Email']"));
		email1.sendKeys("S12345.dutta12345@gmail.com");

		WebElement pwd1= driver.findElement(By.xpath("//input[@id='Password']"));
		pwd1.sendKeys("abcd");

		WebElement fname= driver.findElement(By.xpath("//input[@id='FirstName']"));
		fname.sendKeys("sharmistha");

		WebElement lname= driver.findElement(By.xpath("//input[@id='LastName']"));
		lname.sendKeys("dutta");

		WebElement gender= driver.findElement(By.xpath("//input[@id='Gender_Female']"));
		gender.click();

		WebElement date= driver.findElement(By.xpath("//input[@id='DateOfBirth']"));
		date.sendKeys("12/12/2021");

		WebElement company= driver.findElement(By.xpath("//input[@id='Company']"));
		company.clear();
		company.sendKeys("xyz");

		// WebElement teste= driver.findElement(By.xpath("//input[@id='customer_attribute_1']"));
		//teste.sendKeys("xyz");

		WebElement tax= driver.findElement(By.xpath("//input[@id='IsTaxExempt']"));
		tax.click();

		// Select newsletter= new Select (driver.findElement(By.xpath("//input[@class='k-input k-readonly']")));
		// newsletter.selectByIndex(1);

		WebElement newsLetter = driver.findElement(By.xpath("//div[@class='input-group-append']//div[@role='listbox']"));
		newsLetter.click();
		WebElement newsletter= driver.findElement(By.xpath("//li[normalize-space()='Your store name']"));
		newsletter.click();

		Select vendor= new Select (driver.findElement(By.xpath("//select[@id='VendorId']")));
		vendor.selectByIndex(1);
		System.out.println("Test Ended");

		WebElement comment= driver.findElement(By.xpath("//textarea[@id='AdminComment']"));
		comment.sendKeys("Test");

		WebElement btn2= driver.findElement(By.xpath("//button[@name='save']"));
		btn2.click();

		WebElement msg= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"));
		//  //div[@class='alert alert-success alert-dismissable']
		String divInnerHTML= msg.getAttribute("innerHTML");
		boolean successMsdPresent =divInnerHTML.contains("The new customer has been added successfully.");

		//System.out.println(divInnerHTML);
		Assert.assertEquals(successMsdPresent, true);

		//input[@id='IsTaxExempt']
		////input[@id='Gender_Male']
		////input[@id='Gender_Female']
		//input[@id='DateOfBirth']
		//input[@id='Company']

		////li[normalize-space()='Your store name']
		////li[normalize-space()='Test store 2']

		//div[@class='alert alert-success alert-dismissable']
	}


}
