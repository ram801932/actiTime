package com.actiTime.Customer_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.actiTime.Utilities.Base;
import com.actiTime.Utilities.Excel;
import com.actiTime.webpages.ActiveProjectsAndCustomersPage;
import com.actiTime.webpages.EditCustomerInformationPage;
import com.actiTime.webpages.OpenTaskPage;



public class DeleteCustomer extends Base{
	@Test
	public  void testDeleteCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		OpenTaskPage otp =new OpenTaskPage();
		otp.clickOnProjectsAndCustomersLink();
		ActiveProjectsAndCustomersPage apac= new ActiveProjectsAndCustomersPage();
		apac.clickOnCustomer(Excel.readdata("Sheet1", 1, 3));
		EditCustomerInformationPage eci=new EditCustomerInformationPage();
		eci.clickOnDeleteCustomerButton();
		WebDriverWait w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.alertIsPresent());
		eci.OKDeleteCustomer();
		log.info("=================DELETED CUSTOMER SUCCESSFULLY=================");
		String s=apac.retrieveSuccessMessage();
		System.out.println(s);
	}
}
