package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.MyUtilities;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MyUtilities util;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		util = new MyUtilities();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	 
	@Test (enabled = false)
	public void homePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","  Home Page title mismatch");
	}
	
	@Test
	public void usernameTest() {
		util.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName(),"Correct User Name not displayed");
	}
	
	@Test
	public void verifyContactsLinkTest() {
		util.switchToFrame();
		 contactsPage = homePage.clickContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
 