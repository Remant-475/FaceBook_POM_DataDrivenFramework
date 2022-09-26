package Test;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.utility;
import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends Base {

	static {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}
	
	/**
	 * Method: To Run Initialize method before running each Testcases
	 */
	
	@BeforeClass
	public void triggerDriver() {
		try {
			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@DataProvider(name = "LoginData")
	public Object[][] dataTest() {
		Object[][] data = new Object[2][2];
		data[0][0] = "mayuresh.sonar@gmail.com";
		data[0][1] = "Password1234567899";
		return data;

	}

	/**
	 * Method: To 
	 */
	@Test
	public void Login() {
		try {
			List<List<String>> values = new LinkedList<List<String>>();
			values.addAll(utility.excelreader());

			String url = prop.getProperty("baseURL");
			driver.get(url);
			System.out.println("Values from exel fle username:" + values.get(0).get(0));
			driver.findElement(By.id("email")).sendKeys(values.get(0).get(0));
			System.out.println("Values from exel fle password:" + values.get(0).get(1));
			driver.findElement(By.id("pass")).sendKeys(values.get(0).get(1));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	/**
	 * Method: To Run Terminate method after running each Testcases
	 */

	@SuppressWarnings("static-access")
	@AfterClass
	public void terminateDriver() {
		try {

			Thread.sleep(4000);
			util.closedriver();
		} catch (Exception e) {

		}
	}
}
