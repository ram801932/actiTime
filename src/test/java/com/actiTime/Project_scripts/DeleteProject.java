package com.actiTime.Project_scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.actiTime.Utilities.Base;
import com.actiTime.webpages.ActiveProjectsAndCustomersPage;
import com.actiTime.webpages.EditProjectInformationPage;
import com.actiTime.webpages.OpenTaskPage;



public class DeleteProject extends Base {
	 @Test
		public void testDeleteProject()
		{
			OpenTaskPage otp=new OpenTaskPage();
			otp.clickOnProjectsAndCustomersLink();
			ActiveProjectsAndCustomersPage apac=new ActiveProjectsAndCustomersPage();
			apac.clickOnProject();
			EditProjectInformationPage epi=new EditProjectInformationPage();
			epi.clickOnDeleteProjectButton();
			WebDriverWait w=new WebDriverWait(Base.driver,30);
			w.until(ExpectedConditions.alertIsPresent());
			epi.OKDeletePopup();
			String s=apac.retrieveSuccessMessage();
			System.out.println(s);
		}
}
