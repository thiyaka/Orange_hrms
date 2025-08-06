package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class TCC_001_Myinfo extends BaseTest {

	// Verify login with valid ESS username and valid password
	
	@Test
	public void verfiyLogin() {
		
		logger.info("*** Starting TCC_001_Myinfo ***");

		try {
		LoginPage lp= new LoginPage(driver);
		logger.info("Inside LoginPage");
		
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		HomePage hp= new HomePage(driver);
		logger.info("Inside HomePage");
		
		hp.clickUser();
		hp.clickLogout();
		}catch(Exception e) {
			Assert.fail();
		}
	
		finally{
		logger.info("*** Finished TCC_001_Myinfo ***");
		}
		
	}
}
