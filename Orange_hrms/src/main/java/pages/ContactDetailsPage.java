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

	@FindBy(xpath = "//label[text()='Street 1']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtStreet1;

	@FindBy(xpath = "//label[text()='Street 2']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtStreet2;

	@FindBy(xpath = "//label[text()='City']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtCity;

	@FindBy(xpath = "//label[text()='State/Province']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtState;

	@FindBy(xpath = "//label[text()='Zip/Postal Code']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtZipCode;

	@FindBy(xpath = "//label[text()='Home']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtHomeNumber;

	@FindBy(xpath = "//label[text()='Mobile']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtMobileNumber;

	@FindBy(xpath = "//label[text()='Work']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtWorkNumber;

	@FindBy(xpath = "//label[text()='Work Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtWorkEmail;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//div[contains(@class,'oxd-toast--success')]")
	WebElement successToast;

	@FindBy(xpath = "//p[contains(@class,'oxd-text--toast-message')]")
	WebElement successMessageText;
	
	@FindBy(css = "div.oxd-form-loader")
	private WebElement formLoader;


	public void setStreet1(String streetName1) {
		
		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtStreet1, streetName1, 10);
	}

	public void setStreet2(String streetName2) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtStreet2, streetName2, 10);
	}

	public void setCity(String cityName) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtCity, cityName, 10);
	}

	public void setState(String stateName) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtState, stateName, 10);
	}

	public void setZipCode(String zipCode) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtZipCode, zipCode, 10);
	}

	public void setHomeNumber(String homeNumber) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtHomeNumber, homeNumber, 10);
	}

	public void setMobileNumber(String mobileNumber) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtMobileNumber, mobileNumber, 10);

	}

	public void setWorkNumber(String workNumber) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtWorkNumber, workNumber, 10);
	}

	public void setWorkEmail(String workEmail) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtWorkEmail, workEmail, 10);
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
