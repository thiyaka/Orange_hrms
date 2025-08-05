package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@class=\"oxd-userdropdown-tab\"]")
	WebElement dropdownuser;
	
	@FindBy(xpath="//*[@class=\"oxd-dropdown-menu\"]/li[4]")
	WebElement btnLogout;
	
	@FindBy(xpath="//*[@class='oxd-sidepanel-body']//ul//li//span[text()='My Info']")
	WebElement btnMyinfo;
	
	public void clickUser() {
		dropdownuser.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	public void clickMyinfo() {
		btnMyinfo.click();
	}

}
