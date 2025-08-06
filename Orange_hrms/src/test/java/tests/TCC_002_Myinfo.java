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

		try {
			LoginPage lp = new LoginPage(driver);

			lp.setUsername(uname);
			lp.setPassword(psw);
			lp.clickLogin();

			HomePage dp = new HomePage(driver);

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
	}
}
