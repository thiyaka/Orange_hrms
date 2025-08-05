package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyinfoPage extends BasePage {

	public MyinfoPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(),'Personal Details')]")
	WebElement btnPersonaldetails;
	
	public void clickPersonalDetails() {
		btnPersonaldetails.click();
	}
}
