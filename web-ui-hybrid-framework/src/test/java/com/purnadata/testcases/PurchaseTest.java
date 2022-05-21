package com.purnadata.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.pages.LoginPage;
import com.purnadata.pages.PurchaseDashboardPage;
import com.purnadata.pages.PurchaseOrderDashboardPage;
import com.purnadata.pages.PurchaseOrderPage;

public class PurchaseTest extends BaseClass{
		LoginPage loginPage;
		PurchaseDashboardPage purchaseDashboardPage;
		PurchaseOrderDashboardPage purchaseOrderDashboardPage;
		PurchaseOrderPage purchaseOrderPage;

		@BeforeMethod
		public void init() {
			initialization();
			loginPage = new LoginPage(driver);
			purchaseDashboardPage = new PurchaseDashboardPage(driver);
			purchaseOrderDashboardPage = new PurchaseOrderDashboardPage(driver);
			purchaseOrderPage = new PurchaseOrderPage(driver);

			loginPage.loginToPurna("admin", "admin");
		}

		@Test
		public void editPurchaseOrder() {
			purchaseDashboardPage.link_purchase.click();
			purchaseDashboardPage.link_purchaseOrder.click();
			purchaseOrderDashboardPage.btn_editPurchaseInvoice.click();
			purchaseOrderPage.txt_addNewCRperiod.clear();
			purchaseOrderPage.txt_addNewCRperiod.sendKeys("15");
			purchaseOrderPage.txt_packingAndForwording.clear();
			purchaseOrderPage.txt_packingAndForwording.sendKeys("200");
			purchaseOrderPage.txt_deliveryCharges.clear();
			purchaseOrderPage.txt_deliveryCharges.sendKeys("150");
			purchaseOrderPage.btn_lastCalculate.click();
			purchaseOrderPage.btn_update.click();
			driver.switchTo().alert().accept();

		}

		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}

}
