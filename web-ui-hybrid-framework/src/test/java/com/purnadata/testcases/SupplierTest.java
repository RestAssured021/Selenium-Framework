package com.purnadata.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.libraries.Utilities;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.LoginPage;
import com.purnadata.pages.SupplierDashboardPage;
import com.purnadata.pages.SupplierPage;

public class SupplierTest extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SupplierDashboardPage suppDashboardPage;
	SupplierPage supplierPage;
	Utilities utils;

	@BeforeMethod
	public void init() {
		initialization();

		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		suppDashboardPage = new SupplierDashboardPage(driver);
		supplierPage = new SupplierPage(driver);
		utils = new Utilities();

		loginPage.logintToPurna(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void createNewSupplierSuccessTest() {
		dashboardPage.link_main.click();
		dashboardPage.link_supplier.click();
		
		utils.syncElement(driver, suppDashboardPage.btn_newSupplier, "ToClickable");

		supplierPage.txtBox_srNo.clear();
		supplierPage.txtBox_srNo.sendKeys("200103");
		supplierPage.txtBox_supplierName.sendKeys("TestSupplier3");
		supplierPage.txtBox_contactNoSupplier.sendKeys("TestSupplier");
		supplierPage.txtBox_address.sendKeys("Pune");
		supplierPage.txtBox_emailId.sendKeys("a@abc.com");
		supplierPage.txtBox_contactNoContPers.sendKeys("1234567");
		supplierPage.txtBox_contactPerson.sendKeys("TestPerson3");
		supplierPage.txtBox_gstNo.sendKeys("123abc");
		supplierPage.txtBox_panNo.sendKeys("ABCDEF0123G");
		supplierPage.btn_save.click();

		utils.syncElement(driver, null, "alertPresent");
		driver.switchTo().alert().accept();

		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='200103']")), "200103");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
