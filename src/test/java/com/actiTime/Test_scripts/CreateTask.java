package com.actiTime.Test_scripts;

import org.testng.annotations.Test;

import com.actiTime.Utilities.Base;
import com.actiTime.webpages.AddNewTasksPage;
import com.actiTime.webpages.OpenTaskPage;



public class CreateTask extends Base{
	@Test
	public void testCreateTask()
	{
	OpenTaskPage otp=new OpenTaskPage();
	otp.clickOnAddNewTaskButton();
	AddNewTasksPage antp=new AddNewTasksPage();
	antp.SelectCustomerDropdown("ram2");
	antp.SelectProjectDropdown("my project");
	antp.enterTaskTextField("completeTask");
	antp.clickOnCreateTaskButton();
	otp.retrieveSuccessMessage();
	}
}
