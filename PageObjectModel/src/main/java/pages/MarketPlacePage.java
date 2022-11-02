package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPlacePage extends LoginPage {

	@FindBy(xpath = "//span[text()='Marketplace']")
	WebElement marketplacebtn;
	@FindBy(xpath = "(//input[@aria-label='Search Marketplace'])[1]")
	WebElement searchbar;

	public void userMarketPlace() {
		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			homebtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(marketplacebtn));
			marketplacebtn.click();

			wait.until(ExpectedConditions.visibilityOfAllElements(searchbar));
			searchbar.sendKeys("mobile");

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method: To verify Marketplace page in facebook
	 */
	public String verifyMarketplacePage() {
		String marketplaceTitle = driver.getTitle();
		return marketplaceTitle;
	}
}
