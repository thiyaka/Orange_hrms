package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDetailsPage;

public class TCC_003_Myinfo extends BaseTest {

	// Verify ESS user is able to view Personal Details

	@Test
	public void verifyPersonalDetails() {

		logger.info("*** Starting TCC_003_Myinfo ***");

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

			String actualTitle = personalDetails.readTitle();
			String expectedTitle = "Personal Details";

			assertEquals(actualTitle, expectedTitle, "Page title does not match the expected value");
		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("*** Finished TCC_003_Myinfo ***");
		}

	}

}
