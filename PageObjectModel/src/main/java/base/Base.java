package base;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FindFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MarketPlacePage;
import pages.ProfilePage;
public class Base {

	protected static WebDriver driver;
	protected static WebElement element;
	protected static FileInputStream file;
	protected static FileInputStream file1;
	protected static Properties prop;
	protected static Properties prop1;
	protected static utility util;
	protected static FileInputStream excelfile;
	protected static XSSFWorkbook xWorkBook;
	protected static XSSFSheet xSheet;
	protected static Object[][] data;
	protected static LoginPage loginp;
	protected static String message;
	protected static ProfilePage profileP;
	protected static HomePage homeP;
	protected static FindFriendPage findfriend;
	protected static MarketPlacePage marketp;
	
	static {

		WebDriverManager.chromedriver().setup();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	        System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	

	protected final static String FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "repository" + File.separator
			+ "LoginTestData.xlsx";
	
	/**
	 * Constructor: To Load the Properties file in file.io
	 */
	
	public Base() {
		try {
			prop = new Properties();
			file = new FileInputStream(
					".\\src\\main\\resources\\repository\\config.properties");
			prop.load(file);
			
			prop1 = new Properties();
			file1 = new FileInputStream(
					".\\src\\main\\resources\\log4j.properties");
			prop1.load(file1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
