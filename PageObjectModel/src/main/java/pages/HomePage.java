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

	@FindBy(xpath = "//div[@aria-label='Write a comment']")
	WebElement commentbox;

	@FindBy(xpath = "(//div[@aria-label='Like'] div[contains(text(),'Captain rohit sharma')])")
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

			WebDriverWait wait= new WebDriverWait(driver,30);
			
			wait.until(ExpectedConditions.visibilityOf(photovideobtn));
			photovideobtn.click();
			
			addbtn.click();
			wait.until(ExpectedConditions.visibilityOf(addbtn));
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\Autorun.exe")
					.waitFor(50, TimeUnit.SECONDS);
			
			postbtn.click();
			wait.until(ExpectedConditions.visibilityOf(postbtn));
			
		} catch (Exception e) {

		}
	}

	/**
	 * Method: To post video in facebook
	 */
	public void userHomePageVideoPost() {
		try {
			WebDriverWait wait= new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.visibilityOf(photovideobtn));
			photovideobtn.click();
			wait.until(ExpectedConditions.visibilityOf(addbtn));
			addbtn.click();
			wait.until(ExpectedConditions.visibilityOf(addbtn));
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\\\autopost.exe")
					.waitFor(50, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(postbtn));
			postbtn.click();
			
			
		} catch (Exception e) {

		}
	}
	
	/**
	 * Method: To Like post in facebook
	 */
	
	public void userHomePageLikePost() {
		
		
		WebDriverWait wait= new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(likebtn));
		likebtn.click();
	}
	
	/**
	 * Method: To comment post in facebook
	 */
	public void userHomePageCommentPost() {
		try {
			
			WebDriverWait wait= new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.visibilityOf(commentbox));
			commentbox.sendKeys("nice");
			
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Method: To Update Status in facebook
	 */
	public void userHomePageStatusInfo() {
		
		WebDriverWait wait= new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(timelinebtn));
		timelinebtn.click();
		wait.until(ExpectedConditions.visibilityOf(timelinebox));
		timelinebox.sendKeys("Goodmorning");
		wait.until(ExpectedConditions.visibilityOf(postbtn));
		postbtn.click();
	}
}
