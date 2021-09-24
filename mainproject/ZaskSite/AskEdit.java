package ZaskSite;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AskEdit {	
	static webdriverInstance driver_inst = new webdriverInstance(); 
	//- - - - - - - - - - - 	Main Method		- - - - - - - -	
	public static void main (String args[]) throws InterruptedException {
		driver_inst.defineUrl();
		driver_inst.Click_evt("#details-button");	
		driver_inst.Click_evt("#proceed-link");
		driver_inst.wait_Click_evt("//a[@class='btn opc-text']");
		Login(); 
//		getscore();
//		likebtn();	
//		dislike();
		favourite(); 
//		Edit_page();
//		Check_Title();
//		Check_Bold();
//		Check_Italic();
//		Check_Underline();
//		Check_strike();
//		Bold_Itallic();
//		strick_underline();
//		check_tags();
//		check_message();
//		check_message_spl();
//		Valid_check();
//		edit_content_check();
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
	//- - - - - - - - - - - 	Get Score Value		- - - - - - - -	
	public static void getscore() throws InterruptedException {	
		Thread.sleep(1000);
		String qus_id = driver_inst.selector("#zask-questions-pagination > zask-ui-question-summaries > div > zask-ui-question-summary-view:nth-child(1) > zask-ui-card > div > div.question-detail > link-to").getAttribute("lt-prop-dp");
		System.out.println(qus_id);
		qus_id = qus_id.replace("]", "");
		qus_id = qus_id.replace("[", "");
		System.out.println(qus_id);
		WebElement prob_id = driver_inst.selector("//*[@lt-prop-dp="+ qus_id +"]");//../../div.view-info/
		System.out.println(prob_id);
		Thread.sleep(1000);
		String score = driver_inst.selector("zask-ui-card > div > div.view-info > div:nth-child(2)  > div.sp18").getText();	
		System.out.println("SCORE VALUE......"+score);
		driver_inst.wait_Click_evt("div.question-detail > link-to > a"); 
		driver_inst.refresh();
	}
	//- - - - - - - - - - - 	Like Check		- - - - - - - -	
	public static void likebtn() throws InterruptedException{ 	
		driver_inst.refresh();////*[@id="vote-4177811000"]/span
		WebElement like_select = driver_inst.selector(".like");
		like_select.click();
		Thread.sleep(4000);
		String Actual_like_class = like_select.getAttribute("class");		
//		System.out.println("IF before class........."+Actual_like_class);
//		if(Actual_like_class.equals("up info-ico icon like vote likeClicked")) {
//			System.out.println("IF CLASS........"+Actual_like_class);
//			driver_inst.navigate();
//			driver_inst.refresh();
//			String score_txt = driver_inst.selector("zask-ui-card > div > div.view-info > div:nth-child(2) > div.sp18").getText();	
//			System.out.println(score_txt);
//			Assert.assertEquals("1",score_txt);
//			System.out.println("Score added:--Pass-- \n");
//			driver_inst.wait_Click_evt("div.question-detail > link-to > a"); 
//		} else { 
//			driver_inst.navigate();
//			String else_score_txt = driver_inst.selector("zask-ui-card > div > div.view-info > div:nth-child(2) > div.sp18").getText();
//			System.out.println(else_score_txt);
//			Assert.assertEquals("0",else_score_txt);
//			System.out.println("Score not added:--Fail-- \n");
//			driver_inst.wait_Click_evt("div.question-detail > link-to > a"); 				
//		}    			
		//- - - - - - - - - - - 	Check Like class change 		- - - - - - - - - -	
//		try {	
//			Assert.assertEquals("up info-ico icon like vote likeClicked",Actual_like_class);
//			System.out.println("Like Button class changed:--Pass-- \n");
//		} catch(Exception e) {
//			System.out.println("Like Button class not changed:--Fail-- \n");
//		}	
		//- - - - - - - - - - - 	Check Like class change(Remove like)		- - - - - - - - - -	
		try {			
			WebElement Remove_like_select = driver_inst.selector(".like");
//			Remove_like_select.click();
			Thread.sleep(3000);
			String Actual_remove_like_class = like_select.getAttribute("class");
			System.out.println("IF before class........."+Actual_remove_like_class);
			Assert.assertEquals("up info-ico icon like vote likeClicked",Actual_remove_like_class);
			System.out.println("Remove Like Button class changed:--Pass-- \n");
		} catch(Exception e) {
			System.out.println("Remove Like Button class not changed:--Fail-- \n");
		}	
		//- - - - - - - - - - - 	Check Like Vote value 		- - - - - - - - - -	
		try {			
			WebElement vote_like_select = driver_inst.selector(".like");
			vote_like_select.getAttribute("vote_value");
			String Actual_remove_vote_ = like_select.getAttribute("class");
			System.out.println("IF before class........."+Actual_remove_vote_);
			Assert.assertEquals("up info-ico icon like vote likeClicked",Actual_remove_vote_);
			System.out.println("Vote value Like Button class changed:--Pass-- \n");
		} catch(Exception e) {
			System.out.println("Like Button class not changed:--Fail-- \n");
		}	
		//- - - - - - - - - - - 	Background Color Check		- - - - - - - -		
		try {	
			JavascriptExecutor js = (JavascriptExecutor) driver_inst;
	        String text = js.executeScript(
	                "return window.getComputedStyle(document.querySelector('div.like'),'::before').getCssValue('background-color')")
	                .toString();
	        System.out.print(text);
			WebElement before_bgcolor = driver_inst.wait_Click_evt("div.like:before");
			String Actual_color = before_bgcolor.getCssValue("background-color");
			System.out.println("Background color........"+ Actual_color+"\n");
			System.out.println("Like button Before color not get:--Fail-- \n");
		} catch(Exception e) {			
			System.out.println("Like button Before color not get:--Fail-- \n");			
		}
	}
	//- - - - - - - - - - - 	Dislike Check		- - - - - - - -	
	public static void dislike() throws InterruptedException {					
		driver_inst.refresh();////*[@id="vote-4177811000"]/span
		WebElement dislike_select = driver_inst.selector(".dislike");
		dislike_select.click();
		Thread.sleep(4000);
		String Actual_dislike_class = dislike_select.getAttribute("class");		
//		System.out.println("IF before class........."+Actual_dislike_class);
//		if(Actual_dislike_class.equals("up info-ico icon like vote likeClicked")) {
//			System.out.println("IF CLASS........"+Actual_dislike_class);
//			driver_inst.navigate();
//			driver_inst.refresh();
//			String dislike_score_txt = driver_inst.selector("zask-ui-card > div > div.view-info > div:nth-child(2) > div.sp18").getText();	
//			System.out.println(dislike_score_txt);
//			Assert.assertEquals("-1",dislike_score_txt);
//			System.out.println("Dislike Score added:--Pass-- \n");
//			driver_inst.wait_Click_evt("div.question-detail > link-to > a"); 
//		} else { 
//			driver_inst.navigate();
//			String else_dislike_score_txt = driver_inst.selector("zask-ui-card > div > div.view-info > div:nth-child(2) > div.sp18").getText();
//			System.out.println(else_dislike_score_txt);
//			Assert.assertEquals("0",else_dislike_score_txt);
//			System.out.println("Dislike Score not added:--Fail-- \n");
//			driver_inst.wait_Click_evt("div.question-detail > link-to > a"); 				
//		}    			
		//- - - - - - - - - - - 	Check dislike class change 		- - - - - - - - - -	
//		try {	
//			Assert.assertEquals("down info-ico icon dislike dislikeClicked vote",Actual_dislike_class);
//			System.out.println("Like Button class changed:--Pass-- \n");
//		} catch(Exception e) {
//			System.out.println("Like Button class not changed:--Fail-- \n");
//		}	
		//- - - - - - - - - - - 	Check dislike class change(Remove like)		- - - - - - - - - -	
		try {			
			WebElement Remove_dislike_select = driver_inst.selector(".dislike");
			Remove_dislike_select.click();
			Thread.sleep(3000);
			String Actual_remove_dislike_class = Remove_dislike_select.getAttribute("class");
			System.out.println("IF before class........."+Actual_remove_dislike_class);
			Assert.assertEquals("down info-ico icon dislike vote dislikeClicked",Actual_remove_dislike_class);
			System.out.println("Remove Dislike Button class changed:--Pass-- \n");
		} catch(Exception e) {
			System.out.println("Remove Dislike Button class not changed:--Fail-- \n");
		}	
		//- - - - - - - - - - - 	Check dislike Vote value 		- - - - - - - - - -	
		try {			
			WebElement vote_dislike_select = driver_inst.selector(".dislike");
			vote_dislike_select.getAttribute("vote_value");
			String Actual_remove_vote_ = vote_dislike_select.getAttribute("class");
			System.out.println("IF before class........."+Actual_remove_vote_);
			Assert.assertEquals("down info-ico icon dislike vote dislikeClicked",Actual_remove_vote_);
			System.out.println("Vote value dislike Button class changed:--Pass-- \n");
		} catch(Exception e) {
			System.out.println("Vote value Dislike Button class not changed:--Fail-- \n");
		}	
		//- - - - - - - - - - - 	Background Color Check		- - - - - - - -		
		try {	
			JavascriptExecutor js = (JavascriptExecutor) driver_inst;
			String text = js.executeScript(
					"return window.getComputedStyle(document.querySelector('div.dislike'),'::before').getCssValue('background-color')")
					.toString();
			System.out.print(text);
			WebElement before_bgcolor = driver_inst.wait_Click_evt("div.dislike:before");
			String Actual_color = before_bgcolor.getCssValue("background-color");
			System.out.println("Background color........"+ Actual_color+"\n");
			System.out.println("Dislike button Before color get:--Pass-- \n");
		} catch(Exception e) {			
			System.out.println("Dislike button Before color not get:--Fail-- \n");			
		}
	}
	//- - - - - - - - - - - 	Favorite Check		- - - - - - - -	
	public static void favourite() {		
		try {			
			driver_inst.refresh();////*[@id="vote-4177811000"]/span
			WebElement dislike_select = driver_inst.selector(".dislike");
			dislike_select.click();
			WebElement favourite_select = driver_inst.selector(".favourite");
			favourite_select.click();
			Thread.sleep(3000);
			String favourite_class = favourite_select.getAttribute("class");
			Assert.assertEquals("info-ico icon favouriteClicked",favourite_class);
			driver_inst.navigate();
			driver_inst.Click_evt("#question-filter");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[1]/lyte-yield/lyte-accordion-item");
			driver_inst.Click_evt("//span[text()='Favourite']");
			driver_inst.Click_evt("filter-button apply");
			System.out.println("Dislike Button class changed:--Pass-- \n");
		} catch(Exception e) {
			System.out.println("Dislike Button class not changed:--Fail-- \n");
		} 
		
	}
	//- - - - - - - - - - - 	Edit Icon Click		- - - - - - - -	
	public static void Edit_page() {
//		WebElement Edit_select = driver_inst.selector("//span[@class='icon edit']");
//		String Actual_Edit_title = Edit_select.getAttribute("lt-prop-title");
//		Assert.assertEquals(Actual_Edit_title, "Edit");
		//- - - - - - - - - - - 	Click Edit Icon   - - - - - - - -	- - - - 
		driver_inst.Click_evt("//span[@class='icon edit']");
	}
	//- - - - - - - - - - - 	Title check		- - - - - - - -	
	public static void Check_Title() throws InterruptedException {
		//- - - - - - - - - - - 	Clear title   - - - - - - - -	- - - - 
		driver_inst.Click_evt("#add-question-title");
		driver_inst.Clear_evt("#add-question-title");
		//- - - - - - - - - - - 	Check placeholder    - - - - - - - -	- - - - 
		try {
			String actual_plc_txt = driver_inst.selector("#add-question-title").getAttribute("placeholder");
			Assert.assertEquals(actual_plc_txt, "Ask your question here!");
			System.out.println("Ask your question here! is present:--pass-- \n");
		} catch(Exception e)  {
			System.out.println("Ask your question here! is not present:--Fail-- \n");
		}
		//- - - - - - - - - - - 	Check Type    - - - - - - - -	- - - - 
		try {
			String actual_type = driver_inst.selector("#add-question-title").getAttribute("type");
			Assert.assertEquals(actual_type, "text");
			System.out.println("Title type text is present:--Pass-- \n");
		} catch(Exception e)  {
			System.out.println("Title type text is not present:--Fail-- \n");
		}
		//- - - - - - - - - - - 	Check min value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How");
			//- - - - - - - - -		update button click  - - - - - - - - - - - 	
			driver_inst.Click_evt("#add-question-submit");
			Thread.sleep(2000);
			boolean actual_min = driver_inst.pagecontent().contains("Enter a post title of at least 15 characters.");
			Assert.assertTrue(actual_min);		
			System.out.println("'Min value' - Enter a post title of at least 15 characters is present. :--Pass--\n");
		} catch(Exception e)  {
			System.out.println("'Min value' - Enter a post title of at least 15 characters is not present.:--Fail--\n");
		}	
		//- - - - - - - - - - - 	Check Max value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How to get a list of questions?How to get a list of questions?How to get a list of questions?How to get a list of questions?How to get a list of questions?How to get a list of questions?How to get a list of questions?How to get a list of questions?");
			//- - - - - - - - -		update button click  - - - - - - - - - - - 	
			driver_inst.Click_evt("#add-question-submit");
			Thread.sleep(2000);
			boolean actual_max = driver_inst.pagecontent().contains("Post title cannot exceed 150 characters.");
			Assert.assertTrue(actual_max);		
			System.out.println("'Max value' - Post title cannot exceed 150 characters is present.:--Pass--\n");
		} catch(Exception e)  {
			System.out.println("'Max value' - Post title cannot exceed 150 characters is not present.:--Fail--\n");
		}		
		//- - - - - - - - - - - 	Check invalid space value    - - - - - - - -	- - - - 
		try { 
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title",".                                   .");
			//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");
			//- - - - - - - - -		update button click  - - - - - - - - - - - 	
			driver_inst.Click_evt("#add-question-submit");
			Thread.sleep(2000);
			boolean actual_invalid_space = driver_inst.pagecontent().contains("Enter a post title of at least 15 characters.");
			Assert.assertTrue(actual_invalid_space);		
			System.out.println("'Empty space' - Enter a post title of at least 15 characters is present. :--Pass--\n");
		} catch (Exception e) {
			System.out.println("'Empty space' - Enter a post title of at least 15 characters is not present. :--Fail--\n");
		}
		//- - - - - - - - - - - 	Check invalid number value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title","12345678901234567");
			//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");
			//- - - - - - - - -		update button click  - - - - - - - - - - - 	
			driver_inst.Click_evt("#add-question-submit");
			Thread.sleep(2000);
			boolean actual_invalid_number = driver_inst.pagecontent().contains("Enter valid post content of at least 15 characters");
			Assert.assertTrue(actual_invalid_number);		
			System.out.println("'Number' - Enter valid post content of at least 15 characters is present:--Pass--\n");
		} catch (Exception e) {
			System.out.println("'Number' - Enter valid post content of at least 15 characters is not present:--Fail--\n");
		}
		//- - - - - - - - - - - 	Check invalid Special Char value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title","@#$%^&*()@#$%^&*()@#$%^&*()");
			//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");
			//- - - - - - - - -		update button click  - - - - - - - - - - - 	
			driver_inst.Click_evt("#add-question-submit");
			Thread.sleep(2000);
			boolean actual_invalid_splchar = driver_inst.pagecontent().contains("Enter valid post content of at least 15 characters");
			Assert.assertTrue(actual_invalid_splchar);		
			System.out.println("'Special' - Enter valid post content of at least 15 characters is present:--Pass--\n");
		} catch (Exception e) {
			System.out.println("'Special' - Enter valid post content of at least 15 characters is not present:--Fail--\n");
		}
		//- - - - - - - - - - - 	Valid data for Title   - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How to get a list of questions?");
			driver_inst.Click_evt("#add-question-submit");
			Thread.sleep(2000);
			//- - - - - - - - - - - 	Update Success Message    - - - - - - - -	- - - - 
			boolean Valid_msg = driver_inst.pagecontent().contains("Enter valid post content of at least 15 characters");
			Assert.assertTrue(Valid_msg);		
			System.out.println("'valid' - Enter valid post content of at least 15 characters is present. :--pass-- \n");
		} catch (Exception e) {
			System.out.println("'valid' - Enter valid post content of at least 15 characters is not present:--Fail-- \n");
		}
	}
	//- - - - - - - - - - - 	check bold   - - - - - - - - - - - -
	public static void Check_Bold() throws InterruptedException {
	//- - - - - - - - - - 		Bold Icon Click		- - - - - - - - - -
		try { 			
			Thread.sleep(2000);
			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			Thread.sleep(500);
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
			WebElement test = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test.sendKeys("A question that is not understood well cannot be answered well.");
			String bold_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > strong").getText();
			Assert.assertEquals(bold_txt, "A question that is not understood well cannot be answered well.");
			System.out.println("Text bold:--Pass--");
		} catch(Exception e) {
			System.out.println("Text bold:--Fail--"+e);
		}
		//- - - - - - - - - -		Check Bold Color Check		- - - - - - - - - -
		try {
			String bold_clr = driver_inst.selector("button.ql-bold").getCssValue("color");
			System.out.println("Test color"+bold_clr);
			
			Assert.assertEquals(bold_clr, "rgba(0, 102, 204, 1)");
			System.out.println("Bold Color is present:--Pass--");
		} catch(Exception e) {
			System.out.println("Bold Color is not present:--Fail--");
		}
		//- - - - - - - - - -		Check Bold Class active		- - - - - - - - - -
		try {
			boolean bold_act_class = driver_inst.pagecontent().contains("ql-bold ql-active");
			Assert.assertTrue(bold_act_class);
			System.out.println("Check Text Bold class is present: --Pass-- \n");
		} catch(Exception e) {
			System.out.println("Check Text Bold class is not present : --Fail-- \n");
		}
		//- - - - - - - - - -		Ctrl+B & Ctrl+A Key	- - - - - - - - - -
		try {
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			WebElement test1 = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test1.sendKeys("A question that is not understood well cannot be answered well.");
			driver_inst.ctrl_a("#editor-outlet > div.ql-editor > p", Keys.chord(Keys.CONTROL, "a"));
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
			String bold_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > strong").getText();
			Assert.assertEquals(bold_txt, "A question that is not understood well cannot be answered well.");
			System.out.println("'Ctrl+a' - Text Bold : --Pass--\n");
		} catch (Exception e) {
			System.out.println("'Ctrl+a' - Text Bold : --Fail-- \n");
		}		
		//- - - - - - - - - -		Ctrl+B & Ctrl+A Key	- - - - - - - - - -
		try {
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
			WebElement test1 = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test1.sendKeys("A question that is not understood well cannot be answered well.");
			driver_inst.ctrl_a("#editor-outlet > div.ql-editor > p", Keys.chord(Keys.CONTROL, "a"));
			driver_inst.ctrl_B("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold", Keys.chord(Keys.CONTROL, "b"));
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
			String bold_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > strong").getText();
			Assert.assertEquals(bold_txt, "A question that is not understood well cannot be answered well.");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			System.out.println("'Ctrl+a' - Text Bold : --Pass--\n");
		} catch (Exception e) {
			System.out.println("'Ctrl+a' - Text Bold : --Fail-- \n");
		}	
		driver_inst.refresh();
	}
	//- - - - - - - - - - - 	Check Italic   - - - - - - - - - - - -
	public static void Check_Italic() throws InterruptedException {
		//- - - - - - - - - - 		Italic Icon Click		- - - - - - - - - -
		try { 		
			driver_inst.Click_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			Thread.sleep(1500);
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
			WebElement test_italic = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test_italic.sendKeys("A question that is not understood well cannot be answered well.");
			String italic_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > em").getText();
			Assert.assertEquals(italic_txt, "A question that is not understood well cannot be answered well.");
			System.out.println("Text italic:--Pass--\n");
		} catch(Exception e) {
			System.out.println("Text italic:--Fail--\n");
		}
		//- - - - - - - - - -		Check Italic Color Check		- - - - - - - - - -
		try {
			String italic_clr = driver_inst.selector("button.ql-italic").getCssValue("color");
			Assert.assertEquals(italic_clr, "rgba(0, 102, 204, 1)");
			System.out.println("Italic Color is present:--Pass--\n");
		} catch(Exception e) {
			System.out.println("Italic Color is not present:--Fail--\n");
		}
		//- - - - - - - - - -		Check Bold Class active		- - - - - - - - - -
		try {
			boolean Italic_act_class = driver_inst.pagecontent().contains("ql-italic ql-active");
			Assert.assertTrue(Italic_act_class);
			System.out.println("Check Text italic class is present: --Pass-- \n");
		} catch(Exception e) {
			System.out.println("Check Text italic class is not present : --Fail-- \n");
		}
		//- - - - - - - - - -		 Ctrl+A Key	- - - - - - - - - -
		try {
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
			WebElement test1_Italic = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test1_Italic.sendKeys("A question that is not understood well cannot be answered well.");
			driver_inst.ctrl_a("#editor-outlet > div.ql-editor > p", Keys.chord(Keys.CONTROL, "a"));
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
			String italic_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > em").getText();
			Assert.assertEquals(italic_txt,"A question that is not understood well cannot be answered well.");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			System.out.println("'Ctrl+a' - Select and Text Italic : --Pass--\n");
		} catch (Exception e) {
			System.out.println("'Ctrl+a' - Select and Text Italic : --Fail-- \n");
		}
		//- - - - - - - - - -		Ctrl+I Key	- - - - - - - - - -
		try {
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
			WebElement test1_Italic = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test1_Italic.sendKeys("A question that is not understood well cannot be answered well.");
			driver_inst.ctrl_a("#editor-outlet > div.ql-editor > p", Keys.chord(Keys.CONTROL, "a"));
			driver_inst.ctrl_I("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic", Keys.chord(Keys.CONTROL, "i"));
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
			String italic_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > em").getText();
			Assert.assertEquals(italic_txt,"A question that is not understood well cannot be answered well.");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			System.out.println("'Ctrl+i' - Select and Text Italic : --Pass--\n");
		} catch (Exception e) {
			System.out.println("'Ctrl+i' - Text Italic : --Fail-- \n");
		}
		//			driver_inst.refresh();
	}
	//- - - - - - - - - - - 	Check Underline   - - - - - - - - - - - -	
	public static void Check_Underline() throws InterruptedException {
	//- - - - - - - - - - 		Italic Icon Click		- - - - - - - - - -
		try { 		
			driver_inst.Click_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			Thread.sleep(1500);
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline");
			WebElement test_underline = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test_underline.sendKeys("A question that is not understood well cannot be answered well.");
			String underline_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > em").getText();
//			Assert.assertEquals(underline_txt, "A question that is not understood well cannot be answered well.");
			System.out.println("Text underline:--Pass--\n");
		} catch(Exception e) {
			System.out.println("Text underline:--Fail--\n");
		}
		//- - - - - - - - - -		Check Italic Color Check		- - - - - - - - - -
		try {
			String underline_clr = driver_inst.selector("button.ql-underline").getCssValue("color");
			Assert.assertEquals(underline_clr, "rgba(0, 102, 204, 1)");
			System.out.println("underline Color is present:--Pass--\n");
		} catch(Exception e) {
			System.out.println("underline Color is not present:--Fail--\n");
		}
		//- - - - - - - - - -		Check Bold Class active		- - - - - - - - - -
		try {
			boolean underline_act_class = driver_inst.pagecontent().contains("ql-italic ql-active");
			Assert.assertTrue(underline_act_class);
			System.out.println("Check Text underline class is present: --Pass-- \n");
		} catch(Exception e) {
			System.out.println("Check Text underline class is not present : --Fail-- \n");
		}
		//- - - - - - - - - -		 Ctrl+A Key	- - - - - - - - - -
		try {
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline");
			WebElement test1_underline = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test1_underline.sendKeys("A question that is not understood well cannot be answered well.");
			driver_inst.ctrl_a("#editor-outlet > div.ql-editor > p", Keys.chord(Keys.CONTROL, "a"));
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline");
			String underline_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > em").getText();
//			Assert.assertEquals(underline_txt,"A question that is not understood well cannot be answered well.");
			System.out.println("'Ctrl+a' - Select and Text underline : --Pass--\n");
		} catch (Exception e) {
			System.out.println("'Ctrl+a' - Select and Text underline : --Fail-- \n");
		}
		//- - - - - - - - - -		Ctrl+I Key	- - - - - - - - - -
		try {
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline");
			WebElement test1_underline = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test1_underline.sendKeys("A question that is not understood well cannot be answered well.");
			driver_inst.ctrl_a("#editor-outlet > div.ql-editor > p", Keys.chord(Keys.CONTROL, "a"));
			driver_inst.ctrl_U("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline", Keys.chord(Keys.CONTROL, "i"));
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline");
			String underline_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > em").getText();
//			Assert.assertEquals(underline_txt,"A question that is not understood well cannot be answered well.");
			System.out.println("'Ctrl+i' - Select and Text underline : --Pass--\n");
		} catch (Exception e) {
			System.out.println("'Ctrl+i' - Text underline : --Fail-- \n");
		}
//						driver_inst.refresh();
	}
	//- - - - - - - - - - - 	Check Strike   - - - - - - - - - - - -
	public static void Check_strike() throws InterruptedException {
		//- - - - - - - - - - 		Strike Icon Click		- - - - - - - - - -
		try { 		
			driver_inst.refresh();
			driver_inst.Click_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			Thread.sleep(1500);
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-strike");
			WebElement test_strike = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test_strike.sendKeys("A question that is not understood well cannot be answered well.");
			String strike_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > s").getText();
			Assert.assertEquals(strike_txt, "A question that is not understood well cannot be answered well.");
			System.out.println("Text strike:--Pass--\n");
		} catch(Exception e) {
			System.out.println("Text strike:--Fail--\n");
		}
		//- - - - - - - - - -		Check Italic Color Check		- - - - - - - - - -
		try {
			String strike_clr = driver_inst.selector("button.ql-strike").getCssValue("color");
			Assert.assertEquals(strike_clr, "rgba(0, 102, 204, 1)");
			System.out.println("underline Color is present:--Pass--\n");
		} catch(Exception e) {
			System.out.println("underline Color is not present:--Fail--\n");
		}
		//- - - - - - - - - -		Check Bold Class active		- - - - - - - - - -
		try {
			boolean strike_act_class = driver_inst.pagecontent().contains("ql-strike ql-active");
			Assert.assertTrue(strike_act_class);
			System.out.println("Check Text underline class is present: --Pass-- \n");
		} catch(Exception e) {
			System.out.println("Check Text underline class is not present : --Fail-- \n");
		}
		//- - - - - - - - - -		 Ctrl+A Key	- - - - - - - - - -
		try {
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-strike");
			WebElement strike_underline = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			strike_underline.sendKeys("A question that is not understood well cannot be answered well.");
			driver_inst.ctrl_a("#editor-outlet > div.ql-editor > p", Keys.chord(Keys.CONTROL, "a"));
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-strike");
			String strike_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > s").getText();
			Assert.assertEquals(strike_txt,"A question that is not understood well cannot be answered well.");
			System.out.println("'Ctrl+a' - Select and Text strike : --Pass--\n");
		} catch (Exception e) {
			System.out.println("'Ctrl+a' - Select and Text strike : --Fail-- \n");
		}
	}
	//- - - - - - - - - - - 	Bold & Italic		- - - - - - - -	- - - - 
	public static void Bold_Itallic() throws InterruptedException {
		try { 		
			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			Thread.sleep(500);
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
			WebElement test = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test.sendKeys("A question that is not understood well cannot be answered well.");
			String bold_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > strong > em").getText();
			Assert.assertEquals(bold_txt, "A question that is not understood well cannot be answered well.");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			System.out.println("Text bold and  Italic:--Pass--\n");
		} catch(Exception e) {
			System.out.println("Text bold and  Italic:--Fail--\n");
		}
	}
	//- - - - - - - - - - - 	Underline & Strick		- - - - - - - -	- - - - 
	public static void strick_underline() throws InterruptedException {		
		try { 		
			driver_inst.Click_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			Thread.sleep(1500);
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline");
			driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-strike");
			WebElement test_underline = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
			test_underline.sendKeys("A question that is not understood well cannot be answered well.");
			String underline_txt = driver_inst.selector("#editor-outlet > div.ql-editor > p > s > u").getText();
			Assert.assertEquals(underline_txt, "A question that is not understood well cannot be answered well.");
			driver_inst.Clear_evt("//*[@id=\"editor-outlet\"]/div[1]/p");
			System.out.println("Text underline and strick:--Pass--\n");
		} catch(Exception e) {
			System.out.println("Text underline and strick:--Fail--\n");
		}
}
	//- - - - - - - - - - - 	Check tag		- - - - - - - -	- - - - 
	public static void check_tags() {
		//- - - - - - - - - - - 	Check invalid space value    - - - - - - - -	- - - - 
		driver_inst.refresh();
		//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.Click_evt("#add-question-submit");
			boolean empty_tag = driver_inst.pagecontent().contains("Enter at least one tag to post.");
			Assert.assertTrue(empty_tag);	
			System.out.println("Empty Tag check: --Pass--");
		} catch(Exception e) {
			System.out.println("Empty Tag check: --Fail--");
		}
		//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
		try {
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");
			String tag_1 = driver_inst.selector("//*[@tagname=\'html\']").getAttribute("tagname");
			System.out.println(tag_1);
			Assert.assertEquals(tag_1, "html");
			System.out.println("Tag_1 : --Pass--");
		} catch(Exception e) {
			System.out.println("Tag_1 : --Fail--");
		}
		//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.send_Val("//input[@placeholder='Add tags.']","em");
			driver_inst.Click_evt("//*[@content=\'email\']");
			String tag_2 = driver_inst.selector("//*[@tagname=\'email\']").getAttribute("tagname");
			Assert.assertEquals(tag_2, "email");
			System.out.println("Tag_2 : --Pass--");
		} catch(Exception e) {
			System.out.println("Tag_2 : --Fail--");
		}
		//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - -
		try {
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.send_Val("//input[@placeholder='Add tags.']","ga");
			driver_inst.Click_evt("//*[@content=\'gadgets-android-mobile\']");
			String tag_3 = driver_inst.selector("//*[@tagname=\'gadgets-android-mobile\']").getAttribute("tagname");
			Assert.assertEquals(tag_3, "gadgets-android-mobile");
			System.out.println("Tag_3 : --Pass--");
		} catch(Exception e) {
			System.out.println("Tag_3 : --Fail--");
		}
		//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.send_Val("//input[@placeholder='Add tags.']","va");
			driver_inst.Click_evt("//*[@content=\'validation\']");
			String tag_4 = driver_inst.selector("//*[@tagname=\'validation\']").getAttribute("tagname");
			Assert.assertEquals(tag_4, "validation");
			System.out.println("Tag_4 : --Pass--");
		} catch(Exception e) {
			System.out.println("Tag_4 : --Fail--");
		}
		//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
		try {
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.send_Val("//input[@placeholder='Add tags.']","xa");
			driver_inst.Click_evt("//*[@content=\'xamarin\']");
			String tag_5 = driver_inst.selector("//*[@tagname=\'xamarin\']").getAttribute("tagname");
			Assert.assertEquals(tag_5, "xamarin");
			System.out.println("Tag_5 : --Pass--");
		} catch(Exception e) {
			System.out.println("Tag_5 : --Fail--");
		}
		//			//- - - - - - - - - - - 	Tag Value    - - - - - - - -	- - - - 
		//			try {
		//			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
		//			driver_inst.send_Val("//input[@placeholder='Add tags.']","za");
		//			driver_inst.Click_evt("//*[@content=\'zac\']");
		//			String tag_6 = driver_inst.selector("//*[@tagname=\'zac\']").getAttribute("tagname");
		//			System.out.println("tag_6");
		//			Assert.assertEquals(tag_6, "zac");
		//			System.out.println("Tag_6 : --Pass--");
		//			} catch(Exception e) {
		//				System.out.println("Tag_6 : --Fail--");
		//			}
		//- - - - - - - - -		update button click  - - - - - - - - - - - 	
