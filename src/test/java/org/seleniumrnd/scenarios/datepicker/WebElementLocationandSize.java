package org.seleniumrnd.scenarios.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebElementLocationandSize {

	public static void main(String[] args) throws InterruptedException {
		//Chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();	
		
		    
	  //*********** Getting Object Location and Size  : Selenium4 feature **************
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	   
	    WebElement logo= driver.findElement(By.xpath("//div[@id='divLogo']//img"));
	    
	    //****** Location ************
	    //Location - Method1
	    System.out.println("Location(x,y):"+logo.getLocation());
	    System.out.println("Location(x):"+logo.getLocation().getX());
	    System.out.println("Location(y):"+logo.getLocation().getY());
	    	    
	    //Location - Method2
	    System.out.println("Location(x) is "+logo.getRect().getX());
	    System.out.println("Location (y)is "+logo.getRect().getY());
	    
	    //********** Size ***************
	    //Size - Method 1
	    System.out.println("Size(width,Height):"+logo.getSize());
	    System.out.println("Size(width):"+logo.getSize().getWidth());
	    System.out.println("Size(Height):"+logo.getSize().getHeight());
	    	    
	    //Size- Method 2
	    System.out.println("Size(width,Height):"+logo.getRect().getDimension());
	    System.out.println("Size(width):"+logo.getRect().getDimension().getWidth());
	    System.out.println("Size(Height):"+logo.getRect().getDimension().getHeight());
	    	    
	    driver.quit();

	}
}
