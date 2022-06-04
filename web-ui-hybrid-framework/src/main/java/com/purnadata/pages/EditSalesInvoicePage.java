package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditSalesInvoicePage {
	
	public EditSalesInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "bill_to_address")
	public WebElement txtBox_billAddress;
	
	@FindBy(id = "contc_person")
	public WebElement txtBox_contPerson;
	
	@FindBy(id = "btn")
	public WebElement btn_update;
	
}
