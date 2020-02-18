package com.actiTime.Test_scripts;

import org.testng.annotations.Test;

import com.actiTime.Utilities.Base;
import com.actiTime.webpages.ActiveProjectsAndCustomersPage;
import com.actiTime.webpages.OpenTaskPage;


public class DeleteTask extends Base {
	@Test
	public void testDeleteTask()
	{
		OpenTaskPage otp=new OpenTaskPage();
		otp.clickOnProjectsAndCustomersLink();
		ActiveProjectsAndCustomersPage apac=new ActiveProjectsAndCustomersPage();
		apac.clickOnTasks();
		otp.clickOnDeleteLink();
		otp.clickOKDeletePopup();
		String s=otp.retrieveSuccessMessage();
		System.out.println(s);
	}

}
