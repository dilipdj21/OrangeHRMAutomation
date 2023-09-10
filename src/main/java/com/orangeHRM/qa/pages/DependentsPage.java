package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DependentsPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@role='tablist']//div[4]")
	private WebElement dependentsButton;

	@FindBy(xpath = "(//div[@class='orangehrm-action-header']//i)[1]")
	private WebElement addAssignedDependents;

	@FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space']//div[2]//input)[1]")
	private WebElement namefield;

	@FindBy(xpath = "//div[@class='oxd-select-text--after']//i")
	private WebElement relationshipDropdown;

	@FindBy(xpath = "//div[@role='listbox']//div[2]")
	private WebElement relationshipSelect;

	@FindBy(xpath = "//div[@class='oxd-date-input']//input")
	private WebElement DOB;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "(//div[@class='orangehrm-action-header']//i)[2]")
	private WebElement addAttachment;

	@FindBy(xpath = "//div//input[@type='file']")
	private WebElement browse;

	@FindBy(xpath = "//div//textarea")
	private WebElement commentArea;

	@FindBy(xpath = "(//div[@class='oxd-form-actions']//button)[2]")
	private WebElement saveButtonfinal;

	public DependentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnDependentsButton() {
		dependentsButton.click();
	}

	public void clickOnAssignedDependentss() {
		addAssignedDependents.click();
	}

	public void enterName(String name) {
		namefield.sendKeys(name);
	}

	public void clickRelationship() {
		relationshipDropdown.click();
	}

	public void selectRelationshipDropdown() {
		relationshipSelect.click();
	}

	public void enterDOB(String dob) {
		DOB.sendKeys(dob);
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
