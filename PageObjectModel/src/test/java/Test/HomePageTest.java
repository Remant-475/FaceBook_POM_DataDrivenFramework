package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;
import pages.HomePage;

public class HomePageTest extends Base{

	public HomePageTest() {
		super();
	}
	
	/**Method: To Run Initialize method before running each Testcases
	 * 
	 */
	@BeforeMethod
	public void triggerDriver() {
		try {
			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**Method: To post image in facebook
	 * 
	 */
	
	@Test
	public void uploadImagePost() {
		homeP=new HomePage();
		homeP.userHomepageImagePost();
		
	}
	
	/**Method: To post video in facebook
	 * 
	 */
	
	@Test
	public void uploadVideoPost() {
		homeP=new HomePage();
		homeP.userHomePageVideoPost();
	}
	
	
	/**Method: To like post in facebook
	 * 
	 */
	
	@Test
	public void likePost() {
		homeP=new HomePage();
		homeP.userHomePageLikePost();
	}
	
	/**Method: To comment post in facebook
	 * 
	 */
	@Test
	public void commentPost() {
		homeP=new HomePage();
		homeP.userHomePageCommentPost();
	}
	
	@Test
	public void statusinfo() {
		homeP=new HomePage();
		homeP.userHomePageStatusInfo();
	}
}


