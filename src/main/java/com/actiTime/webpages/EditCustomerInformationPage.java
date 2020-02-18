package com.actiTime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.Base;



public class EditCustomerInformationPage {
	 @FindBy(xpath="//input[@value='Delete This Customer']")
		private WebElement deleteCustomerButton;
	  
	   public  EditCustomerInformationPage()
	   {
		   PageFactory.initElements(Base.driver, this);
	   }
	   
	   
	   public void OKDeleteCustomer()
	   {
		  Base.driver.switchTo().alert().accept();
	   }
	   public void CancelDeleteCustomer()
	   {
		   Base.driver.switchTo().alert().dismiss();
	   }

	public void clickOnDeleteCustomerButton() {
		
		deleteCustomerButton.click();
	}


}
