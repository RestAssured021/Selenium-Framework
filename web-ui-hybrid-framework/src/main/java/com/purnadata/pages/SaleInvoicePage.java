package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaleInvoicePage {
	
	public SaleInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="powo")
	public WebElement txtBox_poWo;
	
	@FindBy(name="powo_date")
	public WebElement txtBox_date;
	
	@FindBy(id="bill_to")
	public WebElement dropdown_billTo;
	
	@FindBy(id="terms_cond")
	public WebElement txtBox_termsAndConditions;
	
	@FindBy(id="total_amount")
	public WebElement txtBox_totalAmount;
	
	@FindBy(id="cgst")
	public WebElement txtBox_cGst;
	
	@FindBy(id="sgst")
	public WebElement txtBox_sGst;
	
	@FindBy(id="igst")
	public WebElement txtBox_iGst;

	@FindBy(id="transportation")
	public WebElement txtBox_transportation;
	
	@FindBy(id="packing_and_forwording")
	public WebElement txtBox_packingAndForwording;
	
	@FindBy(id="myButtonlast")
	public WebElement btn_calculate;
	
	@FindBy(id="btn")
	public WebElement btn_save;
	
	@FindBy(xpath="//a[text()='Sale Invoice Details']")
	public WebElement link_saleinvoiceDetails;
	
}
