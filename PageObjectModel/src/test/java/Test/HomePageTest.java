package Test;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
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

	final static Logger log = Logger.getLogger(HomePageTest.class);
	/**
	 * Method: To Run Initialize method before running each Testcases
	 * 
	 */
	@BeforeMethod
	public void triggerDriver() {
		log.info("****************************** Starting browser  *****************************************");
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

	@Test(priority=1)
	public void uploadImagePost() {
		log.info(
				"****************************** starting test case for posting image  *****************************************");
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomepageImagePost();
		
		String PostTime=homeP.verifyImagePost();
		System.out.println("posting time : "+ PostTime);
		assertEquals(PostTime,"1 m");

	}

	/**
	 * Method: To post video in facebook
	 * 
	 */

	@Test(priority=2)
	public void uploadVideoPost() {
		log.info(
				"****************************** starting test case for posting video  *****************************************");
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomePageVideoPost();
		
		
		String PostTime=homeP.verifyVideoPost();
		System.out.println("posting time : "+ PostTime);
		assertEquals(PostTime,"1 m");
	}
	


	
	/**
	 * Method: To update status in facebook
	 */
	@Test(priority=3)
	public void statusinfo() {
		log.info(
				"****************************** starting test case for updating the status  *****************************************");
		loginp=new LoginPage();
		loginp.LoginUser();
		homeP = new HomePage();
		homeP.userHomePageStatusInfo();
		
		String PostTime=homeP.verifyStatusPost();
		System.out.println("posting time : "+ PostTime);
		assertEquals(PostTime,"1 m");
		
	}

	/**
	 * Method: To Run Terminate method after running each Testcases
	 */
	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {
		try {
			log.info(
					"****************************** Terminating the Browser  *****************************************");

			Thread.sleep(4000);
			util.closedriver();

		} catch (Exception e) {

		}
	}

}
