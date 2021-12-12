package org.seleniumrnd.scenarios.capturescreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Screenshot of Full Page 
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\HomePage.png"); 
		FileUtils.copyFile(src,trg);
		
		//Screenshot of Section of the Page 
		/*WebElement pageSection=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src=pageSection.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\FeatureProducts.png");
		FileUtils.copyFile(src,trg);
		
		
		//Screenshot of the Element
		WebElement logoElement=driver.findElement(By.xpath("//div[@class='header-logo']//a//img"));
		File src=logoElement.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\Logo.png");
		FileUtils.copyFile(src,trg);*/
		
	}

}
