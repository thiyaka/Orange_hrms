package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDetailsPage;

public class TCC_004_Myinfo extends BaseTest {

	// Verify ESS user can edit Personal Details

	@Test
	public void verifyPersonalDetails_update() {

		logger.info("*** Starting TCC_004_Myinfo ***");

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

		personalDetails.setFirstName(p.getProperty("firstName"));
		personalDetails.setMiddleName(p.getProperty("middleName"));
		personalDetails.setLastName(p.getProperty("lastName"));
		personalDetails.setEmployeeID(p.getProperty("emplId"));
		personalDetails.setOtherID(p.getProperty("otherId"));
		personalDetails.setDLNumber(p.getProperty("LicenseNumber"));
		personalDetails.setLicenseExpiry(p.getProperty("LicenseExpiry"));
		personalDetails.selectNationality(p.getProperty("Nationality"));
		personalDetails.selectMaritalStatus(p.getProperty("MaritalStatus"));
		personalDetails.setDoB(p.getProperty("DateofBirth"));
		personalDetails.selectGender(p.getProperty("Gender"));

		personalDetails.submitPersonalDetails();

		Assert.assertTrue(personalDetails.waitForSuccessMessage("Successfully Updated", 10),
				"Contact details update success message not displayed");

		personalDetails.selectBloodGroup(p.getProperty("BloodGroup"));
		personalDetails.submitCustomFields();

		Assert.assertTrue(personalDetails.waitForSuccessMessage("Successfully Saved", 10),
				"Contact details update success message not displayed");

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\resume.pdf";

		personalDetails.uploadAttachment(filePath);

		Assert.assertTrue(personalDetails.waitForSuccessMessage("Successfully Saved", 10),
				"File upload success message not displayed");

	}

}