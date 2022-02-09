package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingInvoicePage {
	public EditingInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="item_no")
	WebElement txtBox_item_no;
	
	@FindBy(id="unit")
	WebElement txtBox_unit;
	
	@FindBy(id="btn_save_item1")
	WebElement btn_updatesalesitem;
	
	
   @FindBy(id="btn")
    WebElement btn_update;
}