package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;
import pages.HomePage;
import pages.LoginPage;

@Listeners(Utility.Listeners.class)
public class HomePageTest extends Base {

	public HomePageTest() {
		super();
	}

	/**
	 * Method: To Run Initialize method before running each Testcases
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

	/**
	 * Method: To post image in facebook
	 * 
	 */

	@Test
	public void uploadImagePost() {
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomepageImagePost();

	}

	/**
	 * Method: To post video in facebook
	 * 
	 */

	@Test
	public void uploadVideoPost() {
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomePageVideoPost();
	}

	/**
	 * Method: To like post in facebook
	 * 
	 */

	@Test
	public void likePost() {
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomePageLikePost();
	}

	/**
	 * Method: To comment post in facebook
	 * 
	 */
	@Test
	public void commentPost() {
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomePageCommentPost();
	}

	/**
	 * Method: To update status in facebook
	 */
	@Test
	public void statusinfo() {
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomePageStatusInfo();
	}

	/**
	 * Method: To Run Terminate method after running each Testcases
	 */
	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {
		try {

			Thread.sleep(4000);
			util.closedriver();

		} catch (Exception e) {

		}
	}

}
