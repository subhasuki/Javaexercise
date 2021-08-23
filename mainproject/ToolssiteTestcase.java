package mainproject;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
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

	static WebDriver driver;

	//-------------------		Check X-path Enabled Method		------------------------

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

	//-------------------		Check CssSelector Enabled Method	------------------------

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

	//-----------------		Min value Method	-------------------
	
	public WebElement Min_val(String minval) {
		WebElement minip=null;
		try {
			minip = driver.findElement(By.cssSelector(minval));
			minip.click();
			minip.clear();
			minip.sendKeys("qw");			
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return minip;
	}
	
	//-----------------		Max value Method	-------------------
	
	public WebElement Max_val(String maxval) {
		WebElement maxip=null;
		try {
			maxip = driver.findElement(By.cssSelector(maxval));
			maxip.click();
			maxip.clear();
			maxip.sendKeys("qwertyuiopasdfghjklzxcvbnm");			
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return maxip;
	}
	
	//-----------------		Number value Method	-------------------
	
	public WebElement Num_val(String numval) {
		WebElement numip=null;
		try {
			numip = driver.findElement(By.cssSelector(numval));
			numip.click();
			numip.clear();
			numip.sendKeys("123456789012345678901234567890");			
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return numip;
	}
	
	//-----------------		Special characters value Method	-------------------
	
	public WebElement Spl_char(String splchar) {
		WebElement splcharip=null;
		try {
			splcharip = driver.findElement(By.cssSelector(splchar));
			splcharip.click();
			splcharip.clear();
			splcharip.sendKeys("!@#$%^&*()<>?:[]`,.,.<>/`~");			
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return splcharip;
	}
	
	//-----------------		Block-Quotes value Method	-------------------
	
	public WebElement block_quote(String blkqut) {
		WebElement blkqutip=null;
		try {
			blkqutip = driver.findElement(By.cssSelector(blkqut));
			blkqutip.click();
			blkqutip.clear();
			blkqutip.sendKeys("````````````````````");			
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return blkqutip;
	}
	
	//-----------------		Empty Input Field Method	-------------------
	
	public WebElement EmptyField(String emptyfld) {
		WebElement emptyfldip=null;
		try {
			emptyfldip = driver.findElement(By.cssSelector(emptyfld));
			emptyfldip.click();
			emptyfldip.clear();
			emptyfldip.sendKeys("");			
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return emptyfldip;
	}
	
	
	//-----------------		Submit Click Method		 ------------------
	
	public WebElement Submit_BtnClk(String submitclk) {
		WebElement subclk=null;
		try {
			subclk = driver.findElement(By.cssSelector(submitclk));
			subclk.click();			
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return subclk;
	}

	//-------------------		Driver Set-up Method			------------------------

	@Before
	public void defineUrl() {
		System.setProperty("webdriver.chrome.driver",  "/home/zoho/Downloads/chromedriver");
		//			System.setProperty("webdriver.gecko.driver","/home/zoho/Downloads/geckodriver");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/elements");
	}

	//	//-------------------		1.< Text-box Testing >		------------------------

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
	//-------------------		2.< Check-box >		------------------------
	
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
	
	//-----------------------------		3.< Radio Button >	-----------------------------
	@Test
	public void Radio() {
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
	//---------------------------		5.< Buttons >		-------------------------------
	@Test
	public void DoubleClick() throws InterruptedException {
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
	}
		//--------------------------	Right Click		----------------------------------------
	@Test
	public void RightCLick() throws InterruptedException {
		WebElement btn =this.css_selector("#item-4");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btn);
		btn.click();
		
		WebElement rtclk =this.css_selector("#rightClickBtn");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Actions act = new Actions(driver);
		act.contextClick(rtclk).perform();
		String Actual_rtclk ="You have done a right click";
		String Expected_rtclk=this.css_selector("#rightClickMessage").getText();
		assertEquals(Actual_rtclk,Expected_rtclk);
	}
		//--------------------------	Click Me		----------------------------------------
	@Test
	public void ClickMe() throws InterruptedException {
		WebElement btn =this.css_selector("#item-4");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btn);
		btn.click();
		
		this.xpath_locator("//button[normalize-space()='Click Me']").click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		String Actual_clkme ="You have done a dynamic click";
		String Expected_clkme=this.css_selector("#dynamicClickMessage").getText();
		assertEquals(Actual_clkme,Expected_clkme);
	}		
	
	//----------------------------		6.< Links >	-------------------------------------------
	
	@Test
	public void HomeLinks() throws InterruptedException {
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
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
//		String mainW = driver.getWindowHandle();
//		Set<String> mainW1 = driver.getWindowHandles();
//		for (String allwindow:mainW1) {
//			if (!allwindow.equalsIgnoreCase(mainW)) {
//				driver.switchTo().window(allwindow);
//				String url=  driver.getCurrentUrl();
////				System.out.println(url);
//				driver.close();
//		}
//
//			}
	}
		//--------------------------	Home Dynamic link	-----------------------------------------
	@Test
	public void HomeDynamicLinks() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement homedynamic= this.css_selector("#dynamicLink");		
		homedynamic.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
//		Thread.sleep(1000);	
//		Set<String> mainW1 = driver.getWindowHandles();
//		String mainW = driver.getWindowHandle();
//		for (String allwindow:mainW1) {
//			if (!allwindow.equalsIgnoreCase(mainW)) {
//				driver.switchTo().window(allwindow);
//				String url=  driver.getCurrentUrl();
////				System.out.println(url);
//				driver.close();
//		}
//			}
	}
		//--------------------------	Created		-----------------------------------------
	@Test
	public void Created() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement created =this.css_selector("#created");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		created.click();
		String Actual_create ="201";
		String Expected_create=this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
		System.out.println(Expected_create);	
		assertEquals(Actual_create,Expected_create);
	}
		
		//--------------------------	No Content		-----------------------------------------	
	@Test
	public void NoContent() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement content =this.css_selector("#no-content");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		content.click();
		Thread.sleep(2000);
		String Actual_content ="204";
		String Expected_content =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
		System.out.println(Expected_content);			
		assertEquals(Actual_content,Expected_content);
	}
		//--------------------------	Moved		-----------------------------------------
	@Test
	public void Moved() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement moved =this.css_selector("#moved");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		moved.click();
		Thread.sleep(2000);
		String Actual_moved ="301";
		String Expected_moved =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
		assertEquals(Actual_moved,Expected_moved);
	}
		//--------------------------	Bad Request		-----------------------------------------
	@Test
	public void BadRequest() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement badrequest =this.css_selector("#bad-request");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		badrequest.click();
		Thread.sleep(2000);
		String Actual_badrequest ="400";
		String Expected_badrequest =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
		System.out.println(Expected_badrequest);			
		assertEquals(Actual_badrequest,Expected_badrequest);
	}
		//--------------------------	Unauthorized		-----------------------------------------	
	@Test
	public void Unauthorized() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement unauthorized =this.css_selector("#unauthorized");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", unauthorized);
		unauthorized.click();
		Thread.sleep(2000);
		String Actual_Unauthorized ="401";
		String Expected_Unauthorized =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
		assertEquals(Actual_Unauthorized,Expected_Unauthorized);
	}
		//--------------------------	Forbidden		-----------------------------------------
	@Test
	public void Forbidden() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement Forbidden =this.css_selector("#forbidden");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Forbidden.click();
		Thread.sleep(2000);
		String Actual_Forbidden ="403";
		String Expected_Forbidden =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
		System.out.println(Expected_Forbidden);		
		assertEquals(Actual_Forbidden,Expected_Forbidden);
	}
		//--------------------------	Not Found		-----------------------------------------	
	@Test
	public void NotFound() throws InterruptedException {
		WebElement links =this.css_selector("#item-5");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", links);
		links.click();
		Thread.sleep(2000);
		
		WebElement notfound =this.css_selector("#invalid-url");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		notfound.click();
		Thread.sleep(2000);
		String Actual_notfound ="404";
		String Expected_notfound =this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
		System.out.println(Expected_notfound);		
		assertEquals(Actual_notfound,Expected_notfound);
	} 
	
	//		--------------------------	7.< Broken links-images > -------------------------------------
	
	@Test
	public void Validimg() throws InterruptedException {
		WebElement brokelink =this.css_selector("#item-6");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", brokelink);
		brokelink.click();
		
		//-------------------------------		valid image		----------------------------------------
		
		WebElement validimg =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/img[1]");
		Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", validimg);

			if (p) {
				System.out.println("Tools logo present");
			} else {
				System.out.println("Tools logo not present");
			}
	}
		//-------------------------------		Broken image		----------------------------------------
	@Test
	public void BrokenImages() throws InterruptedException {
		WebElement brokelink =this.css_selector("#item-6");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", brokelink);
		brokelink.click();
		
		WebElement brokeimg =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/img[2]");
		Boolean p1 = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", brokeimg);


			if (p1) {
				System.out.println("Image present");
			} else {
				System.out.println("Image is not present");
			}
	}
		//-------------------------------		Valid link		----------------------------------------
	@Test
	public void ValidLink() throws InterruptedException {
		WebElement brokelink =this.css_selector("#item-6");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", brokelink);
		brokelink.click();
		
		WebElement validlink =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/a[1]");
		System.out.println(validlink);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", validlink);
		validlink.click();
		Thread.sleep(2000);
		String Actual_vlink ="https://demoqa.com/";
		String Expect_vlink =driver.getCurrentUrl();
		assertEquals(Actual_vlink,Expect_vlink);
		driver.navigate().back();
	}
		//-------------------------------		Broken link		----------------------------------------
	@Test
	public void BrokenLink() throws InterruptedException {
		WebElement brokelink =this.css_selector("#item-6");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", brokelink);
		brokelink.click();
		
		WebElement invalidlink =this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/a[2]");
		System.out.println(invalidlink.getTagName());
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", invalidlink);
		invalidlink.click();
		String title= driver.getTitle();
		System.out.println(title);
			if(title.contains("The Internet")) {
			System.out.println("Link is broken");
			}
			driver.navigate().back();
	}		

	//-----------------------------	8.< Download & Upload >	----------------------------------------
	
	@Test
	public void download() throws InterruptedException{
		WebElement clkdwd =this.css_selector("#item-7");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", clkdwd);
		clkdwd.click();
		
		//-----------------------------		click download	----------------------------------------
		
		WebElement download =this.css_selector("#downloadButton");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		download.click();
		String Actual_download = "file";
		assertEquals(Actual_download,download.getAttribute("type"));
		String Actual_dwd = "sampleFile.jpeg";
		String Expected_dwd =this.xpath_locator("//a[@download='sampleFile.jpeg']").getAttribute("download");
		assertEquals(Actual_dwd,Expected_dwd);
	}
		//-----------------------------		click Upload	----------------------------------------
	@Test
	public void Upload() throws InterruptedException{
		WebElement clkdwd =this.css_selector("#item-7");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", clkdwd);
		clkdwd.click();
			
		WebElement upload =this.css_selector("#uploadFile");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		upload.sendKeys("/home/zoho/Downloads/sampleFile.jpeg");
		String Actual_upload = "C:\\fakepath\\sampleFile.jpeg";
		String Expected_upload = this.css_selector("#uploadedFilePath").getText();
		assertEquals(Actual_upload,Expected_upload);				
	}
	
	//-----------------------------		< Dynamic Properties >	----------------------------------------
	
	@Test
	public void dynamciProperty() throws InterruptedException{
		WebElement dynpty =this.css_selector("#item-8");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", dynpty);
		dynpty.click();
		Thread.sleep(5000);
		
		//-----------------------------		color check		----------------------------------------
		
		String Expected_clr=this.xpath_locator("//button[@class='mt-4 text-danger btn btn-primary']").getAttribute("class");
		System.out.println(Expected_clr);
		String Actual_clr = "mt-4 text-danger btn btn-primary";
		assertEquals(Expected_clr,Actual_clr);
		
		//-----------------------------		Visible After 5 Second		----------------------------------------
		
		String Expected_sec=this.xpath_locator("//button[normalize-space()='Visible After 5 Seconds']").getText();
		String Actual_sec = "Visible After 5 Seconds";
		assertEquals(Expected_sec,Actual_sec);
	}
	
	//-------------------------------	4.< Web Tables >		------------------------------------------
	
	@Test
	public void webTables() throws InterruptedException{
		WebElement webclk =this.css_selector("#item-3");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
		webclk.click();
		WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		addclk.click();
		
//------------------------------		Empty Submit	------------------------------------------
		
		WebElement submitclk =this.Submit_BtnClk("#submit");
		submitclk.click();
		Thread.sleep(1000);
		WebElement Expact_ffname_clr =this.css_selector("#firstName:invalid");
		assertTrue(Expact_ffname_clr.isDisplayed());
		WebElement Expact_lname_clr =this.css_selector("#lastName:invalid");
		assertTrue(Expact_lname_clr.isDisplayed());
		WebElement Expect_umail_clr =this.css_selector("#userEmail:invalid");
		assertTrue(Expect_umail_clr.isDisplayed());
		WebElement Expect_age_clr =this.css_selector("#age:invalid");
		assertTrue(Expect_age_clr.isDisplayed());
		WebElement Expect_salary_clr =this.css_selector("#salary:invalid");
		assertTrue(Expect_salary_clr.isDisplayed());
		WebElement Expect_department_clr =this.css_selector("#department:invalid");
		assertTrue(Expect_department_clr.isDisplayed());
	}
		
