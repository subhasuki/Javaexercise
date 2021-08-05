package mainproject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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
    	
//-------------------------    	Click-able or not  --------------------------------------
    	
    	String Actual_URl_1 = "https://www.javatpoint.com/";
		String Expexted_URL_1 = driver.getCurrentUrl();
    	
		try {
			Assert.assertEquals(Actual_URl_1,Expexted_URL_1);
			System.out.println("This link URL Clickable:--Pass-- \n");
			}
		catch(Exception e) {
			System.out.println("This link URL notclickable:--Fail-- \n");
		}
		
		
		
//-------------------------    	URL check  --------------------------------------
		String Actual_URl = "https://www.javatpoint.com/";
		String Expexted_URL = driver.getCurrentUrl();
		
        try{
        	Assert.assertEquals(Actual_URl,Expexted_URL);
        	System.out.println("Current URL:--Pass-- \n");
        }
        catch(Exception e){
        	System.out.println("Current URL:--Fail-- \n");
        }
        
//-------------------------    	URL type  --------------------------------------
        
        String Actual_URl_type = "a";
		String Expexted_URL_type = heading.getTagName();

		
        try{
        	Assert.assertEquals(Actual_URl_type,Expexted_URL_type);
        	System.out.println("It's a link tag:--Pass-- \n");
        }
        catch(Exception e){
        	System.out.println("It's a not link tag:--Fail-- \n");
        }
        driver.navigate().back();
        
//--------------------------       Text-box/input-box Module	-------------------------------------
        
        
        WebElement fname = driver.findElement(By.cssSelector("#fname"));     
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
                
//-------------------------------        valid value 	------------------------------------------------
		
		fname.click();
        fname.clear();
        fname.sendKeys("subha");  // Thread.sleep(1000);
        String Actual_valid_ip = "subha";
		String Expexted_valid_ip = fname.getAttribute("value");		//System.out.println(Expexted_valid_ip);
        
        try {
        	Assert.assertEquals(Actual_valid_ip,Expexted_valid_ip);
	        System.out.println("Valid Name:--Pass-- \n");
        }
        catch(Exception e){
        	System.out.println("Valid Name:--Fail-- \n");
        }
        
//-------------------------------        Number value 	------------------------------------------------  
        
        fname.click();
        fname.clear();
        fname.sendKeys("1234567890");        
        String Actual_ip_number = "1234567890";
		String Expexted_ip_number = fname.getAttribute("value");	
		
        try {
        	Assert.assertEquals(Actual_ip_number,Expexted_ip_number);
	        System.out.println("valid Number:--Pass-- \n");
        }
        catch(Exception e) {
        	System.out.println("valid Number:--Fail-- \n");
        }
        
//-------------------------------        Special char value 	------------------------------------------------
        
        fname.click();
        fname.clear();
        fname.sendKeys("!@#$%^&*&*()");        
        String Actual_ip_special_char = "!@#$%^&*&*()";
		String Expexted_ip_special_char = fname.getAttribute("value");	
        
        try {
        	Assert.assertEquals(Actual_ip_special_char,Expexted_ip_special_char);
	        System.out.println("special characters accpeted:--Fail-- \n");
        }
        catch(Exception e){
        	System.out.println("Not accept special characters:--Pass-- \n");
        }
        
//-------------------------------        Multiple value and max value	------------------------------------------------
        
        fname.click();
        fname.clear();
        fname.sendKeys("subhaqwertyuiopasdfghjklzxcvbnm12345678901234567890!@#$%^&*()!@#$%^&*(12345678!@#$%^&*&*()");        
        String Actual_ip_max_value = "subhaqwertyuiopasdfghjklzxcvbnm12345678901234567890!@#$%^&*()!@#$%^&*(12345678!@#$%^&*&*()";
		String Expexted_ip_max_value = fname.getAttribute("value");	
		
        try {
        	Assert.assertEquals(Actual_ip_max_value,Expexted_ip_max_value);
	        System.out.println("Accept max value:--Fail-- \n");
        }
        catch(Exception e) {
        	System.out.println("Not accept max value:--Pass-- \n");
        }
        
//-------------------------------       Check Enable/Disable  	------------------------------------------------
        
        fname.click();
        fname.clear();
        String Actual_disable = "true";       
        
        boolean ip_disable = driver.findElement(By.xpath("/html/body/div/div[4]/div/p/a")).isEnabled(); // System.out.println(ip_disable);
        String Expexted_disable = String.valueOf(ip_disable);  // System.out.println(Expexted_disable);
        
        try {
        	Assert.assertEquals(Actual_disable,Expexted_disable);
	        System.out.println("Input field is Enabled:--Pass-- \n");
        }
        catch(Exception e) {
        	System.out.println("Input field is Disableds:--Fail-- \n");
        }
        
        
//--------------------------       Submit Button 	-------------------------------------
        
        WebElement submit_btn = driver.findElement(By.cssSelector("#idOfButton"));
    	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    	
       	submit_btn.click();
       	String Actual_sbtn_1 = "background: green;";
		String Expexted_sbtn_1 = submit_btn.getAttribute("style"); 
    	
    	  try {
    		Assert.assertEquals(Actual_sbtn_1,Expexted_sbtn_1);
  			System.out.println("Submit button clickable:--Pass--  \n");
          }
          catch(Exception e) {
          	System.out.println("Submit button not clickable:--Fail--  \n");
          }
    	
