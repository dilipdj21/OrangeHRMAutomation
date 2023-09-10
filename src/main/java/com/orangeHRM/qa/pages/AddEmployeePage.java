package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {

	WebDriver driver;

	// Objects

	@FindBy(xpath = "(//nav[@role='navigation'])[2]//li[3]//a")
	private WebElement addemployeebutton;

	@FindBy(name = "firstName")
	private WebElement firstnamefield;

	@FindBy(name = "middleName")
	private WebElement middleNamefield;

	@FindBy(name = "lastName")
	private WebElement lastNamefield;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;

	public AddEmployeePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddEmployee() {
		addemployeebutton.click();

	}

	public void enterFirstName(String fname) {
		firstnamefield.sendKeys(fname);
	}

	public void enterMiddleName(String mname) {
		middleNamefield.sendKeys(mname);
	}

	public void enterEnterLastName(String lname) {
		lastNamefield.sendKeys(lname);
	}

	public void savebutton() {
		savebutton.click();

	}

}
