package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDebitNotePage {
	
	public ViewDebitNotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[text()='UPDATE DEBIT NOTE']")
	public WebElement label_updateDebiteNote;

}
