import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverTest{

    public static WebDriver driver;

	public void defineUrl() {
		System.setProperty("webdriver.chrome.driver",  "/home/zoho/Downloads/chromedriver");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/accordion/");
	}
}
