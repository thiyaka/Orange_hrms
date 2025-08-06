package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDetailsPage;

public class TCC_004_Myinfo extends BaseTest {

	// Verify ESS user can edit Personal Details

	@Test
	public void verifyPersonalDetails_update() {

		logger.info("*** Starting TCC_004_Myinfo ***");

		try {
			LoginPage lp = new LoginPage(driver);
			logger.info("Inside LoginPage");

			lp.setUsername(p.getProperty("username"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			HomePage hp = new HomePage(driver);
			logger.info("Inside HomePage");

			hp.clickMyinfo();

			PersonalDetailsPage personalDetails = new PersonalDetailsPage(driver);
			logger.info("Inside PersonalDetailsPage");

			personalDetails.setFirstName("Walter");
			personalDetails.setMiddleName("Harveld");
			personalDetails.setLastName("White");
		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("*** Finished TCC_004_Myinfo ***");
		}

	}

}
