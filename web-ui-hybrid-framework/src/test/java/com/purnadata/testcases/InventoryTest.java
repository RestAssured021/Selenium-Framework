package com.purnadata.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.libraries.Utilities;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.LoginPage;
import com.purnadata.pages.PurchaseItemDashboardPage;
import com.purnadata.pages.PurchaseItemPage;

public class InventoryTest extends BaseClass{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	PurchaseItemDashboardPage purchaseItemDashPage;
	PurchaseItemPage purchaseItemPage;
	Utilities utils;

	@BeforeMethod
	public void inti() {
		initialization();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		purchaseItemDashPage = new PurchaseItemDashboardPage(driver);
		purchaseItemPage = new PurchaseItemPage(driver);
		utils = new Utilities();
		loginPage.logintToPurna("admin", "admin");
	}

	@Test
	public void addInventorySuccessTest() {
		dashboardPage.link_mainMenu.click();
		dashboardPage.link_inventory.click();
		
		purchaseItemDashPage.btn_addNewItem.click();
		
		purchaseItemPage.txtBox_srNo.clear();
		purchaseItemPage.txtBox_srNo.sendKeys("203");
		purchaseItemPage.txtBox_itemcode.sendKeys("3210");
		purchaseItemPage.txtBox_itemname.sendKeys("Groceries");
			
		utils.doDropDownSelectByVisibleText(purchaseItemPage.dropdown_units, "KG");
		
		purchaseItemPage.txtBox_rate.sendKeys("1000");
		purchaseItemPage.txtBox_quantity.sendKeys("10");
		purchaseItemPage.txtBox_amount.sendKeys("5000");
		purchaseItemPage.btn_addItem.click();
		purchaseItemPage.btn_itemDetails.click();
			
	}

	@AfterMethod
	public void browserclose() {
		driver.close();
	}

}
