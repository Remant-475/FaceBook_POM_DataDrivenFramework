package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class ProfilePage extends LoginPage{

	
	@FindBy(xpath ="//a[@aria-label='Bridgelabz Demo']")
	WebElement profilebtn;
	
	@FindBy(xpath= "//div[@aria-label='Update profile picture']")
	WebElement upldbtn;
	
	@FindBy(xpath="//div[@aria-label='Upload Photo']")
	WebElement uploadphotobtn;
	
	@FindBy(xpath="//div[@aria-label='Save']")
	WebElement savebtn;
	
	
	/**
	 * Method: To Upload profile image of user in facebook
	 */
	public void uploadUserProfileImage() {
		try {
			WebDriverWait wait= new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.visibilityOf(profilebtn));
			profilebtn.click();
			wait.until(ExpectedConditions.visibilityOf(upldbtn));
			upldbtn.click();
			wait.until(ExpectedConditions.visibilityOf(uploadphotobtn));
			uploadphotobtn.click();
			Runtime.getRuntime().exec("C:\\Users\\ASUS\\eclipse-workspace\\PageObjectModel\\src\\main\\resources\\repository\\Autorun.exe");
			wait.until(ExpectedConditions.visibilityOf(savebtn));
			savebtn.click();
			
		
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}