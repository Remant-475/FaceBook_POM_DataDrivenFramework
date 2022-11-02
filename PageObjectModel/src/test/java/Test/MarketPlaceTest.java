package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;
import pages.FindFriendPage;
import pages.LoginPage;
import pages.MarketPlacePage;

public class MarketPlaceTest extends Base {
	public MarketPlaceTest() {
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
	 * Method: To search things in market place
	 * 
	 */
	@Test
	public void Market() {
		
		
		loginp=new LoginPage();
		loginp.LoginUser();
		marketp = new MarketPlacePage();
		marketp.userMarketPlace();
		String findfriendTitle = loginp.verifyHomePage();
		assertEquals(findfriendTitle, "Facebook Marketplace | Facebook");
		
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
