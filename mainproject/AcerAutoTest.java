package mainproject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AcerAutoTest {
	
	
	public static void main(String args[]) throws InterruptedException {
		
//		-------------------- 	Connect  WebDriver  ---------------------------
		
		System.setProperty("webdriver.chrome.driver","/home/zoho/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver= new ChromeDriver(options);	

		String rose = "https://account.acer.com/sso/signin";
		driver.get(rose);
		
//		--------------------	Alert Cookies Check   -------------------------------------
		
			WebElement nxtbtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
//			System.out.println(nxtbtn.getTagName());
				
			Thread.sleep(2000);
			nxtbtn.click();
			
//			--------------------	Input Field Empty Check   -------------------------------------
			
			WebElement loginbtn = driver.findElement(By.xpath("//input[@value='Log In']"));
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			
			loginbtn.click();
			
			String ActualEmptyError = "This is a mandatory field.";
			String ExpectedEmptyError = driver.findElement(By.cssSelector(".fieldMand")).getText();
//			System.out.println(ExpectedEmptyError);
			
			try {
				Assert.assertEquals(ActualEmptyError,ExpectedEmptyError);
				System.out.println(ActualEmptyError + "  ---Pass--- ");
			}catch(AssertionError e){
				System.out.println(ExpectedEmptyError + "  ---Fail--- ");
			}finally {
				driver.navigate().to("https://account.acer.com/");
			}
			
//			--------------------	Input Field Empty Check   -------------------------------------
			
			
			WebElement emailinput = driver.findElement(By.xpath("//input[@placeholder='Email']"));
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			
			loginbtn.click();
			
			String ActualEmptyEmail = "This is a mandatory field.";
			String ExpectedEmptyEmail  = driver.findElement(By.cssSelector(".fieldMand")).getText();
//			System.out.println(ExpectedEmptyEmail);
			
			try {
				Assert.assertEquals(ActualEmptyEmail,ExpectedEmptyEmail);
				System.out.println("Email field Empty"+ActualEmptyEmail + "  ---Pass--- ");
			}catch(AssertionError e){
				System.out.println(ExpectedEmptyEmail + "  ---Fail--- ");
			}finally {
				driver.navigate().to("https://account.acer.com/");
			}
			
			driver.quit();
			
	
			
			
			
	}

}
