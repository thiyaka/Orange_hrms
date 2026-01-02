package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ReusableUtilities;

public class ContactDetailsPage extends BasePage {

	public ContactDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[text()='Mobile']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtMobileNumber;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//div[contains(@class,'oxd-toast--success')]")
	WebElement successToast;

	@FindBy(xpath = "//p[contains(@class,'oxd-text--toast-message')]")
	WebElement successMessageText;

	public void setMobileNumber(String number) {

		ReusableUtilities.clearAndType(driver, txtMobileNumber, number, 10);

	}

	public void clickSave() {

		WebElement saveBtn = ReusableUtilities.waitForElementToBeClickable(driver, btnSave, 10);

		saveBtn.click();
	}

	public boolean isSuccessMessageDisplayed() {

		ReusableUtilities.waitForSuccessmsg(driver, successToast, 10);

		return successMessageText.getText().equalsIgnoreCase("Successfully Updated");
	}

}
