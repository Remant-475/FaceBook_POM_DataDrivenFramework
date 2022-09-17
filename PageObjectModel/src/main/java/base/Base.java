package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class Base {

	protected static WebDriver driver;
	protected static WebElement element;
	protected static FileInputStream file;
	protected static Properties prop;
	protected static utility util;
	protected static FileInputStream excelfile;
	protected static XSSFWorkbook xWorkBook;
	protected static XSSFSheet xSheet;
	protected static Object[][] data;
	protected static LoginPage loginp;
	protected static String message;
	static {

		WebDriverManager.chromedriver().setup();
	}
	protected final static String FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "repository" + File.separator
			+ "LoginTestData.xlsx";
 
	public Base() {
		try {
			prop = new Properties();
			file = new FileInputStream(
					"C:\\Users\\ASUS\\eclipse-workspace\\PageObjectModel\\src\\main\\resources\\config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
