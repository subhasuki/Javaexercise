package ZaskSite;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverInstance {	
	WebDriver driver;
	//	- - - - - - - - - 		Set Property Define URL		- - - - - - - - 	
	public void defineUrl() {
		System.setProperty("webdriver.chrome.driver","/home/zoho/Downloads/chromedriver");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://zask.localpali.io/zask/");
	}	
	//	- - - - - - - - - 		Selectors		- - - - - - - - -	
	public WebElement selector(String selector_element) {
		WebElement selector_ele = null;
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		
		try {
			if(selector_element.contains("//")) {
//				System.out.println("XPATH");
				selector_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector_element)));
			} else {
//				System.out.println("CSS");
				selector_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector_element)));
			}
		} catch(AssertionError e){
			System.out.println(e);
		} 
//		System.out.println(selector_ele);
		return selector_ele;
	}	
	//	- - - - - - - - - 		Click Event		- - - - - - - - - 		
	public WebElement Click_evt(String clk_element) { 		
		WebElement click_method = null ;		
		try {
			click_method = this.selector(clk_element);
			click_method.click();			
		} catch(AssertionError e) {
			System.out.println(e);
		} return click_method;
	} 	
	//	- - - - - - - - - 		Wait Click event		- - - - - - - - - 	
	public WebElement wait_Click_evt(String wait_clkelement) throws InterruptedException { 				
		WebElement wait_btnsclk = null ; 
		Thread.sleep(1500);
		this.selector(wait_clkelement).click();		  
		return wait_btnsclk;
	}	
	//	- - - - - - - - - 		Clear		- - - - - - - - - 	
	public void Clear_evt(String clr_element) {		
		this.selector(clr_element).clear();
	}	
	//	- - - - - - - - - 		Sendkeys		- - - - - - - - -	
	public void send_Val(String send_element,String send_value) throws InterruptedException {
		Thread.sleep(3000);
		this.selector(send_element).click();
		this.selector(send_element).clear();
		this.selector(send_element).sendKeys(send_value);
	}	
	//	- - - - - - - - - 		Button		- - - - - - - - - - -	
	public void btn_clk(String element) {
		this.selector(element).click();
	}	
	// - - - - - - - - - 		isDisplayed		- - - - - - - - - - -	
	public boolean chk_isdisplay(String dlyelement) {		 
		return this.selector(dlyelement).isDisplayed();		
	}
	//	- - - - - - - - - 		Navigate		- - - - - - - - -	
	public void  navigate() {
		driver.navigate().back();
	}
	//	- - - - - - - - - 		Refresh		- - - - - - - - -	
	public void  refresh() {
		driver.navigate().refresh();	
    }
	//	- - - - - - - - - 		getPageSource		- - - - - - - - -
	public String pagecontent() { 
		 return driver.getPageSource();		
	}
	//- - - - - - - - -		Backspace	- - - - - - - - -
	public void backspace(String backspace_element,Keys backspace_value) {
		this.selector(backspace_element).click();
		this.selector(backspace_element).clear();
		this.selector(backspace_element).sendKeys(backspace_value);
	}
	//- - - - - - - - -		Ctrl+A	- - - - - - - - -
	public void ctrl_a(String ctrl_element,String string) {
		this.selector( ctrl_element).click();
		this.selector( ctrl_element).sendKeys(string);
	}
	//- - - - - - - - -		Ctrl+B	- - - - - - - - -
	public void ctrl_B(String ctrlB_element,String string) {
		this.selector( ctrlB_element).click();
		this.selector( ctrlB_element).sendKeys(string);
	}
	//- - - - - - - - -		Ctrl+I	- - - - - - - - -
	public void ctrl_I(String ctrlI_element,String string) {
		this.selector( ctrlI_element).click();
		this.selector( ctrlI_element).sendKeys(string);
	}
	//- - - - - - - - -		Ctrl+U	- - - - - - - - -
	public void ctrl_U(String ctrlU_element,String string) {
		this.selector( ctrlU_element).click();
		this.selector( ctrlU_element).sendKeys(string);
	}
	//	- - - - - - - - - 		Quit		- - - - - - - - -	
	public void quit_evt() {		
		driver.quit();
	}


}
