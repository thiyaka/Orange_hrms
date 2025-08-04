package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class TCC_001_LOGIN_01 extends BaseTest {

	@Test
	public void verfiyLogin() {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
	}
}
