package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFriendPage extends LoginPage {
	
	@FindBy(xpath = "//span[text()='Find friends']")
	WebElement findfriendbtn;
	@FindBy(xpath = "//span[text()='Suggestions']")
	WebElement suggestionsbtn;
	
	/**
	 * Method: To Find Friend in facebook
	 */
	public void userFindFriend() {
		WebDriverWait wait = new WebDriverWait(driver,40);
		
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			homebtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(findfriendbtn));
			findfriendbtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(suggestionsbtn));
			suggestionsbtn.click();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method: To verify friend page
	 */
	public String verifyFindFriendPage() {
		String findfriendTitle = driver.getTitle(); 
		return findfriendTitle;
	}

}