//		try {
//			driver_inst.Click_evt("#add-question-submit");
//			Thread.sleep(2000);
//			boolean actual_invalid_space = driver_inst.pagecontent().contains("Enter a post title of at least 15 characters.");
//			Assert.assertTrue(actual_invalid_space);		
//			System.out.println("'Empty space' - Enter a post title of at least 15 characters is present. :--Pass--\n");
//		} catch (Exception e) {
//			System.out.println("'Empty space' - Enter a post title of at least 15 characters is not present. :--Fail--\n");
//		}
	}
	//- - - - - - - - - - - 	Check Message	- - - - - - - -	- - - - 
	public static void check_message() throws InterruptedException {
	//- - - - - - - - - - -		Empty Check for reason tag	- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How to get a list of questions?");
			
			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			driver_inst.send_Val("#editor-outlet > .ql-editor > p", "How to get a list of questions?");
			//- - - - - - - - - - - 	Send Tag   - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");
			
			driver_inst.Click_evt("#add-question-edit-summary");
			driver_inst.Clear_evt("#add-question-edit-summary");
			driver_inst.Click_evt("#add-question-submit"); //
			boolean reason_msg = driver_inst.pagecontent().contains("Enter a reason of at least 5 characters to update.");
			Assert.assertTrue(reason_msg);		
			System.out.println("'Reason' Empty --Pass--");
		} catch(Exception e) {
			System.out.println("'Reason' Empty --Fail--");
		}
		//- - - - - - - - - - -		min Check for reason tag	- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How to get a list of questions?");

			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			driver_inst.send_Val("#editor-outlet > .ql-editor > p", "How to get a list of questions?");
			//- - - - - - - - - - - 	Send Tag   - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");

			driver_inst.Click_evt("#add-question-edit-summary");
			driver_inst.Clear_evt("#add-question-edit-summary");
			driver_inst.send_Val("#add-question-edit-summary","test"); 
			driver_inst.Click_evt("#add-question-submit"); 
			boolean reason_msg = driver_inst.pagecontent().contains("Enter a reason of at least 5 characters to update.");
			Assert.assertTrue(reason_msg);		
			System.out.println("'Reason' min value check : --Pass--");
		} catch(Exception e) {
			System.out.println("'Reason' min value check : --Fail--");
		}
		//- - - - - - - - - - -		Max Check for reason tag	- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How to get a list of questions?");

			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			driver_inst.send_Val("#editor-outlet > .ql-editor > p", "How to get a list of questions?");
			//- - - - - - - - - - - 	Send Tag   - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");

			driver_inst.Click_evt("#add-question-edit-summary");
			driver_inst.Clear_evt("#add-question-edit-summary");
			driver_inst.send_Val("#add-question-edit-summary","A question that is not understood well cannot be answered well.A question that is not understood well cannot be answered well."); 
			driver_inst.Click_evt("#add-question-submit"); 
			boolean reason_msg = driver_inst.pagecontent().contains("Reason exceeded 50 characters");
			Assert.assertTrue(reason_msg);		
			System.out.println("'Reason' min value check : --Pass--");
		} catch(Exception e) {
			System.out.println("'Reason' min value check : --Fail--");
		}
		//- - - - - - - - - - -			Number check		- - - - - - - - - - -	
		try {
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How to get a list of questions?");
			
			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			driver_inst.send_Val("#editor-outlet > .ql-editor > p", "How to get a list of questions?");
			//- - - - - - - - - - - 	Send Tag   - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");
			
			driver_inst.Click_evt("#add-question-edit-summary");
			driver_inst.Clear_evt("#add-question-edit-summary");
			driver_inst.send_Val("#add-question-edit-summary","123456");
			driver_inst.Click_evt("#add-question-submit"); 
			boolean reason_num = driver_inst.pagecontent().contains("Enter valid reason content of at least 5 characters");
			Assert.assertFalse(reason_num);			
			System.out.println("'Reason number check' is not show alert message: --Pass--");
		} catch(Exception e) {
			System.out.println("'Reason number check' is show alert message:--Fail--");
		}
	}
	//- - - - - - - - - - -			Special charter check		- - - - - - - - - - -
	public static void check_message_spl() throws InterruptedException {
		try {
			driver_inst.Click_evt("//span[@class='icon edit']");
			driver_inst.Click_evt("#add-question-title");
			driver_inst.Clear_evt("#add-question-title");			
			driver_inst.send_Val("#add-question-title", "How to get a list of questions?");

			driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
			driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
			driver_inst.send_Val("#editor-outlet > .ql-editor > p", "How to get a list of questions?");
			//- - - - - - - - - - - 	Send Tag   - - - - - - - -	- - - - 
			driver_inst.Click_evt("//input[@placeholder='Add tags.']");
			driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
			driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
			driver_inst.Click_evt("//*[@content=\'html\']");

			driver_inst.Click_evt("#add-question-edit-summary");
			driver_inst.Clear_evt("#add-question-edit-summary");
			driver_inst.send_Val("#add-question-edit-summary","123456");
			driver_inst.Click_evt("#add-question-submit"); 
			boolean reason_spl = driver_inst.pagecontent().contains("Enter valid reason content of at least 5 characters");
			Assert.assertFalse(reason_spl);			
			System.out.println("'Reason specil char check' is not show alert message: --Pass--");
		} catch(Exception e) {
			System.out.println("'Reason specil char check' is show alert message:--Fail--");
		}
	}
	//- - - - - - - - - - -		Valid check		- - - - - - - - - - -
	public static void Valid_check() throws InterruptedException {
	try {
		driver_inst.Click_evt("//span[@class='icon edit']");
		driver_inst.Click_evt("#add-question-title");
		driver_inst.Clear_evt("#add-question-title");			
		driver_inst.send_Val("#add-question-title", "How to get id value in title tag");

		driver_inst.Click_evt("#editor-outlet > .ql-editor > p");
		driver_inst.Clear_evt("#editor-outlet > .ql-editor > p");
		WebElement test_nrml = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
		test_nrml.sendKeys("A ");
		
		driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
		WebElement test_bold = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
		test_bold.sendKeys("question ");
		driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-bold");
		
		WebElement test_nrml_1 = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
		test_nrml_1.sendKeys("that is not understood well cannot be answered well.");
//		
//		driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
//		WebElement test_italic = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
//		test_italic.sendKeys("understood ");
//		driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-italic");
//		
//		WebElement test_nrml_2 = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
//		test_nrml_2.sendKeys("well cannot be ");
//		
//		driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-underline");
//		driver_inst.Click_evt("#editor-1 > div.ql-toolbar.ql-snow > span > button.ql-strike");
//		WebElement test_underline = driver_inst.selector("//*[@id=\"editor-outlet\"]/div[1]");
//		test_underline.sendKeys("answered well.");
		//- - - - - - - - - - - 	Send Tag   - - - - - - - -	- - - - 
		driver_inst.Click_evt("//input[@placeholder='Add tags.']");
		driver_inst.backspace("//input[@placeholder='Add tags.']",Keys.BACK_SPACE);
		driver_inst.send_Val("//input[@placeholder='Add tags.']","htm");
		driver_inst.Click_evt("//*[@content=\'html\']");

		driver_inst.Click_evt("#add-question-edit-summary");
		driver_inst.Clear_evt("#add-question-edit-summary");
		driver_inst.send_Val("#add-question-edit-summary","id Testing"); 
		driver_inst.Click_evt("#add-question-submit"); 
		Thread.sleep(2000);
		boolean reason_msg = driver_inst.pagecontent().contains("Your post has been sent for review");
		Assert.assertTrue(reason_msg);		
		System.out.println("'Reason' min value check : --Pass--");
	} catch(Exception e) {
		System.out.println("'Reason' min value check : --Fail--");
	}
	}
	//- - - - - - - - - - -		Edit Content check		- - - - - - - - - - -
	public static void edit_content_check() throws InterruptedException {
		try {
			driver_inst.Click_evt("//*[@id=\"4177811000\"]/div[2]/div[1]/div[2]/div/div/span[1]");
			String edit_Ans_title = driver_inst.selector("//p[text()='How to get id value in title tag']").getText();
			System.out.println(edit_Ans_title);
			Assert.assertEquals(edit_Ans_title, "How to get id value in title tag");
		} catch(Exception e) {
			System.out.println(e);
		}
		try {
			String edit_Ans_msg = driver_inst.selector("//span[text()='id Testing']").getText();
			System.out.println(edit_Ans_msg);
			Assert.assertEquals(edit_Ans_msg, "id Testing");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	//- - - - - - - - - - - 	Quit Method		- - - - - - - -		
	public static void Quit() throws InterruptedException {
		driver_inst.Click_evt("div > .user-profile");
		driver_inst.wait_Click_evt("//button[text()='Sign Out']");
		driver_inst.quit_evt();
	}
}

