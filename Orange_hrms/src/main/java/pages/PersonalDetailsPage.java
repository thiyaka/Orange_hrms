package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ReusableUtilities;

public class PersonalDetailsPage extends BasePage {

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[contains(normalize-space(.), 'Personal')]")
	WebElement txtPersonalTitle;

	@FindBy(name = "firstName")
	WebElement txtFirstName;

	@FindBy(name = "middleName")
	WebElement txtMiddleName;

	@FindBy(name = "lastName")
	WebElement txtLastName;

	@FindBy(css = "div.oxd-form-loader")
	private WebElement formLoader;

	@FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtEmployeeID;

	@FindBy(xpath = "//label[text()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtOtherID;

	@FindBy(xpath = "//label[contains(text(),'Driver')]/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtDLNumber;

	@FindBy(xpath = "//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
	WebElement dpdwnNationality;

	@FindBy(xpath = "//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
	WebElement dpdwnMaritalStatus;

	@FindBy(xpath = "//label[text()='Blood Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
	WebElement dpdwnBloodGroup;

	@FindBy(xpath = "//div[@class='oxd-form-actions']/p/following-sibling::button")
	WebElement btnSave;

	@FindBy(xpath = "//div[contains(@class,'oxd-toast--success')]")
	WebElement successToast;

	@FindBy(xpath = "//p[contains(@class,'oxd-text--toast-message')]")
	WebElement successMessageText;

	@FindBy(xpath = "//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtDoB;

	@FindBy(xpath = "//label[text()='License Expiry Date']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txtLicenseExpiry;

	@FindBy(xpath = "//div[contains(@class,'oxd-toast-content')]//p")
	private List<WebElement> successMessages;

	@FindBy(xpath = "//h6[text()='Custom Fields']/following::div[@class='oxd-form-actions']//button")
	WebElement btnsave_customFields;

	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addAttachButton;

	@FindBy(xpath = "//input[@type='file']")
	WebElement fileUploadInputBy1;

	@FindBy(xpath = "//button[text()=' Cancel ']/ancestor::div[@class='oxd-form-actions']//button[normalize-space()='Save']")
	WebElement saveAttachmentBtn;
	
	private By fileUploadInputBy = By.xpath("//input[@type='file']");

	public String readTitle() {
		String PageTitle = txtPersonalTitle.getText();
		return PageTitle;
	}

	public void setFirstName(String firstname) {
		/*
		 * txtFirstName.clear(); txtFirstName.sendKeys(firstname);
		 */

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtFirstName, firstname, 10);
	}

	public void setMiddleName(String middlename) {
		/*
		 * txtMiddleName.clear(); txtMiddleName.sendKeys(middlename);
		 */

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtMiddleName, middlename, 10);
	}

	public void setLastName(String lastname) {
		/*
		 * txtLastName.clear(); txtLastName.sendKeys(lastname);
		 */
		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtLastName, lastname, 10);
	}

	public void setEmployeeID(String empID) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtEmployeeID, empID, 10);
	}

	public void setOtherID(String oID) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtOtherID, oID, 10);
	}

	public void setDLNumber(String DL) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.clearAndType(driver, txtDLNumber, DL, 10);
	}

	public void selectNationality(String nationality) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.waitForElementToBeClickable(driver, dpdwnNationality, 10);
		ReusableUtilities.selectFromCustomDropdown(dpdwnNationality, nationality, driver);
	}

	public void selectMaritalStatus(String maritalStatus) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.waitForElementToBeClickable(driver, dpdwnMaritalStatus, 10);
		ReusableUtilities.selectFromCustomDropdown(dpdwnMaritalStatus, maritalStatus, driver);
	}

	private By genderLabel(String gender) {
		return By.xpath("//div[contains(@class,'oxd-radio-wrapper')]//label[normalize-space()='" + gender + "']");
	}

	public void selectGender(String gender) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);

		WebElement label = ReusableUtilities.waitForElementToBeClickable(driver, genderLabel(gender), 10);

		// find the actual radio input inside label
		WebElement radioInput = label.findElement(By.tagName("input"));

		if (!radioInput.isSelected()) {
			label.click(); // click label, not input (more stable)
		}
	}

	public boolean isGenderSelected(String gender) {

		WebElement input = driver.findElement(By.xpath("//label[normalize-space()='" + gender + "']//input"));
		return input.isSelected();
	}

	public void selectBloodGroup(String bloodGroup) {

		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.waitForElementToBeClickable(driver, dpdwnBloodGroup, 10);
		ReusableUtilities.selectFromCustomDropdown(dpdwnBloodGroup, bloodGroup, driver);
	}

	public void submitPersonalDetails() {

		WebElement saveBtn = ReusableUtilities.waitForElementToBeClickable(driver, btnSave, 10);

		saveBtn.click();
	}

	/*
	 * public boolean isSuccessMessageDisplayed() {
	 * 
	 * ReusableUtilities.waitForSuccessmsg(driver, successToast, 10);
	 * 
	 * return successMessageText.getText().equalsIgnoreCase("Successfully Updated");
	 * }
	 * 
	 * public boolean isSuccessMessageDisplayed1() {
	 * 
	 * ReusableUtilities.waitForSuccessmsg(driver, successToast, 10);
	 * 
	 * return successMessageText.getText().equalsIgnoreCase("Successfully Saved"); }
	 */

	/*
	 * public void setDoB1(String doB) {
	 * 
	 * ReusableUtilities.waitForFormToLoad(driver, formLoader);
	 * 
	 * ReusableUtilities.waitForElementToBeClickable(driver, txtDoB, 10);
	 * txtDoB.click();
	 * 
	 * ReusableUtilities.clearAndType(driver, btnSave, doB, 10);
	 * 
	 * }
	 */

	public void setDoB(String dob) {
		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.setDateUsingJS(driver, txtDoB, dob);
	}

	public void setLicenseExpiry(String licenseExpiry) {
		ReusableUtilities.waitForFormToLoad(driver, formLoader);
		ReusableUtilities.setDateUsingJS(driver, txtLicenseExpiry, licenseExpiry);
	}

	public boolean waitForSuccessMessage(String expectedText, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		return wait.until(driver -> successMessages.stream()
				.anyMatch(msg -> msg.getText().trim().equalsIgnoreCase(expectedText)));
	}

	public void submitCustomFields() {

		WebElement customfield_Submit = ReusableUtilities.waitForElementToBeClickable(driver, btnsave_customFields, 10);
		customfield_Submit.click();

	}
	
	public void uploadAttachment(String filePath) {

		ReusableUtilities.waitForElementToBeClickable(driver, addAttachButton, 10).click();

		WebElement fileInput = ReusableUtilities.waitForElementPresence(driver, fileUploadInputBy, 10);

		fileInput.sendKeys(filePath);

		ReusableUtilities.waitForElementToBeClickable(driver, saveAttachmentBtn, 10).click();
	}

}
