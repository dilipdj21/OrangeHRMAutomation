package com.orangeHRM.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.base;
import com.orangeHRM.qa.pages.LoginPage;
import com.orangeHRM.qa.utils.Utilities;

public class LoginTest extends base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

//	@Test
	public void verifyLoginwithValidCredentials() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validUsername"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();

	}

	@Test(dataProvider = "validCredentialSupplier")
	public void verifyLoginwithValidCredentialsWithExcel(String Username, String Password) {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Username);
		loginpage.enterPassword(Password);
		loginpage.clickOnLoginButton();

	}

	@DataProvider(name = "validCredentialSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;

	}

}
