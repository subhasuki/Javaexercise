package mainproject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleWebpageAutomation {

	
	public static void main(String args[]) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",  "/home/zoho/Downloads/chromedriver");
//		System.setProperty("webdriver.gecko.driver","/home/zoho/Downloads/geckodriver");
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();


        Actions action = new Actions(driver);
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        
//--------------------------    Link : This is a link	------------------------------------- 
        WebElement heading = driver.findElement(By.xpath("/html/body/div/div[4]/div/p/a")); 
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//    	heading.click();    	
//-------------------------    	Click-able or not  --------------------------------------  
    	String Actual_URl_1 = "true";
		boolean eurl = heading.isEnabled();
		String Expexted_URL_1 = String.valueOf(eurl);
		try {
			Assert.assertEquals(Actual_URl_1,Expexted_URL_1);
			System.out.println("This link URL Clickable:--Pass-- \n");
			}
		catch(Exception e) {
			System.out.println("This link URL notclickable:--Fail-- \n");
		}
//-------------------------    	URL check  --------------------------------------
        
        WebElement heading2 = driver.findElement(By.xpath("/html/body/div/div[4]/div/p/a")); 
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        heading2.click();
		String Actual_URl = "https://www.javatpoint.com/";
		String Expexted_URL = driver.getCurrentUrl();
		
        try{
        	Assert.assertEquals(Actual_URl,Expexted_URL);
        	System.out.println("Current URL:--Pass-- \n");
        }
        catch(Exception e){
        	System.out.println("Current URL:--Fail-- \n");
        }
        driver.navigate().back();
        
//-------------------------    	URL type  --------------------------------------
        
        WebElement heading1 = driver.findElement(By.xpath("/html/body/div/div[4]/div/p/a")); 
        String Expexted_URL_type = heading1.getTagName();
        String Actual_URl_type = "a";	
			try{
				Assert.assertEquals(Actual_URl_type,Expexted_URL_type);
        		System.out.println("It's a link tag:--Pass-- \n");
			}
			catch(Exception e){
				System.out.println("It's a not link tag:--Fail-- \n");
			}
//        driver.navigate().back();
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
        
        WebElement male = driver.findElement(By.cssSelector("#male")); 
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
        
//-------------------------   Automation Testing Check-box  -----------------------------     
        
      WebElement auto = driver.findElement(By.cssSelector(".Automation")); 
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		auto.click(); 
		
//-------------------------   Automation Testing Check-box Checked OR not	-----------------------------
		
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
		
		String Actual_ck_disable = "true";
		boolean ck_disable = auto.isEnabled();
		String Expeted_ck_disable = String.valueOf(ck_disable);
		
		try {
        	Assert.assertEquals(Actual_ck_disable,Expeted_ck_disable);	
			System.out.println("Automation Testing checkbox Enabled:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("Automation Testing checkbox Disabled:--Fail-- \n");
		}

		
        
      WebElement Performance = driver.findElement(By.cssSelector(".Performance")); //System.out.println(female);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Performance.click(); 
		
//-------------------------    Check-box Checked OR not	-----------------------------
		
		String Actual_Performance = "true";
		boolean Performance_ck =  Performance.isSelected();
		String Expexted_Performance = String.valueOf(Performance_ck);
		
		try {
        	Assert.assertEquals(Actual_Performance,Expexted_Performance);	
			System.out.println("Checked Performance Testing :--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("UnChecked Performance Testing :--Fail-- \n");
		}
		
//-------------------------    Check-box Checked OR not	-----------------------------
		
		String Actual_pf_type = "checkbox";
		String Expexted_pf_type = Performance.getAttribute("type");
		
		try {
        	Assert.assertEquals(Actual_pf_type,Expexted_pf_type);	
			System.out.println("It's a Performance Testing checkbox :--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("It's not a Performance Testing checkbox:--Fail-- \n");
		}
		
//-------------------------    Check-box disable/enable	-----------------------------
		
		String Actual_pf_disable = "true";
		boolean pf_disable = Performance.isEnabled();
		String Expeted_pf_disable = String.valueOf(pf_disable);
		
		try {
        	Assert.assertEquals(Actual_pf_disable,Expeted_pf_disable);	
			System.out.println("Performance Testing checkbox Enabled:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("Performance Testing checkbox Disabled:--Fail-- \n");
		}
		
//-------------------------    Multiple check-box check	-----------------------------	
		
		Performance.click();
		auto.click(); 
		System.out.println("Pass Multiplecheck");
		
		String Actual_mul = "true";
		String Expeted_mul = String.valueOf(pf_disable);
		
		try {
        	Assert.assertEquals(Actual_pf_disable,Expeted_pf_disable);	
			System.out.println(" Performance Testing checkbox Enabled:--Pass-- \n");
		}
		catch(Exception e) {
			System.out.println("Performance Testing checkbox Disabled:--Fail-- \n");
		}
		driver.navigate().refresh();
		
		
	
//-------------------------    Double click	-----------------------------		
		try {	
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"dblClkBtn\"]")); 
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			Thread.sleep(1000);
//			System.out.println(dbclk);
			if(ele.isEnabled()) {
				Thread.sleep(3000);
//				((Actions) ele).doubleClick();
				action.moveToElement(driver.findElement(By.xpath("//*[@id=\"dblClkBtn\"]"))).doubleClick().build().perform();
				Thread.sleep(2000);
			} else {
				System.out.println(ele);
			}
			
			String ActualData = "hi, JavaTpoint Testing";
			String ExpectedData = driver.switchTo().alert().getText();
		} catch(Exception e) {
			System.out.println(e);
		}		
//-------------------------    Double click	Type-----------------------------
		try {
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"dblClkBtn\"]")); 
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			String Actual_btn_type = "button";
			String Expected_btn_type = ele.getTagName();
			Assert.assertEquals(Actual_btn_type,Expected_btn_type);
			System.out.println("It's a Double click button:---Pass---");
		}
		catch(Exception e) {
			System.out.println("It's not a Double click button:---Fail---");	
		}
//-------------------------    Double click	Button Click-able/or not-----------------------------
		try {
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"dblClkBtn\"]")); 
			ele.click();
			String Actual_btn_click = "true";
			boolean btn_enable = ele.isEnabled();
			String Expected_btn_click = String.valueOf(btn_enable);
			Assert.assertEquals(Actual_btn_click,Expected_btn_click);
			System.out.println("Double click button is clickable:---Pass--");
		}
		catch(Exception e) {
			System.out.println("Double click button i not clickable:---Fail---");	
		}		
