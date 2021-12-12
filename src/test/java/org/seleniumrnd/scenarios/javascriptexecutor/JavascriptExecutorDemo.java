package org.seleniumrnd.scenarios.javascriptexecutor;

// *** Need JavaScriptUtil.java to run this test script

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws IOException {

		//Chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// Syntax
		// -------------
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript(script, args);

		// flash
		// ---------------------
		WebElement searchBtn = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.flash(searchBtn,driver);

		// Drawing border & take screenshot
		// ------------------
		JavaScriptUtil.drawBorder(searchBtn, driver);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\screenshots\\logo.png"));

		// Getting title of the page
		// ---------------------------
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);

		// Clicking on element
		// --------------------------
		// WebElement
		 WebElement loginlnk=driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
		 JavaScriptUtil.clickElementByJS(loginlnk,driver);

		// Generate alert
		// --------------
		 //JavaScriptUtil.generateAlert(driver, "Clicked on Login Link");

		// Refreshing page
		// ----------------
		JavaScriptUtil.refreshBrowserByJS(driver);

		// Scrolling down page
		JavaScriptUtil.scrollPageDown(driver);

		// Scroll up page
		JavaScriptUtil.scrollPageUp(driver);
		
		// Zoom page
		JavaScriptUtil.zoomPageByJS(driver);

	}

}
