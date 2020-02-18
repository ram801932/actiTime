package com.actiTime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.Base;



public class AddNewCustomerPage {
	@FindBy(name="name")
	 private WebElement customerNameTextField;
		@FindBy(name="createCustomerSubmit")
	 private WebElement createCustomerButton;
	 
		public AddNewCustomerPage()
		{
			PageFactory.initElements(Base.driver, this);
		}
	 public void enterCustomerName(String s)
	 {
		 customerNameTextField.sendKeys(s);
	 }
	 public void clickOnCreateCustomerButton()
	 {
		createCustomerButton.click(); 
	 }

}
