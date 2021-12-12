package org.seleniumrnd.scenarios.datepicker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSSLCertificateError {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		//Direct
		DesiredCapabilities cap=new DesiredCapabilities();	
		//cap.setAcceptInsecureCerts(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
		
		ChromeOptions options=new ChromeOptions();
		options.merge(cap);
		//options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
		WebDriver driver=new ChromeDriver();
		driver.get("https://expired.badssl.com/");
		
		
		/*String browser="chrome";
		DesiredCapabilities cap=new DesiredCapabilities();	
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			//cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			cap.setAcceptInsecureCerts(true);
			
			ChromeOptions options=new ChromeOptions();
			options.merge(cap);
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
			
			driver.get("https://self-signed.badssl.com/");
			
			System.out.println(driver.getTitle());
		}
		else if(browser.equals("firefox"))
		{
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			FirefoxOptions options=new FirefoxOptions();
			options.merge(cap);
		
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(options);
		}
		else if(browser.equals("edge"))
		{
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			EdgeOptions options=new EdgeOptions();
			options.merge(cap);
		
			WebDriverManager.firefoxdriver().setup();
			driver=new EdgeDriver(options);
		}
	
		*/

	}

}
