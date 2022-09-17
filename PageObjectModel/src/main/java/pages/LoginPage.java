package pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.utility;
import base.Base;

public class LoginPage extends Base {

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(name = "pass")
	WebElement password;

	@FindBy(name = "login")
	WebElement loginBtn;

	@FindBy(xpath = "//a[aria-label='Home']")
	WebElement homebtn;

	@FindBy(xpath = "//div[@class=\"clearfix _5466 _44mg\"]/div[2]")
	WebElement ErrorMsg;
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void LoginUser() {
		try {
			emailId.sendKeys(prop.getProperty("emailId"));
			Thread.sleep(500);
			password.sendKeys(prop.getProperty("password"));
			Thread.sleep(500);
			loginBtn.click();
			homebtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LoginUserUsingXlsx() {
		try {
			List<List<String>> values= new LinkedList<List<String>>();
			values.addAll(utility.excelreader());
			emailId.sendKeys(values.get(0).get(0));
			Thread.sleep(500);
			password.sendKeys(values.get(0).get(1));
			Thread.sleep(500);
			loginBtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String validateInvalidLoginCred() {
		try {
			List<List<String>> values= new LinkedList<List<String>>();
			values.addAll(utility.excelreader());
			emailId.sendKeys(values.get(1).get(0));
			Thread.sleep(500);
			password.sendKeys(values.get(1).get(1));
			Thread.sleep(500);
			loginBtn.click();
			
			message=ErrorMsg.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	public void validTextboxAlignment() {
		try {
			int us_X = emailId.getLocation().getX();
			int us_width = emailId.getSize().getWidth();
			int us_height = emailId.getSize().getHeight();

			int pass_X = password.getLocation().getX();
			int pass_width = password.getSize().getWidth();
			int pass_height = password.getSize().getHeight();

			if (us_X == pass_X && us_width == pass_width && us_height == pass_height) {
				System.out.println("EmailId and Password text box are in allignment");
			} else {
				System.out.println("EmailId and Password text box are not in allignment");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String verifyHomePage() {
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}

}