//-------------------------------	FirstName	--------------------------------------------------- 
	@Test
	public void FirstName() throws InterruptedException{
		WebElement webclk =this.css_selector("#item-3");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
		webclk.click();
		
		WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		addclk.click();
				
		WebElement mfname =this.Min_val("#firstName");
		String act_fname ="qw";
		assertEquals(act_fname,mfname.getAttribute("value"));
		
		WebElement submitclk =this.Submit_BtnClk("#submit");
		submitclk.click();		
		Thread.sleep(1000);
		String Expect_min_clr = mfname.getCssValue("border-color"); 
		String Actual_min_clr = "rgb(40, 167, 69)";
		assertEquals(Expect_min_clr,Actual_min_clr);
		String act_mfname ="qw";
		assertEquals(act_mfname,mfname.getAttribute("value"));
		
		WebElement max_fname =this.Max_val("#firstName");
		Thread.sleep(1000);
		String Expect_max_clr = max_fname.getCssValue("border-color"); 
		String Actual_max_clr = "rgb(40, 167, 69)";
		assertEquals(Expect_max_clr,Actual_max_clr);
		String act_max_fname ="qwertyuiopasdfghjklzxcvbnm";
		assertNotEquals(act_max_fname,max_fname.getAttribute("value"));
		
		
		WebElement num_fname =this.Num_val("#firstName");
		Thread.sleep(1000);
		String Expect_num_clr = num_fname.getCssValue("border-color"); 
		String Actual_num_clr = "rgb(40, 167, 69)";
		assertNotEquals("You must type letters",Expect_num_clr,Actual_num_clr);
		String act_num_fname ="123456789012345678901234567890";
		assertEquals(act_num_fname,num_fname.getAttribute("value"));
		
		WebElement Spl_fname =this.Spl_char("#firstName");
		Thread.sleep(1000);
		String Expect_Spl_fname = Spl_fname.getCssValue("border-color"); 
		String Actual_Spl_fname = "rgb(40, 167, 69)";
		assertNotEquals("You must type letters",Expect_Spl_fname,Actual_Spl_fname);
		String act_spl_fname ="!@#$%^&*()<>?:[]`,.,.<>/`~";
		assertEquals(act_spl_fname,Spl_fname.getAttribute("value"));
		
		WebElement blkqt_fname =this.block_quote("#firstName");
		Thread.sleep(1000);
		String Expect_blkqt_fname = blkqt_fname.getCssValue("border-color"); 
		String Actual_blkqt_fname = "rgb(40, 167, 69)";
		assertNotEquals("Not Accept Block Quotes",Expect_blkqt_fname,Actual_blkqt_fname);
		String act_blk_fname ="````````````````````";
		assertEquals(act_blk_fname,blkqt_fname.getAttribute("value"));
		
		WebElement empty_fname =this.EmptyField("#firstName");
		Thread.sleep(1000);
		String Expect_empty_fname = empty_fname.getCssValue("border-color"); 
		String Actual_empty_fname = "rgb(40, 167, 69)";
		assertNotEquals("Empty Filed",Expect_empty_fname,Actual_empty_fname);
		
		WebElement no_str_fname =this.css_selector("#firstName");
		no_str_fname.click();
		no_str_fname.clear();
		no_str_fname.sendKeys("Subha123");
		Thread.sleep(1000);
		String Expect_no_str_fname = no_str_fname.getCssValue("border-color"); 
		String Actual_no_str_fname = "rgb(40, 167, 69)";
		assertNotEquals("Valid value",Expect_no_str_fname,Actual_no_str_fname);
		String act_no_str_fname ="Subha123";
		assertEquals(act_no_str_fname,no_str_fname.getAttribute("value"));
		
		WebElement valid_fname =this.css_selector("#firstName");
		valid_fname.click();
		valid_fname.clear();
		valid_fname.sendKeys("Subha");
		Thread.sleep(1000);
		String Expect_valid_fname = valid_fname.getCssValue("border-color"); 
		String Actual_valid_fname = "rgb(40, 167, 69)";
		assertNotEquals("Valid value",Expect_valid_fname,Actual_valid_fname);
		String act_valid_fname ="Subha";
		assertEquals(act_valid_fname,valid_fname.getAttribute("value"));
	}
