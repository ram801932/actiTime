package com.actiTime.Project_scripts;

import org.testng.annotations.Test;

import com.actiTime.Utilities.Base;
import com.actiTime.webpages.ActiveProjectsAndCustomersPage;
import com.actiTime.webpages.AddNewProjectPage;
import com.actiTime.webpages.OpenTaskPage;



public class CreateProject extends Base{
	@Test
	public void testCreateProject()
	{
		OpenTaskPage otp =new OpenTaskPage();
		otp.clickOnProjectsAndCustomersLink();
		ActiveProjectsAndCustomersPage apac = new ActiveProjectsAndCustomersPage();
		apac.clickOnAddNewProjectButton();
		AddNewProjectPage anp=new AddNewProjectPage();
		anp.selectCustomerDropdown("ram2");
	    anp.enterProjectNameTextfield("project20");
	    anp.clickOnCreateProjectButton();
	    String s=apac.retrieveSuccessMessage();
	    System.out.println(s);
	}

}
