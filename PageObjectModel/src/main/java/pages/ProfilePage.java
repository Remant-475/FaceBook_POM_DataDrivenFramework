package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.utility;
import base.Base;

public class ProfilePage extends LoginPage{

	
	@FindBy(xpath ="//a[@aria-label='Bob Kumar']")
	WebElement profilebtn;
	
	@FindBy(xpath= "//div[@aria-label='Update profile picture']")
	WebElement upldbtn;
	
	@FindBy(xpath="//div[@aria-label='Upload Photo']")
	WebElement uploadphotobtn;
	
	@FindBy(xpath = "//div[@aria-label='Write a comment']")
	WebElement commentbox;

	@FindBy(xpath = "(//span[contains(text(),'Like')])[1]")
	WebElement likebtn;
	
	@FindBy(xpath="//div[@class='rtxb060y hpj0pwwo lc19xlkw l4uc2m3f mfclru0v t7p7dqev']")
	WebElement timelinebtn;
	
	@FindBy(xpath="//p[@class='cr00lzj9 kmwttqpk kjdc1dyq l7ghb35v m8h3af8h']")
	WebElement timelinebox;
	
	@FindBy(xpath = "(//span[contains(text(),'Like')])[1][@style='color: rgb(32, 120, 244);']")
    WebElement alreadylikeBtn;
	
	
	
	@FindBy(xpath="//div[@aria-label='Save']")
	WebElement savebtn;
	
	
	final static Logger log = Logger.getLogger(ProfilePage.class);
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
			
			Runtime.getRuntime()
			.exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\Autorun.exe")
			.waitFor(50, TimeUnit.SECONDS);
			
			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.visibilityOf(savebtn));
			savebtn.click();
			Thread.sleep(1000);
			driver.navigate().refresh();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Method: To like post in facebook
	 * 
	 */
public void userLikePost() {
		
		
		WebDriverWait wait= new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfAllElements(profilebtn));
		profilebtn.click();
		
		String like =likebtn.getAttribute("style");
		
		switch (like) {
		case "color: rgb(32, 120, 244);":
			log.warn("post is already liked");
			
			break;

		default:
			likebtn.click();
			log.info("post is liked");
			break;
		}
}
	
	/**
	 * Method: To comment post in facebook .
	 */
	public void userCommentPost() {
		try {
			
			WebDriverWait wait= new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.visibilityOfAllElements(profilebtn));
			profilebtn.click();
			
			String random=utility.RandomString();
			wait.until(ExpectedConditions.visibilityOfAllElements(commentbox));
			commentbox.sendKeys(random);
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
	String comment=profileP.verifycommentPost();
	Assert.assertEquals(comment,random);
			
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Method: To verify comment in facebook .
	 */
	public String verifycommentPost() {
		WebElement comm=driver.findElement(By.xpath("(//ul)[2]/li[last()]/div/div/div/div/div/div/div/div/div/span/div/div"));
		
		String comment=comm.getText();
		System.out.println(comment);
		return comment;
	}
	
	/**
	 * Method: To verify Profile image post in facebook
	 */
	public String verifyProfileImagePost() {
		WebElement img = driver.findElement(By.xpath("//a[@aria-label='1 m']"));

		String PostTime = img.getText();
		System.out.println(PostTime);
		return PostTime;
	}
	
}