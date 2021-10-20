package ZaskSite;

import junit.framework.Assert;

class notification {
	static webdriverInstance driver_inst = new webdriverInstance(); 
	public static void main (String args[]) throws InterruptedException {
		driver_inst.defineUrl();
		driver_inst.Click_evt("#details-button");	
		driver_inst.Click_evt("#proceed-link");
		driver_inst.wait_Click_evt("//a[@class='btn opc-text']");
		Login();
		All_Notification();
		CkechBox_filter();
		Notifi_count();
		Notifi_filter();
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
	//- - - - - - - - - - - 	Quit		- - - - - - - -	
	public static void Quit() throws InterruptedException {
		driver_inst.Click_evt("div > .user-profile");
		driver_inst.wait_Click_evt("//button[text()='Sign Out']");
		driver_inst.quit_evt();
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
	//	CheckBox Filter 
	public static void CkechBox_filter() {
		try {
			driver_inst.Click_evt("#notification-dropdown-container");
			driver_inst.Click_evt("//div[text()='All']");
			driver_inst.Click_evt("#notification-dropdown-container");
			driver_inst.Click_evt("//div[text()='None']");
			driver_inst.Click_evt("#checkbox-27390");
			driver_inst.Click_evt("//span[text()='Mark as unread']");
			Thread.sleep(1000);
			boolean Act_unread = driver_inst.pagecontent().contains("1 Notification(s) marked unread successfully.");
			Assert.assertTrue(Act_unread);
			System.out.println("1 Notification(s) marked unread successfully. --Pass--");
		} catch(Exception e) {
			System.out.println("1 Notification(s) marked unread successfully. --Fail--");
		}
		//		Check Unread questions background color
		try {
			driver_inst.Click_evt("#notification-dropdown-container");
			driver_inst.Click_evt("//div[text()='Read']");
			String act_unread_clr = driver_inst.selector(".unread").getCssValue("background-color");
			System.out.println(act_unread_clr);
			Assert.assertEquals(act_unread_clr, "rgba(246, 246, 246, 1)");
			System.out.println("Read questions background color --Pass--");
		} 
		catch(Exception e) {		
			System.out.println("Read questions background color --Fail--");
		}
		//		Check Unread questions class name 
		try {
			boolean Act_read_cont = driver_inst.pagecontent().contains("unread");
			Assert.assertTrue(Act_read_cont);
			System.out.println("Selected only read questions --Pass--");
		} catch(Exception e) {		
			System.out.println("Select unread questions also --Fail--");
		}
		//		Check unread questions background color
		try {
			driver_inst.Click_evt("#notification-dropdown-container");
			driver_inst.Click_evt("//div[text()='Unread']");
			String act_unread_clr = driver_inst.selector(".unread").getCssValue("background-color");
			System.out.println(act_unread_clr);
			Assert.assertEquals(act_unread_clr, "rgba(246, 246, 246, 1)");
			System.out.println("Unread questions background color --Pass--");
		} 
		catch(Exception e) {		
			System.out.println("Unread questions background color --Fail--");
		}
		//		Check unread questions class name 
		try {
			boolean Act_read_cont = driver_inst.pagecontent().contains("unread");
			Assert.assertTrue(Act_read_cont);
			System.out.println("Selected only unread questions --Pass--");
		} catch(Exception e) {		
			System.out.println("Select read questions also --Fail--");
		}
		try {
			driver_inst.Click_evt("//*[@id=\"notification-dropdown-container\"]");
			driver_inst.Click_evt("//div[text()='None']");
			driver_inst.Click_evt("//*[@id=\"checkbox-27390\"]");
			driver_inst.Click_evt("//*[@id=\"notification-options-container\"]/div[1]/div[3]/div[1]/span[2]");
			Thread.sleep(1000);
			boolean Act_unread = driver_inst.pagecontent().contains("1 Notification(s) marked read successfully.");
			System.out.println(Act_unread);
			Assert.assertTrue(Act_unread);
			System.out.println("1 Notification(s) marked read successfully.. --Pass--");
		} catch(Exception e) {
			System.out.println("1 Notification(s) marked read not successfully.. --Fail--");
		}
		try {
			String act_summary_qus_cls =	driver_inst.selector("#notification-summary-container-23764").getAttribute("class");
			driver_inst.Click_evt("#notification-summary-container-23764");
			driver_inst.navigate();
			String expt_summary_qus_cls =	driver_inst.selector("#notification-summary-container-23764").getAttribute("class");
			Assert.assertNotSame(act_summary_qus_cls, expt_summary_qus_cls);
			System.out.println("Change unread to read question --Pass--");
		} catch (Exception e) {
			System.out.println("Change unread to read question --Fail--");
		}
	}
	//	Notification Count Error 
	public static void Notifi_count() {
		try {
			String act_count = driver_inst.selector("#notification-count").getText();
			System.out.println(act_count);
			driver_inst.Click_evt("#checkbox-22822");
			driver_inst.Click_evt("#notification-options-container > div:nth-child(1) > div:nth-child(3) > div.notificationMarkReadButton.sp12 > span.notification-action-text");
			String act_count1 = driver_inst.selector("#notification-count").getText();
			System.out.println(act_count1);
			Assert.assertNotSame(act_count, act_count1);
			System.out.println("Add notification-count successfully --Pass--");
		} catch (Exception e) {
			System.out.println("Not add notification-count --Fail--");
		}
	}
	//Notification drop-down filter
	public static void Notifi_filter() {
		//		Unread
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(2)");
			String unread_clr = driver_inst.selector(".unread").getCssValue("background-color");
			System.out.println(unread_clr);
			Assert.assertEquals(unread_clr, "rgba(246, 246, 246, 1)");
			System.out.println("Showed Unread question --Pass--");
		} catch (Exception e) {
			System.out.println("Not showed unread question --Fail--");
		}
		//		Read
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(3)");
			String unread_clr = driver_inst.selector(".notification-summary-container").getCssValue("background-color");
			System.out.println(unread_clr);
			Assert.assertEquals(unread_clr, "rgba(246, 246, 246, 1)");
			System.out.println("Showed read question --Pass--");
		} catch(Exception e) {
			System.out.println("Not Showed read question --Fail--");
		}
		//		Question
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(4)");
			String question = driver_inst.selector("//*[@id=\"notification-summary-container-27390\"]/div[2]/link-to/a/div/span[1]/span[2]").getText();
			System.out.println(question);
			Assert.assertEquals(question,"Question" );
			System.out.println("Showed question list --Pass--");
		} catch (Exception e) {
			System.out.println("Not Showed question list--Fail--");
		}
		//		Article
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(5)");
			String article = driver_inst.selector("//*[@id='notification-summary-container-23764']/div[2]/link-to/a/div/span[1]/span[2]").getText();
			System.out.println(article);
			Assert.assertEquals(article,"Article " );
			System.out.println("Showed Article  list --Pass--");
		} catch (Exception e) {
			System.out.println("Not Showed Article  list--Fail--");
		}
		//		Answer
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(6)");
			String answer = driver_inst.selector("//*[@id=\"notification-summary-container-21931\"]/div[2]/link-to/a/div/span[1]/span[2]").getText();
			System.out.println(answer);
			Assert.assertEquals(answer,"Answer " );
			System.out.println("Showed Answer  list --Pass--");
		} catch (Exception e) {
			System.out.println("Not Showed Answer  list--Fail--");
		}
		//		Comment
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(7)");
			String Comment = driver_inst.selector("//*[@id=\"notification-summary-container-21935\"]/div[2]/link-to/a/div/span[1]/span[2]").getText();
			System.out.println(Comment);
			Assert.assertEquals(Comment,"Comment " );
			System.out.println("Showed Comment  list --Pass--");
		} catch (Exception e) {
			System.out.println("Not Showed Comment  list--Fail--");
		}
