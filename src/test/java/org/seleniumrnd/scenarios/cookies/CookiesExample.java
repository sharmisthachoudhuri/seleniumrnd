package org.seleniumrnd.scenarios.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesExample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//How To capture cookies from browser?
				
		Set <Cookie> cookies=driver.manage().getCookies(); 
		System.out.println("Size of cookies ---->" +cookies.size()); 
		
		
		// How To print cookies from browser?
		for(Cookie cookie:cookies) 
		{
			System.out.println(cookie.getName()+":"+cookie.getValue()); 
		}
		
		
		//How To add Cookie to the browser?
		
		Cookie cookieobj=new Cookie("MyCookie123","123456789");
		driver.manage().addCookie(cookieobj);  
		
		cookies=driver.manage().getCookies(); 
		System.out.println("Size of Cookies after adding new one---->" +cookies.size()); 
		
				
		// How To delete specific Cookie from the browser?
		driver.manage().deleteCookie(cookieobj); //	driver.manage().deleteCookieNamed("MyCookie123");
		
		cookies=driver.manage().getCookies(); 
		System.out.println("Size of Cookies after deleting one cookie---->" +cookies.size()); 
		
		//How To delete all Cookies from the browser?
		driver.manage().deleteAllCookies(); 
		
		cookies=driver.manage().getCookies(); 
		System.out.println("Size of Cookies after deleting All cookies---->" +cookies.size());  // 0
				
		
		driver.quit();
		
	}


}
