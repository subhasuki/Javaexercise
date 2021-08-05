package mainproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainProject {
	
	public static void main(String args[]) {

//		System.setProperty("webdriver.chrome.driver",  "/home/zoho/Downloads/chromedriver");
		System.setProperty("webdriver.gecko.driver","/home/zoho/Downloads/geckodriver");
		
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new FirefoxDriver();
		
		String rose = "https://www.guru99.com/java-variables.html#5";
		driver.get(rose);
	}
}