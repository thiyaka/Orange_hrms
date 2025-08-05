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
	
	public String readTitle() {
		String PageTitle= txtPersonalTitle.getText();
		return PageTitle;
	}
}

