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

		//try {
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

			contactDetails.setStreet1(p.getProperty("Street1"));

			contactDetails.setStreet2(p.getProperty("Street2"));

			contactDetails.setCity(p.getProperty("City"));

			contactDetails.setState(p.getProperty("State"));

			contactDetails.setZipCode(p.getProperty("ZipCode"));

			contactDetails.setHomeNumber(p.getProperty("HomeNumber"));

			contactDetails.setMobileNumber(p.getProperty("MobileNumber"));

			contactDetails.setWorkNumber(p.getProperty("WorkNumber"));

			contactDetails.setWorkEmail(p.getProperty("WorkEmail"));
			
			contactDetails.selectCountry(p.getProperty("country"));
			
			contactDetails.clickSave();

			Assert.assertTrue(contactDetails.isSuccessMessageDisplayed(),
					"Success message not displayed after saving contact details");

			/*
			 * } catch (Throwable t) { logger.error("Test failed", t); throw t; // VERY
			 * IMPORTANT } finally { logger.info("*** Finished TCC_005_Myinfo ***"); }
			 */

	}
}
