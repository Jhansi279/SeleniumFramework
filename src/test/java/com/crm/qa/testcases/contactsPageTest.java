package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.MyUtilities;

public class contactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	MyUtilities util;
	ContactsPage contactsPage;
	
	public contactsPageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		util = new MyUtilities();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		util.switchToFrame();
		contactsPage = homePage.clickContactsLink();
	}
	
	@Test(enabled = false)
	public void verifyContactsPageTest() {
		Assert.assertTrue(contactsPage.verifyContactsText(),"Contacts Page Not Displayed");
	}
	
	@Test
	public void selectUserTest() {
		contactsPage.selectUser(prop.getProperty("user1"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
