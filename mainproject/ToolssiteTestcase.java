package mainproject;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
	public WebElement css_selector(String element) {
		WebElement path=null;
		try {
			path = driver.findElement(By.cssSelector(element));
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
	//-------------------		<Text-box Testing>		------------------------
			@Test
			public void textbox() throws InterruptedException {
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				WebElement txtbx =this.xpath_locator("//*[@id=\"item-0\"]");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				txtbx.click();
	//------------------		Empty Submit		-----------------------------
				WebElement submit1 =this.xpath_locator("//*[@id=\"submit\"]");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submit1);
				submit1.click();
				String Actual_submit ="Fill the form"; 
				String Expected_submit ="Fill the form";			
				assertEquals("Form is Empty ->Fail",Actual_submit,Expected_submit);
				System.out.println("Fail -> Form is Empty");
	//--------------------		Username		------------------------------------
				WebElement fname =this.css_selector("#userName");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				fname.click();
				fname.clear();
				fname.sendKeys("Subha");
				String Actual_fname ="Subha";
				assertEquals("Pass->Valied name",Actual_fname,fname.getAttribute("value"));
	//------------------		Email		--------------------------------
				WebElement umail =this.css_selector("#userEmail");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				umail.click();
				umail.clear();
				umail.sendKeys("Subha@gmail.com");
				String Actual_email ="Subha@gmail.com";
				assertEquals("Pass->Valied Email",Actual_email,umail.getAttribute("value"));
	//-----------------			Email-Invalid 		--------------------------------
				WebElement iumail =this.css_selector("#userEmail");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				iumail.click();
				iumail.clear();
				iumail.sendKeys("Subha");
				String Actual_iemail ="Subha";
				assertEquals("Pass->You should enter Valied Email",Actual_iemail,iumail.getAttribute("value"));
	//-------------------	CurrentAddress	-------------------------
				WebElement address =this.css_selector("#currentAddress");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				address.click();
				address.clear();
				address.sendKeys("6/53 North car street,kadayam");
				String Actual_address ="6/53 North car street,kadayam";
				assertEquals("Pass->Valied Address",Actual_address,address.getAttribute("value"));
	//----------------		PermanentAddress		-------------------------
				WebElement paddress =this.css_selector("#permanentAddress");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", paddress);
				paddress.click();
				paddress.clear();
				paddress.sendKeys("6/53 North car street,kadayam");
				String Actual_paddress ="6/53 North car street,kadayam";
				assertEquals("Pass->Valied Perment-Address",Actual_paddress,paddress.getAttribute("value"));
	//----------------		Submit		-------------------------
				WebElement submit =this.css_selector("#submit");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submit);
				submit.click();
				Thread.sleep(3000);
			}
			@Test
			public void checkbox() throws InterruptedException {
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				WebElement checkbox =this.css_selector("#item-1");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				checkbox.click();
				String checkurl="https://demoqa.com/checkbox";
				assertEquals(checkurl,driver.getCurrentUrl());
				WebElement home =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/button");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				home.click();
				WebElement homeck =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/label");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
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
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				WebElement desktop =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				desktop.click();			
				WebElement desktopck =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				desktopck.click();
				String Actual_desk ="You have selected :\n" + 
						"desktop\n" + 
						"notes\n" + 
						"commands";
				String Expected_desk=this.css_selector("#result").getText();
				assertEquals(Actual_desk,Expected_desk);
				driver.navigate().refresh();
				
				this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/button").click();
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				WebElement document =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				document.click();
				WebElement office =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				office.click();
				WebElement General =this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				General.click();	
				String Actual_gentral ="You have selected :\n" + 
						"general";
				String Expected_gentral =this.css_selector("#result").getText();
				System.out.println(Expected_gentral);
				assertEquals(Actual_gentral,Expected_gentral);
				Thread.sleep(3000);
				driver.navigate().refresh();
	//---------------------------			Expand and collapse Checkbox		-------------------------------
				WebElement expand =this.xpath_locator("//*[@id=\"tree-node\"]/div/button[1]");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				expand.click();
				WebElement collapse =this.xpath_locator("//*[@id=\"tree-node\"]/div/button[2]");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				collapse.click();
				driver.navigate().refresh();
			}
	//-----------------------------		<Radio Button>	-----------------------------
			@Test
			public void radio() {
				WebElement radio =this.css_selector("#item-2");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				radio.click();
	//----------------------------			yes			----------------------------
				WebElement radioclk =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				radioclk.click();
				String Actual_yes ="You have selected Yes";
				String Expected_yes=this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/p").getText();
				assertEquals(Actual_yes,Expected_yes);
	//----------------------------			Impressive		----------------------------
				WebElement Impressive =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				Impressive.click();
				String Actual_impressive ="You have selected Impressive";
				String Expected_impressive=this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/p").getText();
				assertEquals(Actual_impressive,Expected_impressive);
	//----------------------------			No		----------------------------	
				try {
					WebElement no =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[4]");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					no.isEnabled();
					System.out.println("Pass->No radio button is Enabled");
				}catch(Exception e) {
					System.out.println("Fail->No radio button is Not Enabled");
				}
			}
	//---------------------------		<Buttons>		-------------------------------
			@Test
			public void buttons() throws InterruptedException {
				WebElement btn =this.css_selector("#item-4");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btn);
				btn.click();
	//			Thread.sleep(3000);
	//--------------------------	Double click	---------------------------------- 
				Actions act = new Actions(driver);
				act.doubleClick(this.css_selector("#doubleClickBtn")).doubleClick().build().perform();
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				String Actual_dblclk ="You have done a double click";
				String Expected_dblclk=this.css_selector("#doubleClickMessage").getText();
				assertEquals(Actual_dblclk,Expected_dblclk);
	//--------------------------	Right Click		----------------------------------------
				WebElement rtclk =this.css_selector("#rightClickBtn");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				act.contextClick(rtclk).perform();
				String Actual_rtclk ="You have done a right click";
				String Expected_rtclk=this.css_selector("#rightClickMessage").getText();
				assertEquals(Actual_rtclk,Expected_rtclk);
	//--------------------------	Click Me		----------------------------------------
				this.xpath_locator("//button[normalize-space()='Click Me']").click();
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				String Actual_clkme ="You have done a dynamic click";
				String Expected_clkme=this.css_selector("#dynamicClickMessage").getText();
				assertEquals(Actual_clkme,Expected_clkme);
			}		
	//----------------------------		<Links>	-------------------------------------------
	@Test
	public void links() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		//--------------------------	Home link	-----------------------------------------
		WebElement homelink =this.css_selector("#simpleLink");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		homelink.click();
		Thread.sleep(2000);
		String mainW = driver.getWindowHandle();
		Set<String> mainW1 = driver.getWindowHandles();
		Iterator<String> iterator = mainW1.iterator();

		while (iterator.hasNext()) {
			String wdw_child = iterator.next();
			if (!mainW.equalsIgnoreCase(wdw_child)) {
				driver.switchTo().window(wdw_child);
				String url=  driver.getCurrentUrl();
				System.out.println(url);
				driver.close();

			}
		}

		Thread.sleep(1000);
		//--------------------------	Home Dynamic link	-----------------------------------------
					WebElement homedynamic =this.css_selector("#dynamicLink");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					homedynamic.click();
					Thread.sleep(3000);	
		//--------------------------	Created		-----------------------------------------		
					WebElement created =this.css_selector("#created");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					created.click();
					String Actual_create ="201";
					String Expected_create=this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
					System.out.println(Expected_create);	
					assertEquals(Actual_create,Expected_create);
		//--------------------------	No Content		-----------------------------------------	
					WebElement content =this.css_selector("#no-content");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					content.click();
					Thread.sleep(2000);
		//			WebElement Expected_content1 =this.xpath_locator("//*[@id=\"linkResponse\"]");
		//			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Expected_content1);
					String Actual_content ="204";
					String Expected_content =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
					System.out.println(Expected_content);			
					assertEquals(Actual_content,Expected_content);
		//--------------------------	Moved		-----------------------------------------	
					WebElement moved =this.css_selector("#moved");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					moved.click();
					Thread.sleep(2000);
					String Actual_moved ="301";
					String Expected_moved =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
					assertEquals(Actual_moved,Expected_moved);
		//--------------------------	Bad Request		-----------------------------------------	
					WebElement badrequest =this.css_selector("#bad-request");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					badrequest.click();
					Thread.sleep(2000);
					String Actual_badrequest ="400";
					String Expected_badrequest =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
					System.out.println(Expected_badrequest);			
					assertEquals(Actual_badrequest,Expected_badrequest);
		//--------------------------	Unauthorized		-----------------------------------------	
					WebElement unauthorized =this.css_selector("#unauthorized");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", unauthorized);
					unauthorized.click();
					Thread.sleep(2000);
					String Actual_Unauthorized ="401";
					String Expected_Unauthorized =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
					assertEquals(Actual_Unauthorized,Expected_Unauthorized);
		//--------------------------	Forbidden		-----------------------------------------	
					WebElement Forbidden =this.css_selector("#forbidden");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					Forbidden.click();
					Thread.sleep(2000);
					String Actual_Forbidden ="403";
					String Expected_Forbidden =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
					System.out.println(Expected_Forbidden);		
					assertEquals(Actual_Forbidden,Expected_Forbidden);
		//--------------------------	Not Found		-----------------------------------------	
					WebElement notfound =this.css_selector("#invalid-url");
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
					notfound.click();
					Thread.sleep(2000);
					String Actual_notfound ="404";
					String Expected_notfound =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
					System.out.println(Expected_notfound);		
					assertEquals(Actual_notfound,Expected_notfound);
	} 
	//--------------------------	Broken links-images -------------------------------------
//			@Test
//			public void brokenimages() {
//				WebElement brokelink =this.css_selector("#item-6");
//				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", brokelink);
//				brokelink.click();
//				WebElement brokeimg =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/img[2]");
//				System.out.println("Total no. of images are " + brokeimg.getSize());
//			}
			
	//-------------------------		Quit		-----------------------------------------	
			@After
			public void quitfun() {
				driver.quit();
			}

}
