package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends LoginPage {

	@FindBy(xpath = "//span[contains(text(),'Photo/video')]")
	WebElement photovideobtn;

	@FindBy(xpath = " //span[contains(text(),'Add photos/videos')]")
	WebElement addbtn;

	@FindBy(xpath = "//span[contains(text(),'Post')]")
	WebElement postbtn;

	@FindBy(xpath = "//a[@aria-label='Bob Kumar']")
	WebElement profilebtn;
	
	@FindBy(xpath="//a[@aria-label='Notifications, 1 unread']")
	WebElement notificationbtn;
	
	@FindBy(xpath = "//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']")
	WebElement timelinebtn;

	@FindBy(xpath = "//div[@aria-label=\"What's on your mind, Bob?\"]")
	WebElement timelinebox;
	
	@FindBy(xpath = " //div[@aria-label='Feeling/activity']")
	WebElement feelingbtn;
	
	@FindBy(xpath = "//div[contains(text(),'happy')]")
	WebElement happybtn;
	
	@FindBy(xpath = "//i[@aria-label='Insert an emoji']")
	WebElement emojibtn;
	
	@FindBy(xpath = "//img[@alt='😊']")
	WebElement happyemojibtn;
	
	
	
	 
	/**
	 * Method: To post image in facebook
	 */
	public void userHomepageImagePost() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.visibilityOfAllElements(photovideobtn));
			photovideobtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(addbtn));
			addbtn.click();

			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\Autorun.exe")
					.waitFor(50, TimeUnit.SECONDS);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(postbtn));
			postbtn.click();
			Thread.sleep(10000);
			profilebtn.click();

		} catch (Exception e) {

		}
	}

	/**
	 * Method: To post video in facebook
	 */
	public void userHomePageVideoPost() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(photovideobtn));
			photovideobtn.click();
			wait.until(ExpectedConditions.visibilityOf(addbtn));
			addbtn.click();
			wait.until(ExpectedConditions.visibilityOf(addbtn));
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\autopostvideo.exe")
					.waitFor(50, TimeUnit.SECONDS);
			Thread.sleep(5000);
			postbtn.click();
			Thread.sleep(15000);
			driver.navigate().refresh();
			notificationbtn.click();
			Thread.sleep(2000);
			profilebtn.click();

		} catch (Exception e) {

		}
	}
	/**
	 * Method: To verify image post in facebook
	 */
	public String verifyImagePost() {
		WebElement img = driver.findElement(By.xpath("//a[@aria-label='1 m']"));

		String PostTime = img.getText();
		System.out.println(PostTime);
		return PostTime;
	}

	/**
	 * Method: To verify video  post in facebook
	 */
	public String verifyVideoPost() {
		WebElement img = driver.findElement(By.xpath("//a[@aria-label='1 m']"));

		String PostTime = img.getText();
		System.out.println(PostTime);
		return PostTime;
	}

	/**
	 * Method: To verify Status post in facebook
	 */
	public String verifyStatusPost() {
		WebElement img = driver.findElement(By.xpath("//a[@aria-label='1 m']"));

		String PostTime = img.getText();
		System.out.println(PostTime);
		return PostTime;
	}

	/**
	 * Method: To Update Status in facebook
	 */
	public void userHomePageStatusInfo() {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(timelinebtn));
		timelinebtn.click();
		wait.until(ExpectedConditions.visibilityOf(timelinebox));
		timelinebox.sendKeys("Good morning");
		postbtn.click();
	}
}
