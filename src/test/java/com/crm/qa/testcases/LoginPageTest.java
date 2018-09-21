package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	public LoginPage loginPage;
	public HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTiltleTest() {
		String title = loginPage.validateLoginPage();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service", "Login Page Title Mismatch");
	}
	
	@Test
	public void crmLogoTest() {
		Boolean crmLogoIsDisplayed = loginPage.validateCRMLogo();
		Assert.assertTrue(crmLogoIsDisplayed,"Logo Not Displayed");
	}
	
	@Test
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		//Assert that user is logged in
		//Look for logout button or username of logged in person 
		//xpath for logout button   - //a[@href = 'https://www.freecrm.com/index.cfm?logout=1']
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
