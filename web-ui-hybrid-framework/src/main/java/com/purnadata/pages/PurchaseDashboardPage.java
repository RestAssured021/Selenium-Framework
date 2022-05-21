package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseDashboardPage {
	
	public PurchaseDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),' Purchase ')]")
	public WebElement link_purchase;
	
	@FindBy(xpath="//a[@href='purchase_dashboard.php']")
	public WebElement link_purchaseOrder;


}
