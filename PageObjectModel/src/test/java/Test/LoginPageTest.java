package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;
import pages.LoginPage;

public class LoginPageTest extends Base {

	public LoginPageTest() {

		super();
	}

	@BeforeMethod
	public void triggerDriver() {
		try {
			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	@Test(priority=0)
//	public void validateTextBoxAllignentTest() {
//		loginp = new LoginPage();
//		loginp.validTextboxAlignment();
//	}

	@Test(priority=1)
	public void validLoginPagewithConfigDataTest() {

		loginp = new LoginPage();
		loginp.LoginUser();
		String homePageTitle = loginp.verifyHomePage();
		assertEquals(homePageTitle, "Facebook – log in or sign up");

	}
	@Test(priority=2)
	public void validLoginPageWithXlsxDataTest() {

		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();;
		String homePageTitle = loginp.verifyHomePage();
		assertEquals(homePageTitle, "Facebook – log in or sign up");

	}
	@Test
	public void validateInvalidLoginCred() {
		loginp = new LoginPage();
		message=loginp.validateInvalidLoginCred();
		
		assertEquals(message, "The password that you've entered is incorrect. Forgotten password?");
		
	}
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
