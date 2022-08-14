package com.purnadata.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.libraries.Utilities;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.DebitNoteDashPage;
import com.purnadata.pages.LoginPage;
import com.purnadata.pages.ViewDebitNotePage;

public class DebitNoteTest extends BaseClass{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	DebitNoteDashPage debitNoteDashPage;
	ViewDebitNotePage viewDebitNotePage;
	Utilities utils;
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		debitNoteDashPage = new DebitNoteDashPage(driver);
		viewDebitNotePage = new ViewDebitNotePage(driver);
		utils = new Utilities();
		loginPage.loginToPurna(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void viewDebitNoteTest() {
		utils.clickElement(driver, dashboardPage.link_purchase);	
		utils.clickElement(driver, dashboardPage.link_debitNote);
		utils.clickElement(driver, debitNoteDashPage.link_view);
		
		utils.syncElement(driver, viewDebitNotePage.label_updateDebiteNote, "ToVisible");
		Assert.assertEquals(viewDebitNotePage.label_updateDebiteNote.getText(), "UPDATE DEBIT NOTE");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
