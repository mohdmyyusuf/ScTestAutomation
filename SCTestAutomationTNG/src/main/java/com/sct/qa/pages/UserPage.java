package com.sct.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sct.qa.base.Base;

public class UserPage extends Base{
	
	UserPage()
	{		
		super();
	}
	
	@FindBy(xpath = "(//a[text()='My Profile'][@href ='https://myaccount.shopclues.com/index.php?dispatch=profiles.update'][@rel='nofollow'])[2]")
	WebDriver profileLink;
	@FindBy(xpath = "//p[@class =\"name\"]")
	WebDriver nameLabel;
	@FindBy(xpath = "(//a[@href=\"javascript:void(0);\"])[2]")
	WebElement userDrop;
	@FindBy(xpath = "(//a[@href=\"javascript:void(0);\"])[2]")
	WebElement userNameMenu;
	
	

}
