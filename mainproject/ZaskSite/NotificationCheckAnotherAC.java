package ZaskSite;

import org.openqa.selenium.WebElement;

import junit.framework.Assert;

class NotificationCheckAnotherAC {
	static webdriverInstance driver_inst = new webdriverInstance(); 
	public static void main (String args[]) throws InterruptedException {
		driver_inst.defineUrl();
		driver_inst.Click_evt("#details-button");	
		driver_inst.Click_evt("#proceed-link");
		driver_inst.wait_Click_evt("//a[@class='btn opc-text']");
		Login0();
		questionlike();
		Quit();
		Login50();
		All_Notification();
		Notifi_check();
		Quit();
		Login0();
		remove();
		Quit();
		Login50();
		removeanscheck();
	}
	//- - - - - - - - - - - 	Login Check		- - - - - - - -	
	public static void Login0() throws InterruptedException {
		try {	
			driver_inst.send_Val("#login_id", "xxxxxxxxx@gmail.com");
			driver_inst.btn_clk("#nextbtn");
			driver_inst.send_Val("#password", "********");
			driver_inst.btn_clk("#nextbtn");	
			System.out.println("0 account Login Successfully \n");
		} catch(AssertionError e) {
			System.out.println("Not Login \n");
		}
	}
	public static void questionlike() throws InterruptedException {
		WebElement btn = driver_inst.Click_evt("//a[@href=\"/zask/questions/4874200069\"]");
		Thread.sleep(2000);
		//		((JavascriptExecutor)driver_inst).executeScript("arguments[0].scrollIntoView(true);", btn);
		driver_inst.Click_evt("//*[@id=\"vote-4874200069\"]/div[1]");
		driver_inst.Click_evt("//*[@id=\"vote-4874200069\"]/div[3]/div");
		driver_inst.Click_evt("//*[@id=\"4874200069\"]/div[2]/div[1]/div[2]/div/div/span[2]");
		driver_inst.send_Val("#add-question-edit-summary", "Testing purpose");
		Thread.sleep(2000);
		driver_inst.Click_evt("#add-question-submit");
		driver_inst.Click_evt("//span[text()='Add Comment']");
		driver_inst.send_Val("//*[@id=\"comment-box-4874200069\"]/div[1]/textarea", "Cross-site scripting works by manipulating a vulnerable web site so that it returns malicious JavaScript to users. ");
		Thread.sleep(2000);
		driver_inst.Click_evt("//*[@id=\"comment-box-4874200069\"]/div[1]/div");
		driver_inst.send_Val("//*[@id=\"editor-outlet\"]/div[1]/p", "In addition, if the application performs any validation or other processing on the submitted data before it is reflected, this will generally affect what kind of XSS payload is needed.");
		Thread.sleep(2000);
		driver_inst.Click_evt("#add-answer-submit");
	}
	//- - - - - - - - - - - 	Quit		- - - - - - - -	
	public static void Quit() throws InterruptedException {
		driver_inst.Click_evt("div > .user-profile");
		driver_inst.wait_Click_evt("//button[text()='Sign Out']");
		//		driver_inst.quit_evt();
	}
	//- - - - - - - - - - - 	Login Check		- - - - - - - -	
	public static void Login50() throws InterruptedException {
		try {	
			driver_inst.refresh();
			driver_inst.wait_Click_evt("//a[@class='btn opc-text']");
			driver_inst.send_Val("#login_id", "xxxxxxxxx@gmail.com");
			driver_inst.btn_clk("#nextbtn");
			driver_inst.send_Val("#password", "************");
			driver_inst.btn_clk("#nextbtn");	
			System.out.println("50 account Login Successfully \n");
		} catch(AssertionError e) {
			System.out.println("Not Login \n");
		}
	}

	//	Notifications
	public static void All_Notification() {
		try {
			driver_inst.Click_evt("//span[@lt-prop-title='Notifications']");
			driver_inst.Click_evt("//span[text()='All Notifications']");
			String act_notifi_url = driver_inst.geturl();
			System.out.println(act_notifi_url);
			Assert.assertEquals(act_notifi_url, "https://zask.localpali.io/zask/notifications?index=1&filter=All");
			System.out.println("Notification path link  --Pass--");
		} catch (Exception e) {
			System.out.println("Notification path link --Fail--");
		}
	}

