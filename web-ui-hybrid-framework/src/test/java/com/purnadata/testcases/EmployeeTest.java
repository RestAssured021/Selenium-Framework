package com.purnadata.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.purnadata.libraries.BaseClass;
import com.purnadata.libraries.ExcelUtils;
import com.purnadata.libraries.Utilities;
import com.purnadata.pages.DashboardPage;
import com.purnadata.pages.EmployeeDashboardPage;
import com.purnadata.pages.EmployeePage;
import com.purnadata.pages.LoginPage;

public class EmployeeTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	EmployeeDashboardPage employeeDashboardPage;
	EmployeePage employeePage;
	Utilities util;

	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		employeeDashboardPage = new EmployeeDashboardPage(driver);
		employeePage = new EmployeePage(driver);
		util = new Utilities();

		loginPage.loginToPurna(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getEmployeeData() {
		Object[][] data = ExcelUtils.getTestData("Employee");		
		return data;
	}

	@Test(dataProvider = "getEmployeeData")
	public void addNewEmployeeSuccessTest(String srNo, String name, String dept, String dateOfBirth, String design,
			String empId, String mobileNo, String panCard, String accNo) {

		util.clickElement(driver, dashboardPage.link_main);
		util.clickElement(driver, dashboardPage.link_employee);
		util.clickElement(driver, employeeDashboardPage.btn_addNewEmployee);

		employeePage.txtBox_srNo.clear();
		employeePage.txtBox_srNo.sendKeys(srNo);
		employeePage.txtBox_name.sendKeys(name);
		employeePage.txtBox_dept.sendKeys(dept);
		employeePage.txtBox_dateOfjoining.sendKeys(dateOfBirth);
		employeePage.txtBox_design.sendKeys(design);
		employeePage.txtBox_empId.sendKeys(empId);
		employeePage.txtBox_mobile.sendKeys(mobileNo);
		employeePage.txtBox_pan.sendKeys(panCard);
		employeePage.txtBox_accNo.sendKeys(accNo);

		util.clickElement(driver, employeePage.btn_save);

		util.handleAlert(driver).accept();

		util.clickElement(driver, employeePage.btn_empDashboard);

		Assert.assertEquals(employeeDashboardPage.label_empName.getText(), "Joe Biden");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
