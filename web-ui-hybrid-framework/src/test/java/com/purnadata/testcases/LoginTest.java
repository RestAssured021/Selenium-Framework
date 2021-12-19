package com.purnadata.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	@Test (priority=0)
	public void loginSuccessTest() {
		loginPage.logintToPurna(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(dashboardPage.text_salesInvoiceDetails.getText(), "Sale Invoice Details");

	}

	@Test (priority=1)
	public void loginFailureTest() {
		loginPage.logintToPurna(prop.getProperty("username"), prop.getProperty("password2"));
		Assert.assertEquals(dashboardPage.text_salesInvoiceDetails.getText(), "Sale Invoice Details");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
