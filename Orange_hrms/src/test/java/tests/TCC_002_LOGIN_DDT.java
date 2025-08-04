package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import dataProviders.Login_Dataprovider;
import pages.DashboardPage;
import pages.LoginPage;

public class TCC_002_LOGIN_DDT extends BaseTest {
	
	@Test(dataProvider = "LoginData", dataProviderClass = Login_Dataprovider.class)
	public void verifyLogin_DDT(String uname, String psw) {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUsername(uname);
		lp.setPassword(psw);
		lp.clickLogin();
		
		DashboardPage dp= new DashboardPage(driver);
		dp.clickUser();
		dp.clickLogout();
	}
	
		

}