//-----------------------------		LastName		-------------------------------------
	@Test
	public void LastName() throws InterruptedException{
		WebElement webclk =this.css_selector("#item-3");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
		webclk.click();
		
		WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		addclk.click();
		
		WebElement mlname =this.Min_val("#lastName");
		
		WebElement submitclk =this.Submit_BtnClk("#submit");
		submitclk.click();
		Thread.sleep(1000);
		
		String Expect_min_lclr = mlname.getCssValue("border-color"); 
		String Actual_min_lclr = "rgb(40, 167, 69)";
		assertEquals(Expect_min_lclr,Actual_min_lclr);
		String act_mlname ="qw";
		assertEquals(act_mlname,mlname.getAttribute("value"));
		
		WebElement max_lname =this.Max_val("#lastName");
		Thread.sleep(1000);
		String Actual_max_lname_clr ="rgb(40, 167, 69)";
		String Expect_max_lname_clr=max_lname.getCssValue("border-color");
		assertEquals(Actual_max_lname_clr,Expect_max_lname_clr);
		String act_max_lname ="qwertyuiopasdfghjklzxcvbnm";
		assertNotEquals(act_max_lname,max_lname.getAttribute("value"));
		
		WebElement num_lname =this.Num_val("#lastName");
		Thread.sleep(1000);
		String Expect_num_lclr = num_lname.getCssValue("border-color"); 
		String Actual_num_lclr = "rgb(40, 167, 69)";
		assertNotEquals("You must type letters",Expect_num_lclr,Actual_num_lclr);
		String act_num_lname ="123456789012345678901234567890";
		assertEquals(act_num_lname,num_lname.getAttribute("value"));
		
		WebElement Spl_fname =this.Spl_char("#lastName");
		Thread.sleep(1000);
		String Expect_Spl_lname = Spl_fname.getCssValue("border-color"); 
		String Actual_Spl_lname = "rgb(40, 167, 69)";		
		assertNotEquals("You must type letters",Expect_Spl_lname,Actual_Spl_lname);
		String act_spl_fname ="!@#$%^&*()<>?:[]`,.,.<>/`~";
		assertEquals(act_spl_fname,Spl_fname.getAttribute("value"));
		
		WebElement blkqt_lname =this.block_quote("#lastName");
		Thread.sleep(1000);
		String Expect_blkqt_lname = blkqt_lname.getCssValue("border-color"); 
		String Actual_blkqt_lname = "rgb(40, 167, 69)";
		assertNotEquals("Not Accept Block Quotes",Expect_blkqt_lname,Actual_blkqt_lname);
		String act_blk_lname ="````````````````````";
		assertEquals(act_blk_lname,blkqt_lname.getAttribute("value"));
		
		WebElement empty_lname =this.EmptyField("#lastName");
		Thread.sleep(1000);
		String Expect_empty_lname = empty_lname.getCssValue("border-color"); 
		String Actual_empty_lname = "rgb(40, 167, 69)";
		assertNotEquals("Empty Filed",Expect_empty_lname,Actual_empty_lname);
		
		WebElement no_str_lname =this.css_selector("#lastName");
		no_str_lname.click();
		no_str_lname.clear();
		no_str_lname.sendKeys("Subha123");
		Thread.sleep(1000);
		String Expect_no_str_lname = no_str_lname.getCssValue("border-color"); 
		String Actual_no_str_lname = "rgb(40, 167, 69)";
		assertNotEquals("Valid value",Expect_no_str_lname,Actual_no_str_lname);
		String act_no_str_fname ="Subha123";
		assertEquals(act_no_str_fname,no_str_lname.getAttribute("value"));
		
		WebElement valid_lname =this.css_selector("#lastName");
		valid_lname.click();
		valid_lname.clear();
		valid_lname.sendKeys("Subha");
		Thread.sleep(1000);
		String Expect_valid_lname = valid_lname.getCssValue("border-color"); 
		String Actual_valid_lname = "rgb(40, 167, 69)";
		assertNotEquals("Valid value",Expect_valid_lname,Actual_valid_lname);
		String act_valid_lname ="Subha";
		assertEquals(act_valid_lname,valid_lname.getAttribute("value"));
		
	}
	
	//-----------------------------		Email		-------------------------------------
	@Test
	public void Email() throws InterruptedException{
		WebElement webclk =this.css_selector("#item-3");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
		webclk.click();
		
		WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		addclk.click();
		
		WebElement mumail =this.css_selector("#userEmail");
		mumail.click();
		mumail.clear();
		mumail.sendKeys("a@gmail.com");
		Thread.sleep(1000);
		
		WebElement submitclk =this.Submit_BtnClk("#submit");
		submitclk.click();
		
		String Actual_mumail_clr ="rgb(40, 167, 69)";
		String Expect_mumail_clr=mumail.getCssValue("border-color");
		assertNotEquals(Actual_mumail_clr,Expect_mumail_clr);
		String act_mumail ="a@gmail.com";
		assertEquals(act_mumail,mumail.getAttribute("value"));
		
		WebElement max_umail =this.css_selector("#userEmail");
		max_umail.click();
		max_umail.clear();
		max_umail.sendKeys("qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm@gmail.com");
		Thread.sleep(1000);
		String Actual_max_umail_clr ="rgb(40, 167, 69)";
		String Expect_max_umail_clr=max_umail.getCssValue("border-color");
		assertNotEquals("Max char -> it is a invalid Email",Actual_max_umail_clr,Expect_max_umail_clr);
		
		WebElement num_email =this.css_selector("#userEmail");
		num_email.click();
		num_email.clear();
		num_email.sendKeys("123456789012345678901234567890@gmail.com");
		Thread.sleep(1000);
		String Expect_num_email= num_email.getCssValue("border-color"); 
		String Actual_num_email= "rgb(40, 167, 69)";
		assertNotEquals("You must type letters",Expect_num_email,Actual_num_email);
		String act_num_lname ="123456789012345678901234567890@gmail.com";
		assertEquals(act_num_lname,num_email.getAttribute("value"));
		
		WebElement Spl_email =this.css_selector("#userEmail");
		Spl_email.click();
		Spl_email.clear();
		Spl_email.sendKeys("wer!#$%^&*()<>?:[]`,.,.<>/`~@gmail.com");
		Thread.sleep(1000);
		String Expect_Spl_email = Spl_email.getCssValue("border-color"); 
		String Actual_Spl_email= "rgb(40, 167, 69)";
		
		assertNotEquals("You must type letters",Expect_Spl_email,Actual_Spl_email);
		String act_spl_fname ="wer!#$%^&*()<>?:[]`,.,.<>/`~@gmail.com";
		assertEquals("Pass->Invalid Email",act_spl_fname,Spl_email.getAttribute("value"));
		
		WebElement blkqt_email =this.css_selector("#userEmail");
		blkqt_email.click();
		blkqt_email.clear();
		blkqt_email.sendKeys("````````````````````@gmail.com");
		Thread.sleep(1000);
		String Expect_blkqt_email = blkqt_email.getCssValue("border-color"); 
		String Actual_blkqt_email = "rgb(40, 167, 69)";
		assertNotEquals("Not Accept Block Quotes",Expect_blkqt_email,Actual_blkqt_email);
		String act_blk_email ="````````````````````@gmail.com";
		assertEquals(act_blk_email,blkqt_email.getAttribute("value"));
		
		WebElement empty_email =this.EmptyField("#userEmail");
		Thread.sleep(1000);
		String Expect_empty_email = empty_email.getCssValue("border-color"); 
		String Actual_empty_email = "rgb(40, 167, 69)";
		assertNotEquals("Empty Filed",Expect_empty_email,Actual_empty_email);
		
		WebElement valid_email =this.css_selector("#userEmail");
		valid_email.click();
		valid_email.clear();
		valid_email.sendKeys("Subha@gmail.com");
		Thread.sleep(1000);
		String Expect_valid_email = valid_email.getCssValue("border-color"); 
		String Actual_valid_email = "rgb(40, 167, 69)";
		assertNotEquals("Valid value",Expect_valid_email,Actual_valid_email);
		String act_valid_email ="Subha@gmail.com";
		assertEquals(act_valid_email,valid_email.getAttribute("value"));
	}
	
	//-----------------------------		Age		-------------------------------------
	@Test
	public void Age() throws InterruptedException{
		WebElement webclk =this.css_selector("#item-3");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
		webclk.click();
		
		WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		addclk.click();
		
		WebElement mage =this.Min_val("#age");	
		WebElement submitclk =this.Submit_BtnClk("#submit");
		submitclk.click();
		Thread.sleep(1000);	
		String Actual_mage_clr ="rgb(40, 167, 69)";
		String Expect_mage_clr=mage.getCssValue("border-color");
		assertNotEquals(Actual_mage_clr,Expect_mage_clr);
		String act_valid_fname ="qw";
		assertEquals(act_valid_fname,mage.getAttribute("value"));
		
		WebElement max_age =this.css_selector("#age");
		max_age.click();
		max_age.clear();
		max_age.sendKeys("123");
		Thread.sleep(1000);
		String Actual_max_age_clr ="rgb(40, 167, 69)";
		String Expect_max_age_clr=max_age.getCssValue("border-color");
		assertEquals(Actual_max_age_clr,Expect_max_age_clr);
		String act_max_age ="123";
		assertEquals(act_max_age,max_age.getAttribute("value"));
		
		WebElement zero_age =this.css_selector("#age");
		zero_age.click();
		zero_age.clear();
		zero_age.sendKeys("0");
		Thread.sleep(1000);
		String Actual_zero_age_clr ="rgb(40, 167, 69)";
		String Expect_zero_age_clr=zero_age.getCssValue("border-color");
		assertEquals(Actual_zero_age_clr,Expect_zero_age_clr);
		String act_zero_age ="0";
		assertEquals(act_zero_age,zero_age.getAttribute("value"));
		
		WebElement valid_age =this.css_selector("#age");
		valid_age.click();
		valid_age.clear();
		valid_age.sendKeys("22");
		Thread.sleep(1000);
		String Expect_valid_age = valid_age.getCssValue("border-color"); 
		String Actual_valid_age = "rgb(40, 167, 69)";
		assertNotEquals("Valid value",Expect_valid_age,Actual_valid_age);
		String act_valid_age ="22";
		assertEquals(act_valid_age,valid_age.getAttribute("value"));
		
	}
		
	//-------------------------------	Salary	--------------------------------------------------- 
		@Test
		public void Salary() throws InterruptedException{
			WebElement webclk =this.css_selector("#item-3");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
			webclk.click();
			
			WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			addclk.click();
			
			WebElement msalary =this.Min_val("#salary");	
			WebElement submitclk =this.Submit_BtnClk("#submit");
			submitclk.click();
			Thread.sleep(1000);	
			String Expect_min_salary = msalary.getCssValue("border-color"); 
			String Actual_min_salary = "rgb(40, 167, 69)";
			assertNotEquals(Expect_min_salary,Actual_min_salary);
			String act_msalary ="qw";
			assertEquals(act_msalary,msalary.getAttribute("value"));
			
			WebElement min_salary =this.css_selector("#salary");
			min_salary.click();
			min_salary.clear();
			min_salary.sendKeys("1");
			Thread.sleep(1000);
			String Actual_min_salary_clr ="rgb(40, 167, 69)";
			String Expect_min_salary_clr=min_salary.getCssValue("border-color");
			assertEquals(Actual_min_salary_clr,Expect_min_salary_clr);
			String act_min_salary ="1";
			assertEquals(act_min_salary,min_salary.getAttribute("value"));
			
			WebElement max_salary =this.css_selector("#salary");
			max_salary.click();
			max_salary.clear();
			max_salary.sendKeys("12345678901");
			Thread.sleep(1000);
			String Actual_max_salary_clr ="rgb(40, 167, 69)";
			String Expect_max_salary_clr=max_salary.getCssValue("border-color");
			assertEquals(Actual_max_salary_clr,Expect_max_salary_clr);
			String act_max_salary ="1234567890";
			assertEquals(act_max_salary,max_salary.getAttribute("value"));
			
			WebElement valid_salary =this.css_selector("#salary");
			valid_salary.click();
			valid_salary.clear();
			valid_salary.sendKeys("2500000");
			Thread.sleep(1000);
			String Expect_valid_salary = valid_salary.getCssValue("border-color"); 
			String Actual_valid_salary = "rgb(40, 167, 69)";
			assertNotEquals("Valid value",Expect_valid_salary,Actual_valid_salary);
			String act_valid_salary ="2500000";
			assertEquals(act_valid_salary,valid_salary.getAttribute("value"));
			
		}
