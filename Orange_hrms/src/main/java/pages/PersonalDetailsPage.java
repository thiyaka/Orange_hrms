package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage extends BasePage {

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h6[contains(normalize-space(.), 'Personal')]")
	WebElement txtPersonalTitle;
	
	@FindBy(xpath="//*[@placeholder=\"First Name\"]")
	WebElement txtFirstName;
	
	@FindBy(name="//*[@placeholder=\"Middle Name\"]")
	WebElement txtMiddleName;
	
	@FindBy(name="//*[@placeholder=\"Last Name\"]")
	WebElement txtLastName;
	
	public String readTitle() {
		String PageTitle= txtPersonalTitle.getText();
		return PageTitle;
	}
	
	public void setFirstName(String firstname) {
		txtFirstName.clear();
		txtFirstName.sendKeys(firstname);
	}
	
	public void setMiddleName(String middlename) {
		txtMiddleName.clear();
		txtMiddleName.sendKeys(middlename);
	}
	
	public void setLastName(String lastname) {
		txtLastName.clear();
		txtLastName.sendKeys(lastname);
	}
	
	
	
	
}

