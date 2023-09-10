package com.orangeHRM.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.base;
import com.orangeHRM.qa.pages.AddEmployeePage;
import com.orangeHRM.qa.pages.DependentsPage;
import com.orangeHRM.qa.pages.HomePage;
import com.orangeHRM.qa.pages.LoginPage;

public class DependentsTest extends base {

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
	public void AddValidDependantAndAttachment() throws InterruptedException {

		DependentsPage dependentspage = new DependentsPage(driver);
		dependentspage.clickOnDependentsButton();
		dependentspage.clickOnAssignedDependentss();
		dependentspage.enterName("John cena");
		dependentspage.clickRelationship();
		Thread.sleep(3000);
		dependentspage.selectRelationshipDropdown();
		Thread.sleep(3000);
		dependentspage.enterDOB("2000-10-21");
		dependentspage.clickOnSaveButton();

		dependentspage.clickOnAddAttachment();

		dependentspage.clickOnBrowse("/Users/noonacademy/eclipse-workspace/OrangeHRMAutomation/Upload/lamp.jpeg");
		dependentspage.enterComment("Added the attachment successfully");
		Thread.sleep(3000);
		dependentspage.clickOnSavebuttonFinal();
	}

}
