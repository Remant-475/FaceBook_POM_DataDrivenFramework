package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;
import pages.LoginPage;
import pages.ProfilePage;

@Listeners(Utility.Listeners.class)
public class ProfilePageTest extends Base {

	public ProfilePageTest() {
		super();
	}
	/**
	 * Method: To Run Initialize method before running each Testcases
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
	 * Method: To upload profile picture in facebook
	 */
	@Test
	public void UploadProfileImage() {
		loginp=new LoginPage();
		loginp.LoginUser();
		profileP = new ProfilePage();
		profileP.uploadUserProfileImage();

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
