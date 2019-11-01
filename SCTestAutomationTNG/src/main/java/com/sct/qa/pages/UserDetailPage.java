package com.sct.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sct.qa.base.Base;

public class UserDetailPage extends Base{
	
	
	@FindBy(xpath = "//li[@id='sc_uname']/div/ul/li[4]/a")
	WebElement profileLink;

	@FindBy(xpath = "//li[@id='sc_uname']/a")
	WebElement myProfileLink;
	
	@FindBy(xpath = "//div[@id='content']/div/div[5]/div/div/div[2]/div/div/div/div[2]/div/div/p")
	WebElement userName;
	
	@FindBy(xpath = "//a[@onclick=\"return tracker('addressBook');\"]")
	WebElement myAddressLink;
	
	
	UserDetailPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
