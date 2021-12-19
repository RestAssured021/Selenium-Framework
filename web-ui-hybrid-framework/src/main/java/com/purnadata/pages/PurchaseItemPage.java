package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseItemPage {
	
	public PurchaseItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sr_no")
	public 
	WebElement txtBox_srNo;
	
	@FindBy(id="itemcode")
	public WebElement txtBox_itemcode;
	
	@FindBy(id="itemname")
	public WebElement txtBox_itemname;
	
	@FindBy(name="units")
	public WebElement dropdown_units;
	
	@FindBy(id="txt_rate")
	public WebElement txtBox_rate;
	
	@FindBy(id="txt_qty")
	public WebElement txtBox_quantity;
	
	@FindBy(id="txt_amount")
	public WebElement txtBox_amount;
	
	@FindBy(name="submit")
	public WebElement btn_addItem;
	
	@FindBy(xpath="//a[text()='Item Details']")
	public WebElement btn_itemDetails;
}
