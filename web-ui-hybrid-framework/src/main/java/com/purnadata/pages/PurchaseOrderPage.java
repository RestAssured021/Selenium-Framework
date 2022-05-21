package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "supplier_name")
	public WebElement dropdown_supplierName;

	@FindBy(id = "credit_period")
	public WebElement txt_creditperiod;

	@FindBy(name = "credit_period1")
	public WebElement txt_addNewCRperiod;

	@FindBy(id = "note")
	public WebElement txt_Note;

	@FindBy(name = "terms_and_condition")
	public WebElement txt_termsAndConditiond;
	@FindBy(name = "project")
	public WebElement txt_project;

	@FindBy(id = "myButton")
	public WebElement btn_calculate;

	@FindBy(id = "po_amount")
	public WebElement btn_po_amount;

	@FindBy(id = "btn_save_item")
	public WebElement btn_btn_save_purchase_items;

	@FindBy(id = "total_amount")
	public WebElement txt_total_amount;

	@FindBy(id = "cgst")
	public WebElement txt_cgst;

	@FindBy(id = "sgst")
	public WebElement txt_sgst;

	@FindBy(id = "igst")
	public WebElement txt_igst;

	@FindBy(name = "packing_and_forwarding")
	public WebElement txt_packingAndForwording;

	@FindBy(name = "deliverycharges")
	public WebElement txt_deliveryCharges;

	@FindBy(id = "myButtonlast")
	public WebElement btn_lastCalculate;

	@FindBy(id = "grand_total")
	public WebElement btn_grandtotal;

	@FindBy(name = "submit")
	public WebElement btn_lastSave;

	@FindBy(xpath = "//a[text()='Purchase Invoice Details']")
	public WebElement btn_PurchaseInvoiceDetails;

	@FindBy(name = "submit")
	public WebElement btn_update;

}
