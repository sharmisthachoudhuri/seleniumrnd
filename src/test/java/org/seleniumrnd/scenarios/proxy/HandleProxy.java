package org.seleniumrnd.scenarios.proxy;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleProxy {

	public static void main(String[] args) {
		
		
		Proxy p = new Proxy();
		p.setHttpProxy("182.71.205.158:80");
		
		ChromeOptions options=new ChromeOptions();
		options.setProxy(p);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://demo.nopcommerce.com/");
		System.out.println(driver.getCurrentUrl());
		
	}

}