//-------------------------------	Department	--------------------------------------------------- 
		@Test
		public void Department() throws InterruptedException{
			WebElement webclk =this.css_selector("#item-3");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
			webclk.click();
			
			WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			addclk.click();
			
			WebElement mdepartment =this.Min_val("#department");
			WebElement submitclk =this.Submit_BtnClk("#submit");
			submitclk.click();
			Thread.sleep(2000);
			String Actual_mdepartment_clr ="rgb(40, 167, 69)";
			String Expect_mdepartment_clr=mdepartment.getCssValue("border-color");
			System.out.println(Expect_mdepartment_clr);
			assertEquals(Actual_mdepartment_clr,Expect_mdepartment_clr);
			String act_msalary ="qw";
			assertEquals(act_msalary,mdepartment.getAttribute("value"));
			
			
			WebElement max_department =this.Max_val("#department");
			Thread.sleep(1000);
			String Actual_max_department_clr ="rgb(40, 167, 69)";
			String Expect_max_department_clr=max_department.getCssValue("border-color");
			assertEquals(Actual_max_department_clr,Expect_max_department_clr);
			
			WebElement num_dep =this.Num_val("#department");
			Thread.sleep(1000);
			String Expect_num_dep = num_dep.getCssValue("border-color"); 
			String Actual_num_dep = "rgb(40, 167, 69)";
			assertNotEquals("You must type letters",Expect_num_dep,Actual_num_dep);
			String act_num_dep ="123456789012345678901234567890";
			assertEquals(act_num_dep,num_dep.getAttribute("value"));
			
			WebElement Spl_dep =this.Spl_char("#department");
			Thread.sleep(1000);
			String Expect_Spl_dep = Spl_dep.getCssValue("border-color"); 
			String Actual_Spl_dep = "rgb(40, 167, 69)";		
			assertNotEquals("You must type letters",Expect_Spl_dep,Actual_Spl_dep);
			String act_spl_dep ="!@#$%^&*()<>?:[]`,.,.<>/`~";
			assertEquals(act_spl_dep,Spl_dep.getAttribute("value"));
			
			WebElement blkqt_dep =this.block_quote("#department");
			Thread.sleep(1000);
			String Expect_blkqt_dep = blkqt_dep.getCssValue("border-color"); 
			String Actual_blkqt_dep = "rgb(40, 167, 69)";
			assertNotEquals("Not Accept Block Quotes",Expect_blkqt_dep,Actual_blkqt_dep);
			String act_blk_dep ="````````````````````";
			assertEquals(act_blk_dep,blkqt_dep.getAttribute("value"));
			
			WebElement empty_dep =this.EmptyField("#department");
			Thread.sleep(1000);
			String Expect_empty_dep = empty_dep.getCssValue("border-color"); 
			String Actual_empty_dep= "rgb(40, 167, 69)";
			assertNotEquals("Empty Filed",Expect_empty_dep,Actual_empty_dep);
			
			WebElement no_str_dep =this.css_selector("#department");
			no_str_dep.click();
			no_str_dep.clear();
			no_str_dep.sendKeys("Computer Science123");
			Thread.sleep(1000);
			String Expect_no_str_dep = no_str_dep.getCssValue("border-color"); 
			String Actual_no_str_dep = "rgb(40, 167, 69)";
			assertNotEquals("Valid value",Expect_no_str_dep,Actual_no_str_dep);
			String act_no_str_dep ="Computer Science123";
			assertEquals(act_no_str_dep,no_str_dep.getAttribute("value"));
			
			WebElement valid_dep =this.css_selector("#department");
			valid_dep.click();
			valid_dep.clear();
			valid_dep.sendKeys("Computer Science");
			Thread.sleep(1000);
			String Expect_valid_dep = valid_dep.getCssValue("border-color"); 
			String Actual_valid_dep = "rgb(40, 167, 69)";
			assertNotEquals("Valid value",Expect_valid_dep,Actual_valid_dep);
			String act_valid_dep ="Computer Science";
			assertEquals(act_valid_dep,valid_dep.getAttribute("value"));
		}
		
