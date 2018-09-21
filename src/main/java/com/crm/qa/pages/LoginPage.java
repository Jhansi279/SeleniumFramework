package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory or Object Repository
	@FindBy(name = "username")
	WebElement unameField;
	
	@FindBy(name = "password")
	WebElement pwdField;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[@alt = 'free crm logo']")
	WebElement crmLogo;
	
	@FindBy(id ="preloader")
	WebElement preloader;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods / Actions on the page
	public String validateLoginPage() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

	
			
	//id preloader
	public HomePage login(String un, String pwd) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		
		unameField.clear();
		unameField.sendKeys(un);
		pwdField.clear();
		pwdField.sendKeys(pwd);
		loginBtn.click();
		return new HomePage(); //since landing page of login is HomePage
	}

	
	
	
	
	
	
	
	
	
}