//-------------------------    Generate Alert box-----------------------------
		try {
			WebElement alert_box = driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			alert_box.click();
			String Actual_Alert = "hi, JavaTpoint Testing";
			String Expected_Alert = driver.switchTo().alert().getText();
			Assert.assertEquals(Actual_Alert,Expected_Alert);
			System.out.println("Generate Alert box Accept:pass");
		} catch(Exception e) {
			System.out.println("Generate Alert box not Accept:pass");
		}		
		
		
//-------------------------    Generate Confirm box(Cancel button)-----------------------------
		try {
			WebElement alert_box1 = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(2000);
			alert_box1.click();
			driver.switchTo().alert().dismiss();
			String Actual_Alert_cancel = "You pressed Cancel!";
			String Expected_Alert1_cancel = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();		
//			System.out.println(Expected_Alert1_cnfrm);
			Assert.assertEquals(Actual_Alert_cancel,Expected_Alert1_cancel);
			System.out.println("Generate confrim box Cancel:Pass");
		} catch(Exception e) {
			System.out.println("Generate Alert box not Cancle:Fail");
		}		
		
//-------------------------    Generate Confirm box(OK button)-----------------------------		
		
		try {
			WebElement alert_box1 = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(2000);
			alert_box1.click();
			driver.switchTo().alert().accept();
			String Actual_Alert_cnfrm = "You pressed OK!";
			String Expected_Alert_cnfrm = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();		
//			System.out.println(Expected_Alert_cnfrm);
			Assert.assertEquals(Actual_Alert_cnfrm,Expected_Alert_cnfrm);
			System.out.println("Generate Alert box OK Accept:Pass");
		} catch(Exception e) {
			System.out.println("Generate Alert box OK not Accept:Fail");
		}
		
        driver.quit();
	}
	
}
