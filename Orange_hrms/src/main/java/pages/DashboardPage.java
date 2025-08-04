package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@class=\"oxd-userdropdown-tab\"]")
	WebElement dropdownuser;
	
	@FindBy(xpath="//*[@class=\"oxd-dropdown-menu\"]/li[4]")
	WebElement btnLogout;
	
	public void clickUser() {
		dropdownuser.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}

}
