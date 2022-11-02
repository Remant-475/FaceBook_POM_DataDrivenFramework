package Test;

import static org.testng.Assert.assertEquals;

import java.lang.System.Logger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;
import pages.FindFriendPage;
import pages.LoginPage;

@Listeners(Utility.Listeners.class)
public class FindFriendTest extends Base{
	public FindFriendTest() {
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
	 * Method: To find friend in facebook
	 */
	@Test
	public void FriendFindPost() {
		
		
		loginp=new LoginPage();
		loginp.LoginUser();
		findfriend = new FindFriendPage();
		findfriend .userFindFriend();
		String findfriendTitle = loginp.verifyHomePage();
		assertEquals(findfriendTitle, "Friends | Facebook");
		
	}
	
	/**
	 * Method: To Run Terminate method after running each Testcases
	 */
	@AfterMethod
	@SuppressWarnings("static-access")
	public void terminateDriver() {
		
		try {
			Thread.sleep(2000);
			util.closedriver();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}