package ZaskSite;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuestionPostLoop {
	public static WebDriver driver;
	public WebElement xpath_locator(String ele) {

		WebElement path= null;
		try{
			path = driver.findElement(By.xpath(ele));
			if(path.isEnabled()) {
				return path;
			}
			else {
				System.out.println("\nElement is not enabled");
			}

		}
		catch(AssertionError e) {
			System.out.println(e);
		}

		return path;
	}

	public WebElement css_locator(String ele) {

		WebElement path= null;
		try{
			path = driver.findElement(By.cssSelector(ele));
			if(path.isEnabled()) {
				return path;
			}
			else {
				System.out.println("\nElement is not enabled");
			}
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		return path;
	}


	@BeforeClass
	public static void url() {

		System.setProperty("webdriver.chrome.driver","/home/zoho/Downloads/chromedriver");
		driver = new ChromeDriver();
		//		System.setProperty("webdriver.gecko.driver", "/home/zoho/Downloads/geckodriver");
		//		WebDriver driver = new  FirefoxDriver();		
		//		driver.manage().window().setSize(new Dimension(600, 720));
		driver.manage().window().maximize();

		String link = "https://zask.localpali.io/zask/";
		driver.get(link);
	} 
	@Test 
	public void login() throws InterruptedException {
		WebElement url1 = this.css_locator("#details-button");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		url1.click();
		WebElement url2 = this.css_locator("#proceed-link");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		url2.click();
		WebElement log1 = this.xpath_locator("//a[@class='btn opc-text']");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		log1.click();
		WebElement log2 = this.css_locator("#login_id");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		log2.click();
		log2.clear();
		log2.sendKeys("esakkivash.n@zohotest.com");
		WebElement nxt = this.css_locator("#nextbtn");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		nxt.click();
		WebElement log3 = this.css_locator("#password");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		log3.click();
		log3.clear();
		log3.sendKeys("Tester@07");
		nxt.click();
		Thread.sleep(2000);
	}
	
	@Test
	public void PostQus() throws InterruptedException {
		
	
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement ques = this.css_locator(".ask-question-container>zask-ui-button");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques.click();
		Thread.sleep(1000);
		
		for(int i=0; i<3; i++) {
			WebElement tit1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
			tit1.clear();
			tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.clear();
			ques1.sendKeys("12345678901234123");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			Thread.sleep(1000);
			WebElement tit2 = this.css_locator("#input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
			tit2.click();
			tit2.clear();
			tit2.sendKeys("test");
			Thread.sleep(1500);
			tit2.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			WebElement pst = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			pst.click();
			Thread.sleep(1000);
			WebElement no1 = this.xpath_locator("//*[@id=\"modal-btn\"]");
			Thread.sleep(1000);
			no1.click();
			Thread.sleep(5000);
			driver.navigate().back();
		}
	}
	@Test
	public void logout() throws InterruptedException {
		WebElement cld = this.css_locator(".user-profile-window");
		cld.click();
		Thread.sleep(1000);
		WebElement cld1 = this.css_locator(".sign-out-button");
		cld1.click();
	}

	@AfterAll

	public void end_clse() {
		driver.quit();
	}

}
