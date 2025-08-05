package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class TCC_001_Myinfo extends BaseTest {

	// Verify login with valid ESS username and valid password
	
	@Test
	public void verfiyLogin() {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		HomePage hp= new HomePage(driver);
		hp.clickUser();
		hp.clickLogout();
		//hp.clickMyinfo();
		
	}
}
