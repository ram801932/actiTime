package com.actiTime.Customer_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.actiTime.Utilities.Base;
import com.actiTime.Utilities.Excel;
import com.actiTime.webpages.ActiveProjectsAndCustomersPage;
import com.actiTime.webpages.AddNewCustomerPage;
import com.actiTime.webpages.OpenTaskPage;



public class CreateCustomer extends Base{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
			OpenTaskPage otp=new OpenTaskPage();
			 otp.clickOnProjectsAndCustomersLink();
			 ActiveProjectsAndCustomersPage apac=new ActiveProjectsAndCustomersPage();
			 apac.clickOnAddNewCustomerButton();
			 AddNewCustomerPage ancp=new AddNewCustomerPage();
			 String s=Excel.readdata("Sheet1", 1, 0);
			 ancp.enterCustomerName(s);
			 ancp.clickOnCreateCustomerButton();
			 log.info("===========CREATED CUSTOMER SUCCESSFULLY==============");
			 String s1=apac.retrieveSuccessMessage();	
		     System.out.println(s1);
	}
}
