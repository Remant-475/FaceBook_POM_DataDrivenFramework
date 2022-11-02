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
import pages.ProfilePage;

@Listeners(Utility.Listeners.class)
public class ProfilePageTest extends Base {

	public ProfilePageTest() {
		super();
	}
	
	final static Logger log = Logger.getLogger(ProfilePageTest.class);
	/**
	 * Method: To Run Initialize method before running each Testcases
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
	 * Method: To upload profile picture in facebook
	 */
	@Test(priority=3)
	public void UploadProfileImage() {
		log.info("****************************** starting test case for updating profile picture  *****************************************");
		loginp=new LoginPage();
		loginp.LoginUser();
		profileP = new ProfilePage();
		profileP.uploadUserProfileImage();
		
		String PostTime=profileP.verifyProfileImagePost();
		System.out.println("posting time : "+ PostTime);
		assertEquals(PostTime,"1 m");

	}
	
	/**
	 * Method: To like Post in facebook
	 */
	@Test(priority=1)
	public void likePost() {
		log.info(
				"****************************** starting test case for Liking the post  *****************************************");
		loginp=new LoginPage();
		loginp.LoginUser();
		profileP = new ProfilePage();
		profileP.userLikePost();
	}

	/**
	 * Method: To comment post in facebook
	 * 
	 */
	@Test(priority=2)
	
	public void commentPost() {
		log.info(
				"****************************** starting test case for commenting the post  *****************************************");
		loginp=new LoginPage();
		loginp.LoginUser();
		profileP = new ProfilePage();
		profileP.userCommentPost();
		
	}

	
	/**
	 * Method: To Run Terminate method after running each Testcases
	 */

	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {
		log.info(
				"****************************** Terminating the Browser  *****************************************");

		try {
			
			Thread.sleep(4000);
			util.closedriver();

		} catch (Exception e) {

		}
	}
}
