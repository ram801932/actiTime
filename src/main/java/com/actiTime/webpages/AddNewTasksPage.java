package com.actiTime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.actiTime.Utilities.Base;



public class AddNewTasksPage {
	@FindBy(name = "customerId")
	private WebElement Customer;

	@FindBy(name = "projectId")
	private WebElement Project;
	
	@FindBy(name="task[0].name")
	private WebElement TaskTextField;
	
	@FindBy(xpath="//input[@value='Create Tasks']")
	private WebElement CreateTaskButton;

	public AddNewTasksPage() {
		PageFactory.initElements(Base.driver, this);
	}

	public void SelectCustomerDropdown(String CustomerName) {
		Select s=new Select(Customer);
		s.selectByVisibleText(CustomerName);
	}

	public void SelectProjectDropdown(String ProjectName) {
    Select s=new Select(Project);
    s.selectByVisibleText(ProjectName);
	}
	public void enterTaskTextField(String TaskName)
	{
		TaskTextField.sendKeys(TaskName);
	}
	public void clickOnCreateTaskButton()
	{
		CreateTaskButton.click();
	}
}
