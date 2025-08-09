package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminPage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;


public class TCC_001_Admin extends BaseTest {
	
	@Test
	public void verifyAddingNewUser() {
		logger.info("*** Starting TCC_001_Admin ***");

		LoginPage lp= new LoginPage(driver);
		logger.info("Inside LoginPage");
		
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		HomePage hp= new HomePage(driver);
		logger.info("Inside HomePage");
		
		hp.clickAdmin();
		
		AdminPage ap= new AdminPage(driver);
		logger.info("Inside AdminPage");
		
		ap.clickUserManagement();
		ap.clickUsers();
		ap.clickAddUser();

		
	} 	
	

}
