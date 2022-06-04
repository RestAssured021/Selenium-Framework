package com.purnadata.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.libraries.ExcelUtils;
import com.purnadata.libraries.Utilities;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.EditSalesInvoicePage;
import com.purnadata.pages.LoginPage;
import com.purnadata.pages.SaleInvoicePage;

public class SalesInvoiceTest extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SaleInvoicePage saleInvoicePage;
	Utilities utils;
	EditSalesInvoicePage editSalesInvoicePage;
	
	@BeforeMethod
	public void init() {
		initialization();	
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		saleInvoicePage = new SaleInvoicePage(driver);
		editSalesInvoicePage = new EditSalesInvoicePage(driver);
		utils = new Utilities();
		loginPage.loginToPurna(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getSalesInvoicedata() {
		Object[][] data = ExcelUtils.getTestData("SalesInvoice");
		return data;
	}

	@Test(enabled=false, dataProvider = "getSalesInvoicedata")
	public void addNewSaleInvoiceTest(String powo, String date, String customer, String amount, String transCharge,
			String packChanrges) {
		utils.clickElement(driver, dashboardPage.btn_newSaleInvoice);
		utils.syncElement(driver, saleInvoicePage.txtBox_poWo, "ToVisible");
		saleInvoicePage.txtBox_poWo.sendKeys(powo);
		saleInvoicePage.txtBox_date.sendKeys(date);
		utils.selectDropDownByVisibleText(saleInvoicePage.dropdown_billTo, customer);
		saleInvoicePage.txtBox_termsAndConditions.sendKeys("This is sample Terms & Conditions For Creat");
		saleInvoicePage.txtBox_totalAmount.sendKeys(amount);
		utils.selectDropDownByVisibleText(saleInvoicePage.txtBox_cGst, "6");
		utils.selectDropDownByVisibleText(saleInvoicePage.txtBox_sGst, "9");
		utils.selectDropDownByVisibleText(saleInvoicePage.txtBox_iGst, "14");
		saleInvoicePage.txtBox_transportation.sendKeys(transCharge);
		saleInvoicePage.txtBox_packingAndForwording.sendKeys(packChanrges);
		utils.clickElement(driver, saleInvoicePage.btn_calculate);
		utils.clickElement(driver, saleInvoicePage.btn_save);
		utils.acceptAlert(driver);
		utils.clickElement(driver, saleInvoicePage.link_saleinvoiceDetails);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+customer+"']")).getText(), customer);
	}
	
	@DataProvider
	public Object[][] getEditSalesInvoicedata() {
		Object[][] data = ExcelUtils.getTestData("EditSaleInvoice");
		return data;
	}
	
	@Test(dataProvider = "getEditSalesInvoicedata")
	public void editSalesInvoiceTest(String billAddress, String contPerson) {
		utils.clickElement(driver, dashboardPage.link_sales);
		utils.clickElement(driver, dashboardPage.link_salesInvoice);
		utils.clickElement(driver, dashboardPage.link_edit);
		utils.syncElement(driver, editSalesInvoicePage.txtBox_billAddress, "To_Visible");
		editSalesInvoicePage.txtBox_billAddress.clear();
		editSalesInvoicePage.txtBox_billAddress.sendKeys(billAddress);
		editSalesInvoicePage.txtBox_contPerson.clear();
		editSalesInvoicePage.txtBox_contPerson.sendKeys(contPerson);	
		utils.clickElement(driver, editSalesInvoicePage.btn_update);
	
	    utils.acceptAlert(driver);
	    
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Rajesh']")).getText(), "Rajesh");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
