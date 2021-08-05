package mainproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Gurudropdown {
	
	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",  "/home/zoho/Downloads/chromedriver");
//		System.setProperty("webdriver.gecko.driver","/home/zoho/Downloads/geckodriver");
		
		WebDriver driver = new ChromeDriver();				
//		         driver= new ChromeDriver();					
         driver.get("http://demo.guru99.com/test/drag_drop.html");	
		//Element which needs to drag.    		
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
        Thread.sleep(5000);
         //Element on which need to drop.		
         WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
         		
         Thread.sleep(10000);
         //Using Action class for drag and drop.		
         Actions act=new Actions(driver);					

	//Dragged and dropped.		
         act.dragAndDrop(From, To).build().perform();		
	}
}