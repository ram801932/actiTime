package com.actiTime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.actiTime.Utilities.Base;



public class AddNewProjectPage {
	@FindBy(name="customerId")
	WebElement customerDropdown;
	
	@FindBy(name="name")
	WebElement projectNameTextfield;
	
	@FindBy(name="createProjectSubmit")
	WebElement createProjectButton;
	
	public AddNewProjectPage()
	{
		PageFactory.initElements(Base.driver, this);
	}
	
	public void selectCustomerDropdown(String customerName)
	{
		Select s1=new Select(customerDropdown);
		s1.selectByVisibleText(customerName);
	}
	public void enterProjectNameTextfield(String projectName)
	{
		projectNameTextfield.sendKeys(projectName);
		
	}
	public void clickOnCreateProjectButton()
	{
		createProjectButton.click();
	}
}