	public static void Notifi_check() {
		//		vote like check
		try {
			String vote = driver_inst.selector("//a[@href=\"/zask/questions/4874200069\"]/div/span/span[2]").getText();
			System.out.println(vote);
			Assert.assertEquals(vote , "Vote ");
			System.out.println("Question like added --Pass--");
		} catch (Exception e) {
			System.out.println("Question like not added --Fail--");
		}
		//		answer  check
		try {
			String answer = driver_inst.selector("//a[@href=\"/zask/questions/4874200069?answer=5455436527&notificationID=28110\"]/div/span/span[2]").getText();
			System.out.println(answer);
			Assert.assertEquals(answer , "Answer ");
			System.out.println("Question answer added --Pass--");
		} catch (Exception e) {
			System.out.println("Question answer not added --Fail--");
		}
		//		answer email check
		try {
			String answeremail = driver_inst.selector("//a[@href=\"/zask/questions/4874200069?answer=5455436527&notificationID=28110\"]/p").getText();
			System.out.println(answeremail);
			Assert.assertEquals(answeremail , "easkkivash.n+testt0 has answered your question: how to Provide details Keep it simple ?");
			System.out.println("Question answer with email-id added --Pass--");
		} catch (Exception e) {
			System.out.println("Question answer with email-id not added --Fail--");
		}
		//		comment  check
		try {
			String comment = driver_inst.selector("//a[@href=\"/zask/questions/4874200069?comment=6357125945&notificationID=28109\"]/div/span/span[2]").getText();
			System.out.println(comment);
			Assert.assertEquals(comment , "Comment ");
			System.out.println("Question comment added --Pass--");
		} catch (Exception e) {
			System.out.println("Question comment not added --Fail--");
		}
		//		comment mail  check
		try {
			String comment = driver_inst.selector("//a[@href=\"/zask/questions/4874200069?comment=6357125945&notificationID=28109\"]/p").getText();
			System.out.println(comment);
			Assert.assertEquals(comment , "easkkivash.n+testt0 has commented on your question: how to Provide details Keep it simple ?");
			System.out.println("Question comment with mail-id added --Pass--");
		} catch (Exception e) {
			System.out.println("Question comment with mail-id not added --Fail--");
		}
		//		Favorite   check
		try {
			String fav = driver_inst.selector("//a[@href=\"/zask/questions/4874200069?notificationID=28107\"]/div/span/span[2]").getText();
			System.out.println(fav);
			Assert.assertEquals(fav , "Favourite ");
			System.out.println("Question Favorite added --Pass--");
		} catch (Exception e) {
			System.out.println("Question Favorite not added --Fail--");
		} 
		//				Favorite  mail  check
		try {
			String favmail = driver_inst.selector("//a[@href=\"/zask/questions/4874200069?notificationID=28107\"]/p").getText();
			System.out.println(favmail);
			Assert.assertEquals(favmail , "Your question: how to Provide details Keep it simple ? has been marked favourite by easkkivash.n+testt0.");
			System.out.println("Question Favorite with mail-id added --Pass--");
		} catch (Exception e) {
			System.out.println("Question Favorite with mail-id not added --Fail--");
		}
		//		Edit pending  check
		try {
			String pendingedit = driver_inst.selector("//a[@href=\"/zask/questions/4874200069/pending?notificationID=28084\"]/div/span/span[2]").getText();
			System.out.println(pendingedit);
			Assert.assertEquals(pendingedit , "Pending Edit ");
			System.out.println("Question Edit pending added --Pass--");
		} catch (Exception e) {
			System.out.println("Question Edit pending not added --Fail--");
		}
		//		Edit pending mail check
		try {
			String pendingedit_mail = driver_inst.selector("//a[@href=\"/zask/questions/4874200069/pending?notificationID=28084\"]/p").getText();
			System.out.println(pendingedit_mail);
			Assert.assertEquals(pendingedit_mail , "easkkivash.n+testt0 has edited your question: how to Provide details Keep it simple ?");
			System.out.println("Question Edit pending with mail-id added --Pass--");
		} catch (Exception e) {
			System.out.println("Question Edit pending with mail-id not added --Fail--");
		}
	}

	public static void remove() throws InterruptedException {
		WebElement btn = driver_inst.Click_evt("//a[@href=\"/zask/questions/4874200069\"]");
		//		remove comment
		driver_inst.Click_evt("//*[@id=\"3118421947\"]/div[2]/div[3]/span");
		driver_inst.Click_evt("//*[@id=\"3118421947\"]/div[2]/div[3]/zask-ui-question-moderation/div");
		//		remove post
		driver_inst.Click_evt("//*[@id=\"6433763974\"]/div[2]/div[3]/span");
		driver_inst.Click_evt("//*[@id=\"6433763974\"]/div[2]/div[3]/zask-ui-question-moderation/div");
	}
	public static void removeanscheck() throws InterruptedException {
		try {
			boolean cmtremove = driver_inst.pagecontent().contains("Comment [Removed]");
			System.out.println(cmtremove);
			Assert.assertTrue(cmtremove);
			System.out.println("Comment is removed --Pass--");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			boolean cmtremove = driver_inst.pagecontent().contains("Answer [Removed]");
			System.out.println(cmtremove);
			Assert.assertTrue(cmtremove);
			System.out.println("Answer is removed --Pass--");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
} 
