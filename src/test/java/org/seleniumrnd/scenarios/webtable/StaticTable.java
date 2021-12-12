package org.seleniumrnd.scenarios.webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
######  Simple WebTable #########
1) How many rows in  table
2) How many columns in a table
3) Retrieve the specific row/column data
4) Retrieve all the data from the table
5) Print Release Date, VersionNo of Java Language of selenium
 * 
 */

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
	
		//	1) How many rows in  table
		int rows=driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println("Number of rows in  a table:"+rows); //5
	
		// 2) How many columns in a table	
		int cols=driver.findElements(By.xpath("//table[@class='data-list']//thead//th")).size();
		System.out.println("Number of columns in  a table:"+cols); //6
	
		//3) Retrieve the specific row/column data	
		String value=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[2]/td[1]")).getText();
		System.out.println(value); //Java
		
		//4) Retrieve all the data from the table
		
		/*for(int r=1;r<=rows;r++) //2 3 4.....7
		{
			for(int c=1;c<=cols;c++)  //1..4
			{
				String data=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(data+"     ");  
			}
			System.out.println();
		}*/
		
		//5) Print Release Date, VersionNo of Java Language of selenium
		
		for(int r=1;r<=rows;r++)
		{
			String language=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[1]")).getText();
			
			if(language.equals("Java"))
			{
				String releaseDate=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[5]")).getText();
				String version=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[4]")).getText();
				System.out.println(language+"   "+releaseDate+"    "+version);
			}
		}
		
		
		driver.quit();
	
	}

}

