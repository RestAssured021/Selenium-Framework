package com.purnadata.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.libraries.Utilities;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.LoginPage;
import com.purnadata.pages.PurchaseInvoicePage;
import com.purnadata.pages.ViewSupplierBalPage;

public class PaymentSummaryTest extends BaseClass{
		
	LoginPage loginPage;
	DashboardPage salesDashboardPage;
	ViewSupplierBalPage viewSupplierBalPage; 
	PurchaseInvoicePage purchaseInvoicePage;
	Utilities utils;
	
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage(driver);
		salesDashboardPage = new DashboardPage(driver);
		viewSupplierBalPage = new ViewSupplierBalPage(driver);
		purchaseInvoicePage = new PurchaseInvoicePage(driver);
		utils = new Utilities();
		loginPage.loginToPurna(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyPurchaseInvoiceExportTest() {
		utils.clickElement(driver, salesDashboardPage.link_purchase);	
		utils.clickElement(driver, salesDashboardPage.link_paymentSummary);
		utils.clickElement(driver, viewSupplierBalPage.radioBtn_all);
		utils.clickElement(driver, viewSupplierBalPage.btn_exportToExcel);
		
		Assert.assertEquals(purchaseInvoicePage.label_successMsg.getText(), "Downloading is successfull");
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
