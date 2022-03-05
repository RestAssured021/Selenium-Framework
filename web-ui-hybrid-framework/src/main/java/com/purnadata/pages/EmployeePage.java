package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {

	public EmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "sr_no")
	public WebElement txtBox_srNo;
	
	@FindBy(name = "name")
	public WebElement txtBox_name;
	
	@FindBy(id = "date_of_joining")
	public WebElement txtBox_dateOfjoining;
	
	@FindBy(id = "department")
	public WebElement txtBox_dept;
	
	@FindBy(id = "designation")
	public WebElement txtBox_design;
	
	@FindBy(id = "mobile")
	public WebElement txtBox_mobile;
	
	@FindBy(id = "pan_no")
	public WebElement txtBox_pan;
	
	@FindBy(id = "birthdate")
	WebElement txtBox_birthDate;
	
	@FindBy(id = "emp_id")
	public WebElement txtBox_empId;
	
	@FindBy(id = "acc_no")
	public WebElement txtBox_accNo;
	
	@FindBy(id = "btn")
	public WebElement btn_save;
	
	@FindBy(xpath="//a[text()='Employee Dashboard']")
	public WebElement btn_empDashboard;
}
