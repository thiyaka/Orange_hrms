package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@class='oxd-topbar-body']//following::span[normalize-space(text())='User Management']")
	WebElement dropdownUserManagement;

	@FindBy(xpath = "//*[@class='oxd-topbar-body']//following::a[normalize-space(text())='Users']")
	WebElement btnUsers;
	
	@FindBy(xpath="//*[@class='orangehrm-header-container']//button[normalize-space(text()='Add')]")
	WebElement btnAdduser;
	
	//*[@class='oxd-select-text-input']/ancestor::div[@class='oxd-form-row']//label[normalize-space(text()='User Role')]


	public void clickUserManagement() {
		dropdownUserManagement.click();
	}

	public void clickUsers() {
		btnUsers.click();
	}
	
	public void clickAddUser() {
		btnAdduser.click();
	}

}
