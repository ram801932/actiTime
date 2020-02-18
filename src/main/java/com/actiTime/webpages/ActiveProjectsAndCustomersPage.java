package com.actiTime.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.Base;



public class ActiveProjectsAndCustomersPage {
	@FindBy(xpath = "//input[@value='Add New Customer']")
	private WebElement addNewCustomerButton;

	@FindBy(className = "successmsg")
	private WebElement successMessage;

	//@FindBy(linkText = "ram3") // Have to change every time to delete
    //private WebElement existedCustomer;

	@FindBy(linkText = "project20") // Have to change every time to delete
	private WebElement existedProject;

	@FindBy(linkText="1")            // Have to change every time to delete
	private WebElement existedTask;
	
	@FindBy(xpath = "//input[@value='Add New Project']")
	private WebElement addNewProjectButton;

	public ActiveProjectsAndCustomersPage() {
		PageFactory.initElements(Base.driver, this);
	}

	public void clickOnAddNewCustomerButton() {
		addNewCustomerButton.click();
	}

	public String retrieveSuccessMessage() {
		String s = successMessage.getText();
		return s;

	}

	public void clickOnProject() {
		existedProject.click();
	}

	public void clickOnCustomer(String customerName) {
		Base.driver.findElement(By.linkText(customerName)).click();
	}

	public void clickOnAddNewProjectButton() {
		// TODO Auto-generated method stub
		addNewProjectButton.click();
	}
	public void clickOnTasks()
	{
		existedTask.click();
	}

}