//-------------------------------	Submit Data --------------------------------------------------- 
		@Test
		public void AddData() throws InterruptedException{
			WebElement webclk =this.css_selector("#item-3");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webclk);
			webclk.click();
			
			WebElement addclk =this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			addclk.click();
			
			WebElement valid_fname1 =this.css_selector("#firstName");
			valid_fname1.click();
			valid_fname1.clear();
			valid_fname1.sendKeys("Subha");
			String act_valid_fname1 ="Subha";
			assertEquals(act_valid_fname1,valid_fname1.getAttribute("value"));
			
			WebElement valid_lname =this.css_selector("#lastName");
			valid_lname.click();
			valid_lname.clear();
			valid_lname.sendKeys("suki");
			String act_valid_lname ="suki";
			assertEquals(act_valid_lname,valid_lname.getAttribute("value"));
			
			WebElement valid_email =this.css_selector("#userEmail");
			valid_email.click();
			valid_email.clear();
			valid_email.sendKeys("Subha@gmail.com");
			String act_valid_email ="Subha@gmail.com";
			assertEquals(act_valid_email,valid_email.getAttribute("value"));
			
			WebElement valid_age =this.css_selector("#age");
			valid_age.click();
			valid_age.clear();
			valid_age.sendKeys("22");
			String act_valid_age ="22";
			assertEquals(act_valid_age,valid_age.getAttribute("value"));
			
			WebElement valid_salary =this.css_selector("#salary");
			valid_salary.click();
			valid_salary.clear();
			valid_salary.sendKeys("2500000");
			String act_valid_salary ="2500000";
			assertEquals(act_valid_salary,valid_salary.getAttribute("value"));
			
			WebElement valid_dep =this.css_selector("#department");
			valid_dep.click();
			valid_dep.clear();
			valid_dep.sendKeys("Computer Science");
			String act_valid_dep ="Computer Science";
			assertEquals(act_valid_dep,valid_dep.getAttribute("value"));
			
			WebElement submitclk1 =this.Submit_BtnClk("#submit");
			submitclk1.click();
//			Thread.sleep(5000);
			
//			WebElement tbllist =this.xpath_locator("//div[text()='Kierra']");
//			System.out.println(tbllist);
//			
//			WebElement tbllist1 =this.css_selector(".rt-tbody>div:last-child");
//			System.out.println(tbllist1);
		}
		
//-----------------------------------		Search box		--------------------------------
		@Test
		public void Searchbox() throws InterruptedException{
			
			WebElement search =this.css_selector("#searchBox");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			search.click();
			search.clear();
			search.sendKeys("a");
		}
	
	//-------------------------------		Quit				-----------------------------------------	
	@After
	public void quitfun() {
		driver.quit();
	}


}
