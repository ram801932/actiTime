package com.actiTime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.Base;

public class OpenTaskPage {
	@FindBy(linkText="Projects & Customers")
	private WebElement ProjectsAndCustomerLink;
	
	@FindBy(linkText="delete")
	private WebElement deleteLink;
	
	@FindBy(xpath="//input[@value='Add New Tasks']")
	private WebElement AddNewTaskButton;
	
	@FindBy(className="successmsg")
	private WebElement successMessage;
	
	public  OpenTaskPage()
	{
	PageFactory.initElements(Base.driver, this);
	
	}
	public void clickOnProjectsAndCustomersLink()
	{
		
	 ProjectsAndCustomerLink.click();
	 
	}
	public void clickOnAddNewTaskButton()
	{
		AddNewTaskButton.click();
	}
	public String retrieveSuccessMessage()
	{ String s=successMessage.getText();
		System.out.println();
		return s;
	}
	
	public void clickOnDeleteLink()
	{
		deleteLink.click();
	}
	
	public void clickOKDeletePopup()
	{
		Base.driver.switchTo().alert().accept();
	}

}
