package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class Log4jTest extends TestBase{
	
	public LoginPage loginPage;
	public HomePage homePage;
	Logger log = Logger.getLogger(Log4jTest.class);
	
	public Log4jTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		log.info("StUp method");
	}
	
	@Test
	public void loginPageTiltleTest() {
		log.info("loginPageTiltleTest method");
		log.info("Info");
		log.debug("debug");
		log.warn("warn");
		log.error("error");
		String title = loginPage.validateLoginPage();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service", "Login Page Title Mismatch");
	}
	
	@Test
	public void crmLogoTest() {
		Boolean crmLogoIsDisplayed = loginPage.validateCRMLogo();
		Assert.assertTrue(crmLogoIsDisplayed,"Logo Not Displayed");
	}
	
	
	
}
