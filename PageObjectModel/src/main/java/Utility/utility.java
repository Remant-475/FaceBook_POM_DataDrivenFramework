package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.Base;

public class utility extends Base {

	/**
	 * Method: To Initialize the WebDriver 
	 */
	public static void intilization(String browser) {
		try {
			
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get(prop.getProperty("baseURL"));
				
			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get(prop.getProperty("baseURL"));
			} else {
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get(prop.getProperty("baseURL"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Object[][] getloginData() {

		try {
			excelfile = new FileInputStream(FILE_PATH);
			xWorkBook = new XSSFWorkbook(excelfile);
			xSheet = xWorkBook.getSheet("LoginData");
			int lastrow = xSheet.getLastRowNum();

			data = new Object[lastrow][2];
			int k = 0;
			for (int i = 1; i <= lastrow; i++) {

				String username = xSheet.getRow(i).getCell(k).getStringCellValue();
				String password = xSheet.getRow(i).getCell(k + 1).getStringCellValue();
				System.out.println("Row" + i + "Username" + username);
				System.out.println("Row" + i + "Password" + password);
				System.out.println();

				data[i][0] = username;
				data[i][1] = password;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	/**
	 * Method: To read data from XLSX file
	 */
	public static List<List<String>> excelreader() throws IOException {

		List<List<String>> values = new LinkedList<List<String>>();
		File file = new File(FILE_PATH);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("LoginData");

		int rowCOunt = sheet.getLastRowNum();

		for (int i = 1; i <= rowCOunt; i++) {

			int cellCount = sheet.getRow(i).getLastCellNum();
			List<String> val = new LinkedList<String>();
			for (int j = 0; j < cellCount; j++) {
				val.add(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			values.add(val);
		}
		return values;
	}

	
	/**
	 * Method: To Take Screenshot 
	 */
	public static void takeScreenshot() {
		try {
		Date date=new Date(); 
		//print actual date
		String date1=date.toString();
		System.out.println("Date is:" +date1);
		String date2=date1.replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./Screenshot/"+ date2 +"_HomePage.png");
		
		FileUtils.copyFile(srcFile, destFile);
	}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Method: To close driver
	 */
	
	public static void closedriver() {

		try {
			Thread.sleep(3000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String RandomString() {
        String randomString = null;
        try {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            randomString = "";
            int length = 5;
            //crate random string object.
            Random rand = new Random();
            //character array ie each index has a value.bcz fill that array random characters
            char[] text = new char[length];
            //add individual int character
for (int i = 0; i < length; i++) {
                //genrate random index numbers.
                text[i] = characters.charAt(rand.nextInt(characters.length()));
            }
            //text array adding each char one by one to randomstring util array is done
            for (int i = 0; i < text.length; i++) {
                randomString += text[i];
            }
            System.out.println("Random :"+randomString);

        } catch (Exception e) {
            e.printStackTrace();
        }
return randomString;



    }
}
