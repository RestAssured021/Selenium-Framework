package com.purnadata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")   
	WebElement textBox_username;
	
	@FindBy(name="password")
	WebElement textBox_password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_login;
	
	@FindBy(xpath="//h3[text()='Admin login']")
	public WebElement label_logoDesc;
	
	
	public void loginToPurna(String username, String password) {
		textBox_username.sendKeys(username);
		textBox_password.sendKeys(password);
		btn_login.click();
	}	
}
