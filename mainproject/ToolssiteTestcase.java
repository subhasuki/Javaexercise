package mainproject;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolssiteTestcase {

		public static WebDriver driver;
//-------------------		Check X-path Enabled		------------------------
		public WebElement xpath_locator(String element) {
			WebElement path=null;
			try {
				path = driver.findElement(By.xpath(element));
				if(path.isEnabled()) {
					return path;
				}
				else {
					System.out.println("Xpath-Element is not enabled");
				}
			}
			catch(AssertionError e){
				System.out.println(e);
			}
			return path;
		}
//-------------------		Check CssSelector Enabled		------------------------
		public WebElement css_selector(String xcele) {
			WebElement path=null;
			try {
				path = driver.findElement(By.cssSelector(xcele));
				if(path.isEnabled()) {
					return path;
				}
				else {
					System.out.println("CSS-Element is not enabled");
				}
			}
			catch(AssertionError e){
				System.out.println(e);
			}
			return path;
		}
//-------------------		Driver Set-up		------------------------
		@Before
		public void defineurl() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",  "/home/zoho/Downloads/chromedriver");
//			System.setProperty("webdriver.gecko.driver","/home/zoho/Downloads/geckodriver");
			driver = new ChromeDriver();	
			driver.manage().window().maximize();
	        driver.get("https://demoqa.com/elements");
	        Thread.sleep(2000);
		}
//-------------------		Tools site Testing		------------------------
//		@Test
//		public void textbox() throws InterruptedException {
//			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
////			WebElement submit =this.css_selector("#submit");
////			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submit);
////			submit.click();
////			String Actual_submit ="Fill the form"; 
////			String Expected_submit ="Fill the form";			
////			assertEquals("Empty Submit->Fail",Actual_submit,Expected_submit);
//			WebElement txtbx =this.xpath_locator("//*[@id=\"item-0\"]");
//			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//			txtbx.click();
//				//----------------Username-------------------------
//			WebElement fname =this.css_selector("#userName");
//			fname.click();
//			fname.clear();
//			fname.sendKeys("Subha");
//			String Actual_fname ="Subha";
//			assertEquals("Pass->Valied name",Actual_fname,fname.getAttribute("value"));
//			//----------------Email-------------------------
//			WebElement umail =this.css_selector("#userEmail");
//			umail.click();
//			umail.clear();
//			umail.sendKeys("Subha@gmail.com");
//			String Actual_email ="Subha@gmail.com";
//			assertEquals("Pass->Valied Email",Actual_email,umail.getAttribute("value"));
//			//----------------CurrentAddress-------------------------
//			WebElement address =this.css_selector("#currentAddress");
//			address.click();
//			address.clear();
//			address.sendKeys("6/53 North car street,kadayam");
//			String Actual_address ="6/53 North car street,kadayam";
//			assertEquals("Pass->Valied Address",Actual_address,address.getAttribute("value"));
//			//----------------PermanentAddress-------------------------
//			WebElement paddress =this.css_selector("#permanentAddress");
//			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", paddress);
//			paddress.click();
//			paddress.clear();
//			paddress.sendKeys("6/53 North car street,kadayam");
//			String Actual_paddress ="6/53 North car street,kadayam";
//			assertEquals("Pass->Valied Perment-Address",Actual_paddress,paddress.getAttribute("value"));
//			//----------------Submit-------------------------
//			WebElement submit =this.css_selector("#submit");
//			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submit);
//			submit.click();
//			Thread.sleep(3000);
//		}
		@Test
		public void checkbox() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			WebElement checkbox =this.css_selector("#item-1");
			checkbox.click();
			String checkurl="https://demoqa.com/checkbox";
			assertEquals(checkurl,driver.getCurrentUrl());
			WebElement home =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/button");
			home.click();
			WebElement homeck =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/label");
			homeck.click();
			String Actual_result = "You have selected :\n" + 
					"home\n" + 
					"desktop\n" + 
					"notes\n" + 
					"commands\n" + 
					"documents\n" + 
					"workspace\n" + 
					"react\n" + 
					"angular\n" + 
					"veu\n" + 
					"office\n" + 
					"public\n" + 
					"private\n" + 
					"classified\n" + 
					"general\n" + 
					"downloads\n" + 
					"wordFile\n" + 
					"excelFile" ;
			String Expected_result =this.css_selector("#result").getText();
			assertEquals(Actual_result,Expected_result);
			driver.navigate().refresh();
			this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/button").click();
			WebElement desktop =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button");
			desktop.click();			
			WebElement desktopck =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label");
			desktopck.click();
			String Actual_desk ="You have selected :\n" + 
					"desktop\n" + 
					"notes\n" + 
					"commands";
			String Expected_desk=this.css_selector("#result").getText();
			assertEquals(Actual_desk,Expected_desk);
			driver.navigate().refresh();
			this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/button").click();
			WebElement document =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button");
			document.click();
			WebElement office =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button");
			office.click();
			WebElement General =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label");
			General.click();	
			String Actual_gentral ="You have selected :\n" + 
					"general";
			String Expected_gentral =this.css_selector("#result").getText();
			System.out.println(Expected_gentral);
			assertEquals(Actual_gentral,Expected_gentral);
			Thread.sleep(3000);
			driver.navigate().refresh();
		}
//-------------------		Quit		------------------------	
		@After
		public void quitfun() {
			driver.quit();
		}
		
}
