package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContactsPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@role='tablist']//div[3]")
	private WebElement emergencyContactButton;

	@FindBy(xpath = "(//div[@class='orangehrm-action-header']//i)[1]")
	private WebElement assignedEmergencyContacts;

	@FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[1]")
	private WebElement namefield;

	@FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[2]")
	private WebElement relationshipField;

	@FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[3]")
	private WebElement homeTelephoneField;

	@FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[4]")
	private WebElement mobileField;

	@FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[5]")
	private WebElement workTelephoneField;

	@FindBy(xpath = "(//div[@class='oxd-form-actions']//button)[2]")
	private WebElement saveButton;

	@FindBy(xpath = "(//div[@class='orangehrm-action-header']//i)[2]")
	private WebElement addAttachment;

	@FindBy(xpath = "//div//input[@type='file']")
	private WebElement browse;
	
	@FindBy(xpath = "//div//textarea")
	private WebElement commentArea;

	@FindBy(xpath = "(//div[@class='oxd-form-actions']//button)[2]")
	private WebElement saveButtonfinal;
	
	

	public EmergencyContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnEmergencyContactButton() {
		emergencyContactButton.click();
	}

	public void clickOnAssignedEmergencyContacts() {
		assignedEmergencyContacts.click();
	}

	public void enterName(String name) {
		namefield.sendKeys(name);
	}

	public void enterRelationship(String relationship) {
		relationshipField.sendKeys(relationship);
	}

	public void enterHomeNumber(String homenumber) {
		homeTelephoneField.sendKeys(homenumber);
	}

	public void enterMobileNumber(String mobilenumber) {
		mobileField.sendKeys(mobilenumber);
	}

	public void enterWorkNumber(String worknumber) {
		workTelephoneField.sendKeys(worknumber);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnAddAttachment() {
		addAttachment.click();	
	}
	
	public void clickOnBrowse(String path) {
		browse.sendKeys(path);	
	}
	
	public void enterComment(String comment) {
		commentArea.sendKeys(comment);	
	}
	
	public void clickOnSavebuttonFinal() {
		saveButtonfinal.click();
	}

	

}
