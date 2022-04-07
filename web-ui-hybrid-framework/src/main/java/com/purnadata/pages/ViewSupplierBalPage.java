package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSupplierBalPage {
	
	public ViewSupplierBalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//span[@class='menu-text'])[4]")
	public WebElement link_purchase;
	
	@FindBy(xpath="//a[@href='view_supplier_balance.php']")
	public WebElement link_paymentSummary;
	
	@FindBy(xpath="//input[@id='rupees']")
	public WebElement radioBtn_all;
	
	@FindBy(id="excel")
	public WebElement btn_exportToExcel;
	
}
