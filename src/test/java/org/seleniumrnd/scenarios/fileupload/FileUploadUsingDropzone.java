package org.seleniumrnd.scenarios.fileupload;

import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingDropzone {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
		
		// locate the drop area
		WebElement droparea = driver.findElement(By.xpath("//input[@id='file-upload']"));

		// drop the file
		DropFile(new File("C:\\SeleniumPractice\\sample.pdf"), droparea, 0, 0);
			
	}

	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) 
	{
		 WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
		   
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	  
	    String JS_DROP_FILE =
	        "var target = arguments[0]," +
	        "    offsetX = arguments[1]," +
	        "    offsetY = arguments[2]," +
	        "    document = target.ownerDocument || document," +
	        "    window = document.defaultView || window;" +
	        "" +
	        "var input = document.createElement('INPUT');" +
	        "input.type = 'file';" +
	        "input.style.display = 'none';" +
	        "input.onchange = function () {" +
	        "  var rect = target.getBoundingClientRect()," +
	        "      x = rect.left + (offsetX || (rect.width >> 1))," +
	        "      y = rect.top + (offsetY || (rect.height >> 1))," +
	        "      dataTransfer = { files: this.files };" +
	        "" +
	        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
	        "    var evt = document.createEvent('MouseEvent');" +
	        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
	        "    evt.dataTransfer = dataTransfer;" +
	        "    target.dispatchEvent(evt);" +
	        "  });" +
	        "" +
	        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
	        "};" +
	        "document.body.appendChild(input);" +
	        "return input;";

	    WebElement input =  (WebElement)js.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
	    input.sendKeys(filePath.getAbsoluteFile().toString());
	
	}
}
