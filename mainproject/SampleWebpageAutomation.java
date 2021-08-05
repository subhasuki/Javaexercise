package mainproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleWebpageAutomation {

	
	public static void main(String args[]) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",  "/home/zoho/Downloads/chromedriver");
//		System.setProperty("webdriver.gecko.driver","/home/zoho/Downloads/geckodriver");
		
		WebDriver driver = new ChromeDriver();							
		driver.manage().window().maximize();
		
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        
//--------------------------        Link : This is a link		-------------------------------------
      
        
        WebElement heading = driver.findElement(By.xpath("/html/body/div/div[4]/div/p/a")); 	
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        heading.click();
        driver.navigate().back();
        
//--------------------------       Text-box/input-box Module	-------------------------------------
        
        
        WebElement fname = driver.findElement(By.cssSelector("#fname"));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        fname.click();
        
        try {
	        fname.sendKeys("subha");
	        Thread.sleep(1000);
	        fname.clear();
	        System.out.println("Valid Name:Pass");
        }
        catch(Exception e){
        	System.out.println("Valid Name:Fail");
        }
        
        try {
	        fname.sendKeys("12345678");
	        Thread.sleep(1000);
	        fname.clear();
	        System.out.println("valid Number:Pass");
        }
        catch(Exception e) {
        	System.out.println("valid Number:Fail");
        }
        
        try {
	        fname.sendKeys("!@#$%^&*&*()");
	        Thread.sleep(1000);
	        fname.clear();
	        System.out.println("Invalid value(special char):Pass");
        }
        catch(Exception e){
        	System.out.println("Invalid value(special char):Fail");
        }
        
        try {
	        fname.sendKeys("subhaqwertyuiopasdfghjklzxcvbnm12345678901234567890!@#$%^&*()!@#$%^&*(12345678!@#$%^&*&*()");
	        Thread.sleep(1000);
	        fname.clear();
	        System.out.println("Accept max value:Fail");
        }
        catch(Exception e) {
        	System.out.println("Not accept max value:Pass");
        }
        
        
//--------------------------       Submit Button 	-------------------------------------
        
        
        try{
        	WebElement submitbtn = driver.findElement(By.cssSelector("#idOfButton"));
        	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        	submitbtn.click();
        	System.out.println("Submit Button Click:Pass");
        }
        catch(Exception e) {
        	System.out.println("Submit Button Click:Fail");
        }
        
//--------------------------       Male check-box	-------------------------------------
        
		try {
			WebElement male = driver.findElement(By.cssSelector("#male")); //System.out.println(male.getTagName());
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			male.click();  //male.clear();
			System.out.println("Checked Male:Pass");
		}
		catch(Exception e) {
			System.out.println("Unchecked Female:Fail");
		}
		
//--------------------------       Female check-box	-------------------------------------
		
		try {
			WebElement female = driver.findElement(By.cssSelector("#female")); //System.out.println(female);
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			female.click(); //female.clear();
			System.out.println("Checked Female:Pass");
		}
		catch(Exception e) {
			System.out.println("Unchecked Male:Fail");
		}
		
                
        driver.quit();
	}
	
}
