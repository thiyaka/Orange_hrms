package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactDetailsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyinfoPage;

public class TCC_005_Myinfo extends BaseTest {

	@Test
	public void verify_MobileNumber_Update() {
		logger.info("*** Starting TCC_005_Myinfo_ verify_MobileNumber_Update ***");

		try {
			LoginPage lp = new LoginPage(driver);
			logger.info("Inside LoginPage");
			lp.setUsername(p.getProperty("username"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			HomePage hp = new HomePage(driver);
			logger.info("Inside HomePage");

			hp.clickMyinfo();

			MyinfoPage mfPage = new MyinfoPage(driver);
			logger.info("Inside MyinfoPage");

			mfPage.clickContactDetails();

			ContactDetailsPage contactDetails = new ContactDetailsPage(driver);
			logger.info("updating ContactDetails");

			contactDetails.setStreet1("Vivekanandar theru");

			contactDetails.setStreet2("Dubai Main Road");

			contactDetails.setCity("Madurai");

			contactDetails.setState("Tamil Nadu");

			contactDetails.setZipCode("625001");

			contactDetails.setHomeNumber("0001000299");

			contactDetails.setMobileNumber("+91 998474847");

			contactDetails.setWorkNumber("112-002-999");

			contactDetails.setWorkEmail("GBU@osohrm.com");

			contactDetails.clickSave();

			Assert.assertTrue(contactDetails.isSuccessMessageDisplayed(),
					"Success message not displayed after saving contact details");

		} catch (Throwable t) {
			logger.error("Test failed", t);
			throw t; // VERY IMPORTANT
		} finally {
			logger.info("*** Finished TCC_005_Myinfo ***");
		}

	}
}
