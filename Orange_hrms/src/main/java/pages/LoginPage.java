package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//*[@name='username']")
	WebElement txtusername;
	
	@FindBy(xpath = "//*[@name='password']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//*[contains(@class,'orangehrm-login-button')]")
	WebElement btnLogin;
	
	
	public void setUsername(String username) {
		txtusername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtpassword.sendKeys(password);;
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	
	

}
