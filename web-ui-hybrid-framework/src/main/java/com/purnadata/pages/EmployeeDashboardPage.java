package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDashboardPage {


	public EmployeeDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btn_addNewEmployee;
	
	@FindBy(xpath = "//td[text()='Joe Biden']")
	public WebElement label_empName;
}
