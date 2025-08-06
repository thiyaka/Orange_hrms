package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataProviders.Login_Dataprovider;
import pages.HomePage;
import pages.LoginPage;

public class TCC_002_Myinfo extends BaseTest {

	// Verify login with DataDriven approach

	@Test(dataProvider = "LoginData", dataProviderClass = Login_Dataprovider.class)
	public void verifyLogin_DDT(String uname, String psw, String res) {

		logger.info("*** Starting TCC_002_Myinfo ***");

		try {
			LoginPage lp = new LoginPage(driver);
			logger.info("Inside LoginPage");

			lp.setUsername(uname);
			lp.setPassword(psw);
			lp.clickLogin();

			HomePage dp = new HomePage(driver);
			logger.info("Inside HomePage");

			boolean targetpage = dp.isMyAccountPageExists();

			if (res.equalsIgnoreCase("valid")) {
				if (targetpage = true) {
					dp.clickUser();
					dp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (res.equalsIgnoreCase("invalid")) {
				if (targetpage = true) {
					dp.clickUser();
					dp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		finally {
			logger.info("*** Finished TCC_002_Myinfo ***");
		}
	}
}
