package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDetailsPage;

public class TCC_003_Myinfo_01 extends BaseTest {
	
	@Test
	public void verifyPersonalDetails() {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		HomePage hp= new HomePage(driver);
		
		hp.clickMyinfo();
		
		PersonalDetailsPage personalDetails= new PersonalDetailsPage(driver);
		
		String actualTitle= personalDetails.readTitle();
		String expectedTitle="Personal Details";
		
		assertEquals(actualTitle, expectedTitle, "Page title does not match the expected value");
	}

}