//--------------------------    	Check button filed   -------------------------------- 
    	
    	submit_btn.click();
    	String Actual_btn = "button";
    	String Expexted_btn = submit_btn.getAttribute("type");
    	
    	
        try {
        	Assert.assertEquals(Actual_btn,Expexted_btn);  
			System.out.println("It is a button:--Pass--  \n");
        }
        catch(Exception e) {
        	System.out.println("It is not a button:--Fail--  \n");
        }
        
        
        
        
//--------------------------    	Check button click   -------------------------------- 
        
    	submit_btn.click();
        String Actual_sbtn = "background: green;";
		String Expexted_sbtn = submit_btn.getAttribute("style"); //	System.out.println(Expexted_sbtn);
						
		
        try {
        	Assert.assertEquals(Actual_sbtn,Expexted_sbtn);  
        	System.out.println("Submit Button Clicked:--Pass-- \n");
        }
        catch(Exception e) {
        	System.out.println("Submit Button not click:--Fail-- \n");
        }
        
        
        
//--------------------------       Male Radio-button Module	-------------------------------------
        
        WebElement male = driver.findElement(By.cssSelector("#male")); //System.out.println(male.getTagName());
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
//-------------------------        Radio button Checked Or not	---------------------------------
		
		male.click();  //male.clear();
		boolean male_check = male.isSelected(); // System.out.println(male_check);
		String Expexted_male_check = String.valueOf(male_check);
		String Actual_male_check = "true";	
        
        try {
        	Assert.assertEquals(Actual_male_check,Expexted_male_check);		
			System.out.println("Male radio button enable:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("Male radio button disenable:--Fail-- \n");
		}
        
//-------------------------        Radio button enabled/disabled	-----------------------------
        
        boolean male_enable = male.isEnabled(); // System.out.println(male_check);
		String Expexted_male_enable = String.valueOf(male_check);
		String Actual_male_enable = "true";	
        
        try {
        	Assert.assertEquals(Actual_male_enable,Expexted_male_enable);	
			System.out.println("Female radio button enable:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("Female radio button disenable:--Fail-- \n");
		}
		
//-------------------------        Radio button type	-------------------------------------------
        
      
		String Actual_male_type = "radio";	
		String Expexted_male_type = male.getAttribute("type");
        
        try {
        	Assert.assertEquals(Actual_male_type,Expexted_male_type);	
			System.out.println("It is a (male) radio button:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("It is not a (male) radio button:--Fail-- \n");
		}
        
        
//--------------------------       Female check-box	Module-----------------------------------------------
        
        WebElement female = driver.findElement(By.cssSelector("#female")); //System.out.println(female);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		female.click(); //female.clear();
		
        boolean female_check = female.isSelected(); // System.out.println(male_check);
		String Expexted_female_check = String.valueOf(male_check);
		String Actual_female_check = "true";	
        
        try {
        	Assert.assertEquals(Actual_female_check,Expexted_female_check);	
			System.out.println("Checked Female:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("Unchecked Female:--Fail-- \n");
		}
		
//-------------------------        Radio button enabled/disabled	-------------------------------
        
        boolean female_enable = female.isEnabled(); // System.out.println(male_check);
		String Expexted_female_enable = String.valueOf(male_check);
		String Actual_female_enable = "true";	
        
        try {
        	Assert.assertEquals(Actual_female_enable,Expexted_female_enable);	
			System.out.println("Checked Female:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("Unchecked Female:--Fail-- \n");
		}
        
      //-------------------------        Radio button type	--------------------------------------
        
        String Actual_female_type = "radio";	
		String Expexted_female_type = female.getAttribute("type");
        
        try {
        	Assert.assertEquals(Actual_male_type,Expexted_male_type);	
			System.out.println("It is a (female) radio button:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("It is not a (female) radio button:--Fail-- \n");
		}
                
   
//-------------------------        Check-box Module		-----------------------------
        
        WebElement auto = driver.findElement(By.cssSelector(".Automation")); //System.out.println(female);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		auto.click(); //female.clear();
		
//-------------------------    Check-box Checked OR not	-----------------------------
		
		String Actual_auto = "true";
		boolean auto_ck =  auto.isSelected();
		String Expexted_auto = String.valueOf(auto_ck);
		
		try {
        	Assert.assertEquals(Actual_auto,Expexted_auto);	
			System.out.println("Checked Automation Testing :--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("UnChecked Automation Testing :--Fail-- \n");
		}
		
//-------------------------    Check-box Checked OR not	-----------------------------
		
		String Actual_ck_type = "checkbox";
		String Expexted_ck_type = auto.getAttribute("type");
		
		try {
        	Assert.assertEquals(Actual_ck_type,Expexted_ck_type);	
			System.out.println("It's a Automation Testing checkbox :--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("It's not a Automation Testing checkbox:--Fail-- \n");
		}
		
//-------------------------    Check-box disable/enable	-----------------------------
		
//		String Actual_ck_disable = "true";
//		String Ex
        
        driver.quit();
	}
	
}
