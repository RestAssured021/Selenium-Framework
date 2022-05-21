package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderDashboardPage {
	
	public PurchaseOrderDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="btn_new_party")
	public WebElement link_newPurchaseInvoice;
	
	@FindBy(xpath="//a[@href='edit_purchase_invoice.php?pono=2']")
	public WebElement btn_editPurchaseInvoice;
	
	@FindBy(xpath="//a[@href='view_purchase_invoice.php?pono=2']")
	public WebElement btn_viewPurchaseInvoice;
	
	@FindBy(xpath="//a[@href='delete_purchase.php?pono=2']")
	public WebElement btn_deletePurchaseInvoice;
	
	@FindBy(xpath="//a[@href='globaltech_purchase_print.php?pono=1']")
	public WebElement btn_printPurchaseInvoice;
	


}
