package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseInvoicePage {
	
	public PurchaseInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@id='main-message']//following::span")
	public WebElement label_successMsg;

}
