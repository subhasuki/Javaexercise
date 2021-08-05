package mainproject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailAutoTest {
	
	
	public static void main(String args[]) throws InterruptedException {
		
//		-------------------- 	Connect  WebDriver  ---------------------------
		
		System.setProperty("webdriver.chrome.driver","/home/zoho/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver= new ChromeDriver();

//		System.setProperty("webdriver.gecko.driver","/home/zoho/Downloads/geckodriver");
//
//		WebDriver driver= new FirefoxDriver();
		
		String rose = "https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Drm%26ogbl&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		driver.get(rose);
		
//	--------------------	Empty Check   -------------------------------------
			
		WebElement nxtbtn = driver.findElement(By.cssSelector("#identifierNext"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			
		nxtbtn.click();
			
		String ActualError = "Enter an email or phone number";
		String ExpectedError = driver.findElement(By.xpath("//div[@aria-atomic='true']/div")).getText();
			//System.out.println(ExpectedData);

		try {
			Assert.assertEquals(ActualError, ExpectedError);
			System.out.println(ActualError  +  " ---Pass---");
		} catch (AssertionError e) {
			System.out.println(ActualError  +  " ---Fail---");
		} finally {
			driver.navigate().to("https://accounts.google.com/");
		}
		
//		--------------------	Email Field Invalid Check   -------------------------------------
		
		WebElement username = driver.findElement(By.cssSelector("input#identifierId"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		username.click();
		username.clear();
		username.sendKeys("subha");
		
		nxtbtn = driver.findElement(By.cssSelector("#identifierNext"));
		nxtbtn.click();
		
		String ActualEmailError = "Couldn't find your Google Account";
		String ExpectedEmailError = driver.findElement(By.cssSelector(".o6cuMc")).getText();
		System.out.println(ExpectedEmailError);

		try {
			Assert.assertEquals(ActualEmailError, ExpectedEmailError);
			System.out.println("Couldn't find your Google Account ---Pass---");
		} catch (AssertionError e) {
			System.out.println("Couldn't find your Google Account ---Fail---");
		}	
		
		
//	--------------------		Email Field Valid data 		------------------------------------
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		username.click();
		username.clear();
		username.sendKeys("subhadev3696");
		
		nxtbtn = driver.findElement(By.cssSelector("#identifierNext"));
		nxtbtn.click();

		
		
		Thread.sleep(2000);
		
		
//		driver.quit();
		
	}
}

