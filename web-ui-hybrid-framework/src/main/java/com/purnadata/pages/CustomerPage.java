package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	
	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='sr_no']")  
	public WebElement textBox_srNo;
	
	@FindBy(id="customer_name")  
	public WebElement textBox_custName;
	
	@FindBy(id="contact_no")  
	public WebElement textBox_contactNo;
	
	@FindBy(id="billing_address")  
	public WebElement textBox_billingAddress;
	
	@FindBy(id="contact_person")  
	public WebElement textBox_contPerson;
	
	@FindBy(id="gst_no")  
	public WebElement textBox_gstNo;
	
	@FindBy(id="btn")  
	public WebElement btn_save;
	
	@FindBy(xpath="//a[text()='Customer Details']")  
	public WebElement btn_custDetails;
	
	
	
	
	

}
