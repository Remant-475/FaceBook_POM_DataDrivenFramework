package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends LoginPage {

	@FindBy(xpath = "//span[contains(text(),'Photo/video')]")
	WebElement photovideobtn;

	@FindBy(xpath = " //span[contains(text(),'Add photos/videos')]")
	WebElement addbtn;

	@FindBy(xpath = "//span[contains(text(),'Post')]")
	WebElement postbtn;

	@FindBy(xpath = "//div[@aria-label='Write a comment']")
	WebElement commentbox;

	@FindBy(xpath = "(//div[@aria-label='Like'])")
	WebElement likebtn;
	
	@FindBy(xpath="//div[@class='rtxb060y hpj0pwwo lc19xlkw l4uc2m3f mfclru0v t7p7dqev']")
	WebElement timelinebtn;
	
	@FindBy(xpath="//p[@class='cr00lzj9 kmwttqpk kjdc1dyq l7ghb35v m8h3af8h']")
	WebElement timelinebox;

	/**
	 * Method: To post image in facebook
	 */
	public void userHomepageImagePost() {
		try {
			emailId.sendKeys(prop.getProperty("emailId"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			password.sendKeys(prop.getProperty("password"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			loginBtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			homebtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			photovideobtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			addbtn.click();
			Thread.sleep(5000);
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\Autorun.exe")
					.waitFor(50, TimeUnit.SECONDS);
			Thread.sleep(5000);
			postbtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {

		}
	}

	/**
	 * Method: To post video in facebook
	 */
	public void userHomePageVideoPost() {
		try {
			emailId.sendKeys(prop.getProperty("emailId"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			password.sendKeys(prop.getProperty("password"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			loginBtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			homebtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			photovideobtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			addbtn.click();
			Thread.sleep(5000);
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\\\autopost.exe")
					.waitFor(50, TimeUnit.SECONDS);
			Thread.sleep(5000);
			postbtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {

		}
	}
	
	/**
	 * Method: To Like post in facebook
	 */
	
	public void userHomePageLikePost() {
		emailId.sendKeys(prop.getProperty("emailId"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		password.sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		homebtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		likebtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * Method: To comment post in facebook
	 */
	public void userHomePageCommentPost() {
		try {
			emailId.sendKeys(prop.getProperty("emailId"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			password.sendKeys(prop.getProperty("password"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			loginBtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			homebtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			commentbox.sendKeys("nice");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
	
	public void userHomePageStatusInfo() {
		emailId.sendKeys(prop.getProperty("emailId"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		password.sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		homebtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		timelinebtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		timelinebox.sendKeys("Goodmorning");
		postbtn.click();
	}
}
