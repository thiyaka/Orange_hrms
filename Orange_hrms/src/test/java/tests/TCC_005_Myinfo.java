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

			ContactDetailsPage cDP = new ContactDetailsPage(driver);
			logger.info("Inside ContactDetailsPage");

			cDP.setMobileNumber("+91 998474847");

			cDP.clickSave();

			Assert.assertTrue(cDP.isSuccessMessageDisplayed(),
					"Success message not displayed after saving contact details");

		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("*** Finished TCC_005_Myinfo ***");
		}

	}
}
