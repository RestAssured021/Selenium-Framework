package com.purnadata.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	private static Logger logger = LoggerFactory.getLogger(LoginTest.class);

	@BeforeMethod
	public void init(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " started");
		initialization();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	
	@Test (priority=0)
	public void loginSuccessTest() {
		
		loginPage.loginToPurna(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(dashboardPage.text_salesInvoiceDetails.getText(), "Sale Invoice Details");

	}

	@Test (priority=1)
	public void loginFailureTest() {
		loginPage.loginToPurna(prop.getProperty("username"), prop.getProperty("password2"));
		Assert.assertEquals(dashboardPage.text_salesInvoiceDetails.getText(), "Sale Invoice Details");
	}

	@AfterMethod
	public void close() {
		driver.close();
		logger.info("Browser closed");
	}
}
