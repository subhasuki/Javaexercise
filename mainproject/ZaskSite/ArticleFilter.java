package ZaskSite;

import junit.framework.Assert;

public class ArticleFilter {
	static webdriverInstance driver_inst = new webdriverInstance(); 
	//- - - - - - - - - - -		Edit Content check		- - - - - - - - - - -
	public static void main (String args[]) throws InterruptedException {
		driver_inst.defineUrl();
		driver_inst.Click_evt("#details-button");	
		driver_inst.Click_evt("#proceed-link");
		driver_inst.wait_Click_evt("//a[@class='btn opc-text']");
		Login(); 
		Article_btn();
		sort_all();
		sort_views();
		sort_score();
		Filter_click();
		My_article_Filter_btn();
		Filter_click();
		In_review();
		Filter_click();
		Following_tag();
		sort_all();
		sort_views();
		sort_score();
		clear_icon();
		Filter_click();
		tag_icon();
		Tech();
		Filter_click();
		Author();
		Filter_click();
		Created_Time();
		Filter_click();
		Score();
		Filter_click();
		Views();
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
	//- - - - - - - - - - - 	Article Button		- - - - - - - -	
	public static void Article_btn() throws InterruptedException {	
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
	//- - - - - - - - - - -		Sorted by All New list   - - - - - - - - - - -
	public static void sort_all() {
		try {
			driver_inst.Click_evt("//*[@id=\"zask-sort-solutions-dropdown\"]/div[1]");
			driver_inst.Click_evt("//lyte-drop-item[text()='New']");
			String date = driver_inst.selector("span[text()='Sep 21 `21 @ 12:42 ']").getText();
			Assert.assertEquals(date, "Sep 21 `21 @ 12:42 ");
			System.out.println("Current date updated: --Pass--");
		} catch(AssertionError e) {
			System.out.println(":--Fail--\n");
		}
	}
	//- - - - - - - - - - -		Sorted by All View list  - - - - - - - - - - -
	public static void sort_views() {
		try {
			driver_inst.Click_evt("//*[@id=\"zask-sort-solutions-dropdown\"]/div[1]");
			driver_inst.Click_evt("//lyte-drop-item[text()='Views']");
			String get_first_views = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[1]/zask-ui-card/div/div[1]/div[2]/div[2]").getText();
			int view_val_1 = Integer.parseInt(get_first_views);  
			String get_sec_views = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[2]/zask-ui-card/div/div[1]/div[2]/div[2]").getText();
			int view_val_2 = Integer.parseInt(get_sec_views);			
			if(view_val_1 >= view_val_2) {
				System.out.println("Sorted by views list work  correctly --pass--");
			} else {
				System.out.println("Sort by views list work not correctly:--Fail--");
			}
		} catch(AssertionError e) {
			System.out.println("not sorted  by view list:--Fail--\n");
		}
	}
	//- - - - - - - - - - -		Sorted by All score list  - - - - - - - - - - -
	public static void sort_score() {
		try {
			driver_inst.Click_evt("//*[@id=\"zask-sort-solutions-dropdown\"]/div[1]");
			driver_inst.Click_evt("//lyte-drop-item[text()='Score']");
			String get_first_score = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[1]/zask-ui-card/div/div[1]/div[1]/div[2]").getText();
			int score_val_1 = Integer.parseInt(get_first_score);  
			String get_sec_views = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[2]/zask-ui-card/div/div[1]/div[1]/div[2]").getText();
			int score_val_2 = Integer.parseInt(get_sec_views);			
			if(score_val_1 >= score_val_2) {
				System.out.println("Sorted by score list work correctly: --pass--");
			} else {
				System.out.println("Sorted by score list work not correctlyy:--Fail--");
			}
		} catch (Exception e) {
			System.out.println("not sorted by score list :--Fail--\n");
		}
	}
	//- - - - - - - - - - -		Filter_click  - - - - - - - - - - -		
	public static void Filter_click() throws InterruptedException {
		//- - - - - - - - - - - 	filter list is displayed		- - - - - - - -	
		try {
			driver_inst.Click_evt("#solution-filter");
			boolean actual_filters = driver_inst.selector(".solutions-filter-tab").isDisplayed();
			Assert.assertTrue(actual_filters);
			System.out.println("Filter list is displayed:--Pass-- \n");
		} catch(AssertionError e) {
			System.out.println("Filter list is not displayed:--Fail-- \n");
		}
	}	
	//- - - - - - - - - - -		My draft  - - - - - - - - - - -
	public static void My_article_Filter_btn() throws InterruptedException {	
		//- - - - - - - - - - - 	Check My Articles Click		- - - - - - - -	
		try {
			driver_inst.Click_evt("//zask-ui-button[text()='ADD ARTICLE']");
			driver_inst.send_Val("#add-question-title", "How do I convert an Int to String in Java?");
			driver_inst.Clear_evt("div.ql-editor");
			driver_inst.send_Val("div.ql-editor","The community aims to bring answers for a particular question to one place. Make sure you do your best to keep your question one of a kind. Search for your question to ensure it's not on the site already.");
			driver_inst.send_Val("#repoLink", "https://not-just-a-tester.blogspot.com/p/testing.html");
			driver_inst.send_Val("//input[@placeholder='Add Authors.']","test");
			driver_inst.Click_evt("div.results > zask-ui-search-result:nth-child(2)");
			driver_inst.send_Val("//input[@placeholder='Add tags.']","test");
			driver_inst.Click_evt("div.results > zask-ui-search-result:nth-child(2)");
			driver_inst.Click_evt("#add-question-draft");
			Thread.sleep(2000);
			boolean draft_btn = driver_inst.pagecontent().contains("Your article has been saved to draft");
			Assert.assertTrue(draft_btn);		
			System.out.println("Successfully save in draft \n");
		} catch(AssertionError e) {
			System.out.println("Not save in draft \n"); 
		}
		//- - - - - - - - - - - 	Check Draft header text		- - - - - - - -	
		try {	
			String draft_txt = driver_inst.selector("div.question-detail > div.question-header > p.question-title").getText();
			System.out.println(draft_txt);
			Assert.assertEquals(draft_txt,"How do I convert an Int to String in Java?");
			System.out.println("Draft header text is present : --Pass--");
		} catch(AssertionError e) {
			System.out.println("Draft header text is not present : --Fail--");
		}
		//- - - - - - - - - - - 	Check Draft Description text		- - - - - - - -	
		try {
			String descrption_txt = driver_inst.selector("div.question-body > div.question-content > p").getText();
			System.out.println(descrption_txt);
			Assert.assertEquals(descrption_txt,"The community aims to bring answers for a particular question to one place. Make sure you do your best to keep your question one of a kind. Search for your question to ensure it's not on the site already.");
			System.out.println("Draft description text is present : --Pass--");
		} catch (Exception e) {
			System.out.println("Draft description text is not present : --Fail--");
		}
		//- - - - - - - - - - - 	Check Draft link text		- - - - - - - -	
		try {
			String link_txt = driver_inst.selector("div.repo-link > span > a").getText();
			Assert.assertEquals(link_txt, "https://not-just-a-tester.blogspot.com/p/testing.html");
			System.out.println("Draft link text is present : --Pass--");
		} catch (Exception e) {
			System.out.println("Draft link text is not present : --Fail--");
		}
		//- - - - - - - - - - - 	Check Draft title text		- - - - - - - -	
		try {
			driver_inst.Click_evt("div>.user-profile");
			driver_inst.Click_evt("//div[text()='My Articles']");
			driver_inst.Click_evt("//span[text()='My Drafts']");
			Thread.sleep(2000);
			String draft_show_title = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[1]/zask-ui-card/div/div[2]/link-to/a/p").getText(); 
			System.out.println(draft_show_title);
			Assert.assertEquals(draft_show_title,"How do I convert an Int to String in Java?");
			System.out.println("Showed my Draft title: -- Pass --");
		} catch (Exception e) {
			System.out.println("not Showed my Draft title: -- Fail --");
		}
		//- - - - - - - - - - - 	Check Draft Description text		- - - - - - - -	
		try {
			String draft_show_des = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[1]/zask-ui-card/div/div[2]/link-to/a/div").getText();
			Assert.assertEquals(draft_show_des,"The community aims to bring answers for a particular question to one place. Make sure you do your best to keep your question one of a kind. Search for your question to ensure it's not on the site already.");
			System.out.println("Showed my Draft description: -- Pass --");
		} catch (Exception e) {
			System.out.println("not Showed my Draft description: -- Fail --");
		}
		//- - - - - - - - - - - 	Check Draft tag text		- - - - - - - -	
		try {
			String draft_tag_txt = driver_inst.selector("//span[@tagname='testing']").getText();
			Assert.assertEquals(draft_tag_txt,"testing");
			System.out.println("Draft tag is present : --Pass--");
		} catch (Exception e) {
			System.out.println("Draft tag is not present : --Fail--");
		}
	} 
	//- - - - - - - - - - -		In Review   - - - - - - - - - - -
	public static void In_review() throws InterruptedException {	
		//- - - - - - - - - - - 	Draft send to post 	- - - - - - - -	
		try {
			driver_inst.Click_evt("//span[text()='My Drafts']");
			driver_inst.Click_evt("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[1]/zask-ui-card/div/div[2]/link-to/a/p");
			driver_inst.Click_evt("//div[text()='Post']");
			driver_inst.Click_evt("//*[text()='Yes']");
			Thread.sleep(4000);
			boolean draft_post = driver_inst.pagecontent().contains("Your article has been sent for review.");
			Assert.assertTrue(draft_post);
			System.out.println("Your article has been sent for review. : -- Pass -- ");
		} catch (Exception e) {
			System.out.println("Your article has not been sent for review. : -- Fail -- ");	
		}
		//- - - - - - - - - - - 	Check Draft Description text		- - - - - - - -	
		try {
			driver_inst.Click_evt("div>.user-profile");
			driver_inst.Click_evt("//div[text()='My Articles']");
			driver_inst.Click_evt("//span[text()='In Review']");
			String draft_show_des = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[1]/zask-ui-card/div/div[2]/link-to/a/div").getText();
			Assert.assertEquals(draft_show_des,"An article can be structured similar to the place holder in the description section. Although, a few things to keep in mind while posting a good article");
			System.out.println("Showed my Draft description: -- Pass --");
		} catch (Exception e) { 
			System.out.println("Not Showed my Draft description: -- Fail --");
		} 
		//- - - - - - - - - - - 	Check Draft tag text		- - - - - - - -	
		try {
			driver_inst.Click_evt("div>.user-profile");
			driver_inst.Click_evt("//div[text()='My Articles']");
			String draft_tag_txt = driver_inst.selector("//span[@tagname='testing']").getText();
			Assert.assertEquals(draft_tag_txt,"testing");
			System.out.println("Draft tag is present : --Pass--");
		} catch (Exception e) {
			System.out.println("Draft tag is not present : --Fail--");
		}
		//- - - - - - - - - - - 	Check move to draft		- - - - - - - -	
		try {
			driver_inst.Click_evt("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[1]/zask-ui-card/div/div[2]/link-to/a/p");
			driver_inst.Click_evt("//div[text()='Move to draft']"); 
			driver_inst.Click_evt("//*[text()='Yes']"); 
			Thread.sleep(4000); 
			boolean draft_post = driver_inst.pagecontent().contains("Your article has been moved to draft.");
			Assert.assertTrue(draft_post);  
			System.out.println("Your article has been moved to draft : -- Pass -- ");
		} catch (Exception e) { 
			System.out.println("Your article has not been moved to draft : -- Fail -- "); 
		} 
	}
	//- - - - - - - - - - - 	Following Tag		- - - - - - - -	
	public static void Following_tag() throws InterruptedException {
		try {
			driver_inst.Click_evt("//span[text()='CATEGORY']");
			driver_inst.Click_evt("//span[text()='Following Tags']");
			driver_inst.Click_evt("//button[text()='Apply']");
			String flw_tagname = driver_inst.selector("//span[@tagname='testing']").getText();
			System.out.println(flw_tagname);
			Assert.assertEquals(flw_tagname, "testing");
			System.out.println("Following tag are present:--Pass--");
		} catch (Exception e) {
			System.out.println("Following tag are not present:--Fail--");
		}
	}
	//- - - - - - - - - - - 	Favorite Tag		- - - - - - - -	
	public static void Favourite_tag() throws InterruptedException {
		try {
			String fav_txt = driver_inst.selector("//span[text()='Favourite']").getText();
			Assert.assertNotSame(fav_txt, "Favorite");
			System.out.println("Favorite spelling mistake: --Pass--");				

		} catch (Exception e) {
			System.out.println("Not a spelling mistake: --Pass--");
		}
		try {
			driver_inst.Click_evt("//span[text()='Favourite']");
			driver_inst.Click_evt("//button[text()='Apply']");
			String no_art = driver_inst.selector(".no-questions").getText();
			Assert.assertEquals(no_art, "No Articles");
			System.out.println("No Articles --Pass--");
		} catch (Exception e) {
			System.out.println("No Articles --Fail--");
		}
	}
	//- - - - - - - - - - - 	Clear icon		- - - - - - - - - - - 	
	public static void clear_icon() throws InterruptedException {
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='CATEGORY']");
			driver_inst.Click_evt("//div[@lt-prop-title_a='Clear']");
			Thread.sleep(2000);
			//			String all_chk = driver_inst.selector("//div[@value='All']").getAttribute("checked");
			//			System.out.println(all_chk);
			System.out.println("Category cleared -- Pass--");
			driver_inst.Click_evt("//span[text()='CATEGORY']");
			driver_inst.Click_evt("//span[text()='CATEGORY']");
			boolean category_unclick = driver_inst.selector(".lyteAccordionActive").isDisplayed();
			System.out.println(category_unclick);
			Assert.assertFalse(category_unclick);
			System.out.println("Check category_unclick : --Pass--");
		} catch (Exception e) {
			System.out.println(e);
		} 	
	}
	//- - - - - - - - - - - 	Tags list		- - - - - - - - - - - 	
	public static void tag_icon() throws InterruptedException {
		//- - - - - - - - - - -		Tags click Present  or not		- - - - - - - - - - -
		try{
			driver_inst.Click_evt("//span[text()='TAGS']");
			boolean tag_cls = driver_inst.selector(".lyteAccordionActive").isDisplayed();
			Assert.assertTrue(tag_cls);
			System.out.println("Tag class is present --Pass--");
		} catch (Exception e) {
			System.out.println("Tag class is not present --Fail--");
		}
		//- - - - - - - - - - -		 All & Technology Present or not		- - - - - - - - - - -
		try {
			String dot_net = driver_inst.selector("//span[text()='.net']").getText();
			Assert.assertEquals(dot_net, ".net");
			System.out.println("Technology is present --Pass--");
		} catch (Exception e) {
			System.out.println("Technology is not present --Fail--");
		}
		//- - - - - - - - - - -		All & Team Present or not		- - - - - - - - - - -
		try {
			String test_team = driver_inst.selector("//span[text()='test']").getText();
			Assert.assertEquals(test_team, "test");
			System.out.println("Team is present --Pass--");
			driver_inst.Click_evt(".clear");
		} catch (Exception e) {
			System.out.println("Team is not present --Fail--");
		}
	}
	//- - - - - - - - - - -		Tags Filter in Team  		- - - - - - - - - - -
	public static void Tech() {
		//- - - - - - - - - - -		Check Team 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("//span[text()=' All ']");
			driver_inst.Click_evt("//*[@data-value='Team']");
			String test_team = driver_inst.selector("//span[text()='zask']").getText();
			Assert.assertEquals(test_team, "zask");
			System.out.println("Zask team is present --Pass--");
		} catch (Exception e) {
			System.out.println("Zask team is present --Fail--");
		}
		//- - - - - - - - - - -		 Technology single check		- - - - - - - - - - -
		try {
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='java']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String java = driver_inst.selector("//span[text()='java']").getText();
			Assert.assertEquals(java, "java");
			System.out.println("java filter  question is present :--Pass--");
		} catch(Exception e) {
			System.out.println("java filter  question is not present : --Fail--");
		}
		//- - - - - - - - - - -		 Team Multiple check 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='TAGS']");
			driver_inst.Click_evt("//span[text()=' All ']");
			driver_inst.Click_evt("//*[@data-value='Team']");
			Thread.sleep(1000); 
			driver_inst.Click_evt("//span[text()='test']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String test = driver_inst.selector("//span[text()='test']").getText();
			Assert.assertEquals(test, "test");
			System.out.println("Team Select multiple option --Pass--");
		} catch (Exception e) {
			System.out.println("Team Select multiple option --Fail--");
		}
		//- - - - - - - - - - -		 input text check 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='TAGS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder=\"Search tags\"]", "pa");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='java']");
			driver_inst.Click_evt("//span[text()='test']");
			driver_inst.Click_evt("//span[text()='pali']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String  pali = driver_inst.selector("//span[text()='pali']").getText();
			Assert.assertEquals( pali, "pali");
			System.out.println("String Search tags --Pass--");
		} catch(Exception e) {
			System.out.println("String not Search tags --Fail--");
		}
		//- - - - - - - - - - -		 Tags input special char(Dot) check 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='TAGS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder=\"Search tags\"]", ".");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='pali']");
			driver_inst.Click_evt("//span[text()='.pali2']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String pali2 = driver_inst.selector("//div[text()='No Articles']").getText();
			Assert.assertEquals(pali2, "No Articles");
			System.out.println("Dot Search tags --Pass--");		
		} catch(Exception e) {
			System.out.println("Dot not Search tags --Fail--");
		}
		//- - - - - - - - - - -		 Tags input integer check 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='TAGS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder=\"Search tags\"]", "2");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='.pali2']");
			driver_inst.Click_evt("//span[text()='.pali2']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String No_Articles = driver_inst.selector("//div[text()='No Articles']").getText();
			Assert.assertEquals(No_Articles, "No Articles");
			System.out.println("Integer Search tags --Pass--");
		} catch(Exception e) {
			System.out.println("Integer not Search tags --Fail--");
		}
		//- - - - - - - - - - -		 Tags input hyphen check 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			Thread.sleep(1000); 
			driver_inst.Click_evt("//span[text()='TAGS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder='Search tags']", "-");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='.pali2']");
			driver_inst.Click_evt("//span[text()='actionscript-3']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String actionscript = driver_inst.selector("//span[text()='actionscript-3']").getText();
			System.out.println(actionscript);
			Assert.assertEquals(actionscript, "actionscript-3");
			System.out.println("hyphen Search tags --Pass--");
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='TAGS']");
			driver_inst.Click_evt(".icon.clear");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	//- - - - - - - - - - -		Tags Filter in Team  		- - - - - - - - - - -
	public static void Author() {
		//- - - - - - - - - - -		Check Team 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("//span[text()='AUTHORS']");
			driver_inst.send_Val("//input[@placeholder='Search authors']","pr");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='prabhakaran']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String author_name = driver_inst.selector("//span[text()='prabhakaran']").getText();
			Assert.assertEquals(author_name, "prabhakaran");
			System.out.println("Author name is present --Pass--");
		} catch (Exception e) {
			System.out.println("Author name is not present --FAil--");
		}
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='AUTHORS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder='Search authors']","+");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='prabhakaran']");
			driver_inst.Click_evt("//span[text()='prameena.s+zpzrapitest']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String author_plus = driver_inst.selector("//div[text()='No Articles']").getText();
			Assert.assertEquals(author_plus, "No Articles");
			System.out.println("Author name with plus is present --Pass--");
		} catch (Exception e) {
			System.out.println("Author name with plus is dot present --Fail--");
		}
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='AUTHORS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder='Search authors']",".");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='prameena.s+zpzrapitest']");
			driver_inst.Click_evt("//span[text()='ajith.b']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String author_dot = driver_inst.selector("//*[@id=\"zask-solutions-pagination\"]/zask-ui-solution-summaries/div/zask-ui-solution-summary-view[2]/zask-ui-card/div/div[2]/div/div/div/span[1]").getText();
			System.out.println(author_dot);
			Assert.assertNotSame(author_dot, "ambrose.j");
			System.out.println("Author name with dot is present --Pass--"); 
		} catch (Exception e) { 
			System.out.println("Author name with dot is not present --Fail--");
		} 
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='AUTHORS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder='Search authors']","_");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='ajith.b']");
			driver_inst.Click_evt("//span[text()='esakkivash_admin']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String author_under = driver_inst.selector("//div[text()='No Articles']").getText();
			Assert.assertEquals(author_under, "No Articles");
			System.out.println("Author name with underscore is present --Pass--");
		} catch (Exception e) {
			System.out.println("Author name with underscore is not present --Fail--");
		}
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='AUTHORS']");
			Thread.sleep(1000); 
			driver_inst.send_Val("//input[@placeholder='Search authors']","2");
			Thread.sleep(1000);
			driver_inst.Click_evt("//span[text()='esakkivash_admin']");
			driver_inst.Click_evt("//span[text()='hariharan29220']");
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			String author_int = driver_inst.selector("//div[text()='No Articles']").getText();
			Assert.assertEquals(author_int, "No Articles");
			System.out.println("Author name with integer is present --Pass--");
			driver_inst.Click_evt("//span[text()='AUTHORS']");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[3]/lyte-yield/lyte-accordion-item/lyte-accordion-header/div[2]/div");
			driver_inst.Click_evt("//span[text()='AUTHORS']");
		} catch (Exception e) {
			System.out.println("Author name with integer is not present --Fail--");
		}
	}
	//- - - - - - - - - - -		Tags Filter in Team  		- - - - - - - - - - -
	public static void Created_Time() {
		//- - - - - - - - - - -		Before Date		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("//span[text()='CREATED TIME']");
			driver_inst.send_Val("//input[@placeholder='mm/dd/yyyy']","01/01/2021");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			boolean date= driver_inst.pagecontent().contains("20");
			Assert.assertTrue(date);
			System.out.println("Before filter work properly --Pass--");
		} catch (Exception e) {
			System.out.println("Before filter work not properly --Fail--");
		}
		//- - - - - - - - - - -		After date check 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='CREATED TIME']");
			driver_inst.Click_evt("#lyteCalendarView");
			driver_inst.Click_evt(".lyteCaldLft");
			driver_inst.Click_evt(".lyteCaldLft");
			driver_inst.Click_evt(".lyteCaldLft");
			driver_inst.Click_evt(".lyteCaldLft");
			driver_inst.Click_evt(".lyteCaldLft");
			driver_inst.Click_evt(".lyteCaldLft");
			driver_inst.Click_evt("//span[text()='9']");
			driver_inst.Click_evt("//span[text()=' Before ']");
			driver_inst.Click_evt("//lyte-drop-item[text()=' After ']");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			boolean month= driver_inst.pagecontent().contains("May");
			Assert.assertTrue(month);
			System.out.println("After filter work properly --Pass--");
		} catch (Exception e) {
			System.out.println("After filter work not properly --Fail--");
		}
		//- - - - - - - - - - -		Between date check 		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='CREATED TIME']");
			driver_inst.Click_evt("//span[text()=' After ']");
			driver_inst.Click_evt("//lyte-drop-item[text()=' Between ']");
			driver_inst.Click_evt("#lyteCalendarView");
			driver_inst.Click_evt(".lyteCalyearNavLft");
			driver_inst.Click_evt(".lyteCaldRgt");
			driver_inst.Click_evt(".lyteCaldRgt");
			driver_inst.Click_evt(".lyteCaldRgt");
			driver_inst.Click_evt(".lyteCaldRgt");
			driver_inst.Click_evt(".lyteCaldRgt");
			driver_inst.Click_evt("//span[text()='11']");
			String texts =driver_inst.Click_evt("#solutionDateFilterTo > div > input").getTagName();
			System.out.println(texts);
			//			driver_inst.Click_evt(".lyteCaldLft");
			//			driver_inst.Click_evt("//span[text()='1']");
			//			Thread.sleep(1000);
			//			driver_inst.Click_evt("//button[text()='Apply']");
			//			Thread.sleep(4000);
			//			boolean month= driver_inst.pagecontent().contains("May");
			//			Assert.assertTrue(month);
			System.out.println("Between filter work properly --Pass--");
		} catch (Exception e) {
			System.out.println(e);	
		}
	}
	//- - - - - - - - - - -		Score  		- - - - - - - - - - -
	public static void Score() {
		//- - - - - - - - - - -		Before Date		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("//span[text()='SCORE']");			
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input","0");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input","1");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(4000);
			boolean score_val= driver_inst.pagecontent().contains("0");
			Assert.assertTrue(score_val);
			System.out.println("Filter Score range 0 to 1: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filtered Score range 0 to 1: --Fail--");
		}
		//- - - - - - - - - - -		Above 10 score		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='SCORE']");			
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input","10");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input","20");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(2000);
			String score_val= driver_inst.selector("//div[text()='No Articles']").getText();
			Assert.assertEquals(score_val, score_val);
			System.out.println("Filter Score range 10 to 20: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filtered Score range 0 to 1: --Fail--");
		}
		//- - - - - - - - - - -		Above 30,000 score		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='SCORE']");			
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input","30000");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input","40000");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(2000);
			String score_val= driver_inst.selector("//div[text()='No Articles']").getText();
			Assert.assertEquals(score_val, score_val);
			System.out.println("Filter Score range 30,000 to 40,000: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filtered Score range 0 to 1: --Fail--");
		}
		//- - - - - - - - - - -		only put from score		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='SCORE']");			
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input","1");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(2000);
			boolean score_val_from= driver_inst.pagecontent().contains("1");
			Assert.assertTrue(score_val_from);
			System.out.println("Filter Score from range 1: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filter Score from range 1: --Fail--");
		}
		//- - - - - - - - - - -		only put from score		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='SCORE']");			
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input","10");
			driver_inst.Click_evt("//*[@id=\"filter\"]/div/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(2000);
			boolean score_val_to= driver_inst.pagecontent().contains("0");
			Assert.assertTrue(score_val_to);			
			System.out.println("Filter Score to range 10: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filter Score to range 10: --Fail--");
		}

	}
	//- - - - - - - - - - -		Score  		- - - - - - - - - - -
	public static void Views() {
		//- - - - - - - - - - -		Score from and to valid check		- - - - - - - - - - -
		try {
			driver_inst.Click_evt("//span[text()='VIEWS']");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[6]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input", "1");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[6]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input", "20");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(2000);
			boolean score_val_to= driver_inst.pagecontent().contains("17");
			Assert.assertTrue(score_val_to);			
			System.out.println("Filter views to range 1 to 20: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filter views to range 1 to 20: --Fail--");
		}
		//- - - - - - - - - - -		Score from(100) and to(200) 	- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='VIEWS']");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[6]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input", "100");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[6]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input", "200");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(2000);
			boolean score_val_to= driver_inst.pagecontent().contains("18");
			Assert.assertTrue(score_val_to);			
			System.out.println("Filter views to range 100 to 200: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filter views to range 100 to 200: --Fail--");
		}
		//- - - - - - - - - - -		Score from(30,000) and to(40,000) 	- - - - - - - - - - -
		try {
			driver_inst.Click_evt("#solution-filter");
			driver_inst.Click_evt("//span[text()='VIEWS']");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[6]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input", "30000");
			driver_inst.send_Val("//*[@id=\"filter\"]/div/lyte-accordion[6]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input", "40000");
			Thread.sleep(1000);
			driver_inst.Click_evt("//button[text()='Apply']");
			Thread.sleep(2000);
			boolean score_val_to= driver_inst.pagecontent().contains("17");
			Assert.assertTrue(score_val_to);			
			System.out.println("Filter views to range 30,000 to 40,000: --Pass--");
		} catch(Exception e) {
			System.out.println("Not Filter views to range 30,000 to 40,000: --Fail--");
		}
	}
	//- - - - - - - - - - - 	Quit		- - - - - - - -	
	public static void Quit() throws InterruptedException {
		driver_inst.Click_evt("div > .user-profile");
		driver_inst.wait_Click_evt("//button[text()='Sign Out']");
		driver_inst.quit_evt();
	}
}