//		Edit
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(8)");
			String Edit = driver_inst.selector("//*[@id=\"notification-summary-container-21938\"]/div[2]/link-to/a/div/span[1]/span[2]").getText();
			System.out.println(Edit);
			Assert.assertEquals(Edit,"Pending Edit " );
			System.out.println("Showed Edit  list --Pass--");
		} catch (Exception e) {
			System.out.println("Not Showed Edit  list--Fail--");
		}
//		Review
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(9)");
			String Review = driver_inst.selector("//*[@id=\"notification-summary-container-21681\"]/div[2]/link-to/a/div/span[1]/span[2]").getText();
			System.out.println(Review);
			Assert.assertEquals(Review,"Article Review " );
			System.out.println("Showed Review  list --Pass--");
		} catch (Exception e) {
			System.out.println("Not Showed Review  list--Fail--");
		}
//		Vote
		try {
			driver_inst.Click_evt("//*[@id='zask-filter-notification-dropdown']");
			driver_inst.Click_evt("body > lyte-drop-box > lyte-drop-body > lyte-drop-item:nth-child(10)");
			String Vote = driver_inst.selector("//*[@id=\"notification-summary-container-20959\"]/div[2]/link-to/a/div/span[1]/span[2]").getText();
			System.out.println(Vote);
			Assert.assertEquals(Vote,"Vote " );
			System.out.println("Showed Vote  list --Pass--");
		} catch (Exception e) {
			System.out.println("Not Showed Vote  list--Fail--");
		}
////		Delete Error
//		try {
//			Thread.sleep(3400);
//			String test = driver_inst.selector("#checkbox-22765").getTagName();
//			System.out.println(test);
//			driver_inst.Click_evt("//span[text()='Delete']");
//			boolean delete = driver_inst.pagecontent().contains("notification-summary-container-27390");
//			System.out.println(delete);
//			Assert.assertTrue(delete);
//			System.out.println("Question is deleted --Pass--");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
	try {
		driver_inst.Click_evt("//span[@lt-prop-title='Notifications']");
		String notifi_clr = driver_inst.selector(".notification-container").getCssValue("background-color");
		System.out.println(notifi_clr);
		Assert.assertEquals(notifi_clr, "rgba(255, 255, 255, 1)");
		System.out.println("Unread notification background color present --Pass--");
	} catch (Exception e) {
		System.out.println("Unread notification background color not present --Fail--");
	}
	}
} 
//#zask-filter-notification-dropdown
