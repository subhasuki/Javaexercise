package ZaskSite;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Follow_tag {
	static webdriverInstance driver_inst = new webdriverInstance(); 
	public static void main (String args[]) throws InterruptedException {
		driver_inst.defineUrl();
		driver_inst.Click_evt("#details-button");	
		driver_inst.Click_evt("#proceed-link");
		driver_inst.wait_Click_evt("//a[@class='btn opc-text']");
		Login();
		Article_btn();
		//		follow_tag();
		igonore_tag();
		Quit();
	}
	//- - - - - - - - - - - 	Login Check		- - - - - - - -	
	public static void Login() throws InterruptedException {
		try {	
			driver_inst.send_Val("#login_id", "esakkivash.n+testt50@zohocorp.com");
			driver_inst.btn_clk("#nextbtn");
			driver_inst.send_Val("#password", "Tester@07");
			driver_inst.btn_clk("#nextbtn");	
			System.out.println("Login Successfully \n");
		} catch(AssertionError e) {
			System.out.println("Not Login \n");
		}
	} 
	//- - - - - - - - - - - 	Article button present or not  	- - - - - - - - - - - 
	public static void Article_btn() {	
		//- - - - - - - - - - - 	Article Button click		- - - - - - - -	
		try {
			driver_inst.Click_evt("//link-to[@header-route-id='Articles']");
			String art_txt = driver_inst.selector("//a[@class='active']").getText(); 
			Assert.assertEquals(art_txt,"Articles");				
			System.out.println("Check article button is active :--Pass--\n");
		} catch(AssertionError e) { 
			System.out.println("Check article button is not active :--Fail--\n"); 
		} 
	}
	//- - - - - - - - - - - 	Follow tag  	- - - - - - - - - - - 
	public static void follow_tag() throws InterruptedException {	
		//- - - - - - - - - - - 	Add tag		- - - - - - - -	
		try {
			driver_inst.Click_evt("#edit-favourite-tags");
			driver_inst.send_Val("//input[@placeholder='Add tag']","git"); 
			driver_inst.Click_evt("//div[text()='git']");
			driver_inst.Click_evt("//span[text()='Done']");
			boolean flw_tag = driver_inst.Click_evt("//zask-ui-tag-closable[@tagname='git']").isDisplayed();
			Assert.assertTrue(flw_tag);		
			Thread.sleep(2000);
			System.out.println("Tag name added :--Pass--\n");
		} catch(AssertionError e) { 
			System.out.println("Tag name not added :--Fail--\n"); 
		} 
		//- - - - - - - - - - - 	Check Duplicate item tag		- - - - - - - -	
		try {
			driver_inst.Click_evt("//input[text()='Edit']");
			driver_inst.send_Val("//input[@placeholder='Add tag']","git"); 
			boolean act_dupli = driver_inst.selector("//div[text()='git']").isDisplayed();			
			Assert.assertFalse(act_dupli);				
			System.out.println("Not show duplicate Tag name :--Pass--\n");
		} catch(AssertionError e) { 
			System.out.println("showed duplicate Tag name :--Fail--\n"); 
		} 
		//- - - - - - - - - - - 	global Search box  		- - - - - - - -	
		try {
			driver_inst.Click_evt("//a[text()='Tags']");
			WebElement git_tag = driver_inst.selector("//*[@id=\"outlet\"]/zask-container/zask-ui-header/div[1]/div/div/zask-ui-search/div[1]/input");
			git_tag.sendKeys("git");
			git_tag.sendKeys(Keys.ENTER);
			String git_txt = driver_inst.selector("//span[text()='git']").getText();
			Assert.assertEquals(git_txt, "git");
			System.out.println("Following tag added : --Pass--");
		} catch (Exception e) {
			System.out.println("Following tag not added : --Fail--");
		} 
		//- - - - - - - - - - - 	Check git tag showed in tags page 		- - - - - - - -	
		try {
			boolean following_txt = driver_inst.pagecontent().contains("Following");
			Assert.assertTrue(following_txt);
			System.out.println("Git tag showed in tags page : --Pass--");
		} catch (Exception e) { 
			System.out.println("Git tag not showed in tags page : --Fail--");
		} 
		//- - - - - - - - - - - 	Refresh page not work properly - - - - - - - -
		try {
			driver_inst.refresh();
			String Tag_URL = driver_inst.geturl();
			Assert.assertNotSame(Tag_URL, "https://zask.localpali.io/zask/ZAsk/tags?sort=Popular&page=1");
			System.out.println("Global search refresh page not work properly --Pass--");
		} catch (Exception e) {
			System.out.println("Global search refresh page  work properly --Fail--");
		}
		//- - - - - - - - - - - 	Local search box check tag 	- - - - - - - -
		try {
			Thread.sleep(2000);
			driver_inst.Click_evt("//a[text()='Tags']");
			WebElement test_txt = driver_inst.selector("//*[@id=\"search-tags\"]/div[1]/input");
			test_txt.sendKeys("test");
			test_txt.sendKeys(Keys.ENTER);
			boolean tests_txt1 = driver_inst.pagecontent().contains("test");
			Assert.assertTrue(tests_txt1);
			System.out.println("Test Content showed --Pass--");
		} catch(Exception e) {
			System.out.println("Test Content not showed --Fail--");
		}
		//- - - - - - - - - - - 	Local search box check tag link		- - - - - - - -
		try { 
			driver_inst.Click_evt("//a[text()='Tags']");
			WebElement pali_txt = driver_inst.selector("//*[@id=\"search-tags\"]/div[1]/input");
			pali_txt.sendKeys("pali");
			driver_inst.Click_evt("//a[text()='pali']");
			String local_serach = driver_inst.geturl();
			Assert.assertNotSame(local_serach, "https://zask.localpali.io/zask/ZAsk/tags?sort=Popular&page=1");
			System.out.println("Local Search work not properly --Pass-- ");
		} catch (Exception e) { 
			System.out.println("Local Search work  properly --Fail--");
		}
		//- - - - - - - - - - - 	Follow to Following	- - - - - - - -
		try {
			driver_inst.Click_evt("//a[text()='Tags']");
			driver_inst.Click_evt("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[2]/zask-tags/div[2]/zask-ui-card[3]/div/div/zask-ui-button");
			Thread.sleep(1000);
			String unfollow_txt = driver_inst.selector("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[2]/zask-tags/div[2]/zask-ui-card[3]/div/div/zask-ui-button").getAttribute("class");
			System.out.println(unfollow_txt);
			Assert.assertEquals(unfollow_txt, "follow-ignore-tag unfollow");
			System.out.println("zask tag Following --Pass--");			
		} catch(Exception e) {
			System.out.println("zask tag not Following --Fail--");			
		}
		//- - - - - - - - - - - 	Following tag check in article page		- - - - - - - -
		try {
			driver_inst.Click_evt("//a[text()='Articles']");
			Thread.sleep(4000);
			String zask_txt = driver_inst.Click_evt("//span[text()='zask']").getText();
			System.out.println(zask_txt);
			Assert.assertEquals(zask_txt, "zask");
			System.out.println("zask tag present in Follow tag --Pass--");			
		} catch(Exception e) {
			System.out.println("zask tag not present in Follow tag --Fail--");			
		}
		//- - - - - - - - - - - 	Check filter following tags 		- - - - - - - -
		try {
			driver_inst.Click_evt("//a[text()='Tags']");
			driver_inst.Click_evt("//span[text()='Filters']");
			driver_inst.Click_evt("//span[text()='STATUS']");
			driver_inst.Click_evt("//span[text()='Following']");
			driver_inst.Click_evt("//button[text()='Apply']");
			String follow_tag = driver_inst.selector("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[2]/zask-tags/div[2]/zask-ui-card[2]/div/div/zask-ui-button").getAttribute("class");
			System.out.println(follow_tag);
			Assert.assertEquals(follow_tag,"follow-ignore-tag unfollow");
			System.out.println("Only showed following tags --Pass--");
		} catch (Exception e) {
			System.out.println("showed follow tags also --Fail--");			
		}
		//- - - - - - - - - - - 	Next Page 		- - - - - - - -
		try {
			driver_inst.Click_evt("//a[text()='Tags']");
			driver_inst.Click_evt("#tags-next-page");
			String nxt_url = driver_inst.geturl();
			Assert.assertEquals(nxt_url, "https://zask.localpali.io/zask/tags?sort=Popular&page=2&quesRangeFrom=&quesRangeTo=&administeredTag=&name=");
			System.out.println("Tags go to next page --Pass--");
		} catch (Exception e) {
			System.out.println("Tags did not go next page --Fail--");
		}
		//- - - - - - - - - - - 	Previous Page 		- - - - - - - -
		try {
			driver_inst.Click_evt("#tags-prev-page");
			String prevw_url = driver_inst.geturl();
			Assert.assertEquals(prevw_url, "https://zask.localpali.io/zask/tags?sort=Popular&page=1&quesRangeFrom=&quesRangeTo=&administeredTag=&name=");
			System.out.println("Tags go to previews page --Pass--");
		} catch (Exception e) {
			System.out.println("Tags did not go previews page --Fail--");
		}
	}
	//- - - - - - - - - - - 	Ignore tag  	- - - - - - - - - - - 
	public static void igonore_tag() throws InterruptedException {
		//- - - - - - - - - - - 	follow tag change to ignore tag		- - - - - - - -	
		try { 
			driver_inst.Click_evt("//a[text()='Articles']");
			driver_inst.Click_evt("#edit-ignored-tags");
			Thread.sleep(1000);
			driver_inst.send_Val("#ignored-tags-container > zask-ui-tags-multi-selector > div > div.input-container > input", "git");
			Thread.sleep(1000);
			driver_inst.Click_evt("//div[text()='git']");
			String popup = driver_inst.selector("#modal-desc").getText();
			System.out.println(popup);
			Assert.assertEquals(popup, "This tag will be removed from the Follow tags list.\n" + 
					"Are you sure you want to add this tag?");
			System.out.println("Ignore a following tag --Pass-- ");
			if (popup.equals("This tag will be removed from the Follow tags list.\n" + 
					"Are you sure you want to add this tag?")) {
				driver_inst.Click_evt("#modal-btn");
				System.out.println("It is  a following tag --Pass--");
			} else {
				System.out.println("It is not a following tag --Fail--");
			}

		} catch(Exception e) {
			System.out.println("Not ignore a following tag --Fail-- ");
		}
		try {
			String flw_tag = driver_inst.Click_evt("//zask-ui-tag-closable[@tagname='git']").getAttribute("tagname");
			Assert.assertEquals(flw_tag,"git");		
			System.out.println("Igonre tag name added :--Pass--\n"); 
		} catch(Exception e) {
			System.out.println("Ignore tag name not added :--Fail--\n"); 
		}
		try {
			driver_inst.Click_evt("//a[text()='Tags']");
			WebElement flw_btn = driver_inst.Click_evt("span.followingTag");
			System.out.println(flw_btn);
			Thread.sleep(2000);
			String ignore_flw = driver_inst.selector("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[2]/zask-tags/div[2]/zask-ui-card[1]/div/div/zask-ui-button").getAttribute("class");
			Assert.assertEquals(ignore_flw , "follow-ignore-tag follow");
			System.out.println("Following to unfollow change: --Pass--");
		} catch (Exception e) {
			System.out.println("Following to unfollow not change: --Fail--");
		}
		try {
			driver_inst.Click_evt("//a[text()='Articles']");
			boolean act_pali = driver_inst.pagecontent().contains("span[@tagname='pali']");
			System.out.println(act_pali);
			Assert.assertFalse(act_pali);
			System.out.println("Pali tag is unfollowed --Pass--");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			driver_inst.Click_evt("//a[text()='Tags']");
			driver_inst.Click_evt("//span[text()='Filters']");
			driver_inst.Click_evt("//span[text()='STATUS']");
			driver_inst.Click_evt("//span[text()='Ignoring']");
			driver_inst.Click_evt("//button[text()='Apply']");
			String act_git = driver_inst.selector("//span[text()='git']").getText();
			Assert.assertEquals(act_git, "git");
			System.out.println("Ignoring java tag present --Pass--");
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			String act_search = driver_inst.selector("//span[text()='search']").getText();
			Assert.assertEquals(act_search, "search");
			System.out.println("Ignoring search tag present --Pass--");
		} catch (Exception e) {
			System.out.println(e);
		}
		//- - - - - - - - - - - 	follow tag change to ignore tag		- - - - - - - -	
		try { 
			driver_inst.Click_evt("//a[text()='Articles']");
			driver_inst.Click_evt("#edit-favourite-tags");
			driver_inst.send_Val("//input[@placeholder='Add tag']","git"); 
			driver_inst.Click_evt("//div[text()='git']");
			String popup = driver_inst.selector("#modal-desc").getText();
			System.out.println(popup);
			Assert.assertEquals(popup, "This tag will be removed from the Ignore tags list.\n" + 
					"Are you sure you want to add this tag?");
			System.out.println("Ignore will be following  --Pass-- ");
			if (popup.equals("This tag will be removed from the Ignore tags list.\n" + 
					"Are you sure you want to add this tag?")) {
				driver_inst.Click_evt("#modal-btn");
				System.out.println("It is a ignoreing tag --Pass--");
			} else {
				System.out.println("It is not a ignoreing tag --Fail--");
			}
		} catch(Exception e) {
			System.out.println("Not Ignore will be following   --Fail-- ");
		}
	}
	//- - - - - - - - - - - 	Quit		- - - - - - - -	
	public static void Quit() throws InterruptedException {
		driver_inst.Click_evt("div > .user-profile");
		driver_inst.wait_Click_evt("//button[text()='Sign Out']");
		driver_inst.quit_evt();
	}
}
