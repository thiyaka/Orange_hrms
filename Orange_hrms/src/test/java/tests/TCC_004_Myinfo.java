package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDetailsPage;

public class TCC_004_Myinfo extends BaseTest {

	//Verify ESS user can edit Personal Details

	
	@Test
	public void verifyPersonalDetails_update() {

		LoginPage lp = new LoginPage(driver);

		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();

		HomePage hp = new HomePage(driver);

		hp.clickMyinfo();

		PersonalDetailsPage personalDetails = new PersonalDetailsPage(driver);
		
		personalDetails.setFirstName("Walter");
		personalDetails.setMiddleName("Harveld");
		personalDetails.setLastName("White");
		
	}

}
