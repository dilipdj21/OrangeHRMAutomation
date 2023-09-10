package com.orangeHRM.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.base;
import com.orangeHRM.qa.pages.AddEmployeePage;
import com.orangeHRM.qa.pages.EmergencyContactsPage;
import com.orangeHRM.qa.pages.HomePage;
import com.orangeHRM.qa.pages.LoginPage;

public class EmergencyContactsTest extends base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validUsername"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnPIM();
		AddEmployeePage addemployee = new AddEmployeePage(driver);
		addemployee.clickOnAddEmployee();
		addemployee.enterFirstName("Andy");
		addemployee.enterMiddleName("S");
		addemployee.enterEnterLastName("Guest");
		addemployee.savebutton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void AddValidEmergencyContactAndAttachment() throws InterruptedException {

		EmergencyContactsPage emergencycontact = new EmergencyContactsPage(driver);
		emergencycontact.clickOnEmergencyContactButton();
		emergencycontact.clickOnAssignedEmergencyContacts();
		emergencycontact.enterName("Sara Jane");
		emergencycontact.enterRelationship("Husband");
		emergencycontact.enterHomeNumber("001-98762535343");
		emergencycontact.enterMobileNumber("9987654321");
		emergencycontact.enterWorkNumber("001-42545");
		emergencycontact.clickOnSaveButton();
		Thread.sleep(5000);
		emergencycontact.clickOnAddAttachment();
		emergencycontact.clickOnBrowse("/Users/noonacademy/eclipse-workspace/OrangeHRMAutomation/Upload/lamp.jpeg");
		emergencycontact.enterComment("Added the attachment successfully");
		Thread.sleep(3000);
		emergencycontact.clickOnSavebuttonFinal();
	}
}
