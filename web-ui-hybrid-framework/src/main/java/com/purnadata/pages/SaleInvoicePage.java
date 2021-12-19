package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaleInvoicePage {
	
	public SaleInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="invoice_no")
	public
	WebElement textBox_invoiceNumber;
	
	@FindBy(id="powo")
	public
	WebElement textBox_poWo;
	
	@FindBy(id="bill_to")
	public
	WebElement dropDown_billTo;
	
	@FindBy(id="sr_no")
	public
	WebElement textBox_srNo;
	
	@FindBy(id="btn_save_item")
	public
	WebElement btn_saveItem;
	
}
