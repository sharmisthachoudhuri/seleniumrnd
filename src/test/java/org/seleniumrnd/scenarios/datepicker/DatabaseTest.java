package org.seleniumrnd.scenarios.datepicker;

import java.sql.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class DatabaseTest {

	public static void main(String args[]) throws SQLException {
		// Data
		String cust_firstname = "John";
		String cust_lastName = "Kenedy";
		String cust_email = "john@gmail.com";
		String cust_telPhone = "1234567890";
		String cust_password = "john123";

		// User Registration through FrontEnd"
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.name("firstname")).sendKeys(cust_firstname);
		driver.findElement(By.name("lastname")).sendKeys(cust_lastName);
		driver.findElement(By.name("email")).sendKeys(cust_email);
		driver.findElement(By.name("telephone")).sendKeys(cust_telPhone);
		driver.findElement(By.name("password")).sendKeys(cust_password);
		driver.findElement(By.name("confirm")).sendKeys(cust_password);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Verify Confirmation Message
		try {
			String confmsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
			if(confmsg.equals("Your Account Has Been Created!"))
				System.out.println("Registration successfull");
			else
				System.out.println("Registration Not successfull");
		} 
		catch (Exception e) 
		{
			System.out.println("Some Problem in the UI");
		}

		// Database validation
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop", "root", "");
		Statement stmt = con.createStatement();
		String query = "select firstname,lastname,email,telephone from oc_customer";
		ResultSet rs = stmt.executeQuery(query);

		boolean status=false;
		
		while (rs.next()) {
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");
			String telephone = rs.getString("telephone");
			
			if(cust_firstname.equals(firstname) && cust_lastName.equals(lastname) 
					&& cust_email.equals(email)	&& cust_telPhone.equals(telephone)) 
					{
					System.out.println("Record Found in the table  || Test Passed");
					status=true;
					break;
			}
				
		} //end of while
		
		if(status==false)
		{
			System.out.println("Record Not Found in the table || Test Failed");
		}

	}
}
