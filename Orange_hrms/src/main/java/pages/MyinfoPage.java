package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyinfoPage extends BasePage {

	public MyinfoPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(),'Personal Details')]")
	WebElement btnPersonalDetails;
	
	@FindBy(xpath="//a[normalize-space()='Contact Details']")
	WebElement btnContactDetails;
	
	public void clickPersonalDetails() {
		btnPersonalDetails.click();
	}
	
	public void clickContactDetails() {
		btnContactDetails.click();
		
	}
	
	
}
