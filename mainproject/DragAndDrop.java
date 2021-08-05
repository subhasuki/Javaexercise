package mainproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
public static void main(String args[]) throws Exception {
		
//		-------------------- 	Connect  WebDriver  ---------------------------
		System.setProperty("webdriver.chrome.driver","/home/zoho/Downloads/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("start-maximized");
		WebDriver driver= new ChromeDriver();	
		driver.manage().window().maximize();

		
	     	
			String rose = "https://the-internet.herokuapp.com/drag_and_drop";
			driver.get(rose);
		
//		--------------------	Alert Cookies Check   -------------------------------------
			
//			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//			WebElement draganddrop = driver.findElement(By.xpath("//a[text()='Drag and Drop']"));
//			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//
//			draganddrop.click();
//			Thread.sleep(3000);
			
			WebElement dropfrom = driver.findElement(By.cssSelector("#column-a"));
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			Thread.sleep(2000);
			WebElement dropto = driver.findElement(By.cssSelector("#column-b"));
//			System.out.println(dropto.getTagName());
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			Actions action = new Actions(driver);
							

			try {
				 Thread.sleep(2000);	
				 action.clickAndHold(dropfrom).moveToElement(dropto).perform();
	//			 String javaScript = "";
	//			 javaScript = javaScript + "$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});";
	//			 ((JavascriptExecutor)driver).executeScript(javaScript);			 

			} catch(Exception e) {
        		System.out.println("fail"+ e);
				driver.quit();
			}

}
}
