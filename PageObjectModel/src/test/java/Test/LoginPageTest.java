package Test;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;

import pages.LoginPage;

public class LoginPageTest extends Base {

	public LoginPageTest() {

		super();
	}

	
	final static Logger log = Logger.getLogger(LoginPageTest.class);

	/**
	 * Method: To Run Initialize method before running each Testcases and To Open
	 * browser
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
	 * Method: To Test Login Page is working or not using config file
	 */

	//@Test(priority = 1)
	public void validLoginPagewithConfigDataTest() {

		log.info(
				"****************************** starting test case for validating login page using config file *****************************************");

		loginp = new LoginPage();
		loginp.LoginUser();
		String homePageTitle = loginp.verifyHomePage();
		assertEquals(homePageTitle, "Facebook");

	}

	
	/**
	 * Method: To Test Login Page is working or not using XLSX file
	 */


	 //@Test(priority = 2)
	
	public void validLoginPageWithXlsxDataTest() {
		log.info("****************************** starting test case for validating login page using XLSX file *****************************************");
		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();
		;
		String homePageTitle = loginp.verifyHomePage();
		assertEquals(homePageTitle, "Facebook");

	}

	/**
	 * Method: To Test Login Page is giving error message or not while inserting wrong crediantials
	 */

	@Test(priority = 3)
	public void validateInvalidLoginCred() {
		loginp = new LoginPage();
		message = loginp.validateInvalidLoginCred();

		assertEquals(message, "he password that you've entered is incorrect. Forgotten password?");

	}

	/**
	 * Method: To Run Terminate method after running each Testcases
	 */

	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {
		log.info("****************************End Test Case****************************");
		try {

			Thread.sleep(4000);
			util.closedriver();

		} catch (Exception e) {

		}
	}
}
