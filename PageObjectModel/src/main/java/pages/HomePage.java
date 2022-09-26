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

	@FindBy(xpath = "(//div[@aria-label='Like'])[3]")
	WebElement likebtn;

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
}
