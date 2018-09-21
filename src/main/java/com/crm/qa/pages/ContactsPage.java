package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsText;
	
	@FindBy(xpath = "//a[contains(text(),'Agnimitra Paul')]//parent::td//preceding-sibling::td")
	WebElement user1;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsText() {
		return contactsText.isDisplayed();
	}
	
	public void selectUser(String name) {
		driver.findElement(By.xpath(
				"//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td")).click();
	}
}
