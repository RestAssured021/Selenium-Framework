package com.purnadata.testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.libraries.ExcelUtils;
import com.purnadata.libraries.Utilities;
import com.purnadata.pages.CustDashboardPage;
import com.purnadata.pages.CustomerPage;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.LoginPage;

public class CustomerTest extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CustDashboardPage custDashboardPage;
	CustomerPage customerPage;
	Utilities utils;

	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		custDashboardPage = new CustDashboardPage(driver);
		customerPage = new CustomerPage(driver);
		utils = new Utilities();
		loginPage.loginToPurna(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getCustomerData() {
		Object[][] data = ExcelUtils.getTestData("Customer");
		return data;
	}

	@Test(dataProvider = "getCustomerData")
	public void verifyCreateCustomerSuccessTest(String srNo, String custName, String contNumber, String address,
			String contPerson, String gstNo) {
		utils.clickElement(driver, dashboardPage.link_mainMenu);
		utils.clickElement(driver, dashboardPage.link_customer);
		utils.clickElement(driver, custDashboardPage.btn_newCustomer);

		utils.syncElement(driver, customerPage.textBox_srNo, "ToVisible");
		customerPage.textBox_srNo.clear();
		customerPage.textBox_srNo.sendKeys(srNo);
		customerPage.textBox_custName.sendKeys(custName);
		customerPage.textBox_contactNo.sendKeys(contNumber);
		customerPage.textBox_billingAddress.sendKeys(address);
		customerPage.textBox_contPerson.sendKeys(contPerson);
		customerPage.textBox_gstNo.sendKeys(gstNo);

		utils.clickElement(driver, customerPage.btn_save);

		utils.acceptAlert(driver);

		utils.clickElement(driver, customerPage.btn_custDetails);

		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+custName+"']")).getText(), custName);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
