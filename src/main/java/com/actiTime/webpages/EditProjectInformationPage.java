package com.actiTime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.Base;


public class EditProjectInformationPage {
    @FindBy(xpath="//input[@value='Delete This Project']")
	private WebElement DeleteProjectButton;
	
	public EditProjectInformationPage()
	{
		PageFactory.initElements(Base.driver, this);
	}
	public void OKDeletePopup()
	{
		Base.driver.switchTo().alert().accept();
	}
	public void clickOnDeleteProjectButton()
	{
		DeleteProjectButton.click();
	}
}
