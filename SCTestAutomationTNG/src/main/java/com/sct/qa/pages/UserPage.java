package com.sct.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.util.concurrent.Uninterruptibles;
import com.sct.qa.base.Base;

public class UserPage extends Base{
	


	Actions action = new Actions(driver);
	
	
	@FindBy(xpath = "//*[@id=\"sc_uname\"]/a")
	WebElement profileLink;
	@FindBy(xpath = "//p[@class =\"name\"]")
	WebDriver nameLabel;
	@FindBy(xpath = "(//a[@href=\"javascript:void(0);\"])[2]")
	WebElement userDrop;
	@FindBy(xpath = "//*[@id=\"sc_uname\"]/div/div/div/a")
	WebElement userNameMenu;
	public UserPage()
	{	
		PageFactory.initElements(driver, this);
		//super();
	}
	
	public String verifyUserPageTitle() {
		
		String titleUserPage = driver.getTitle();
		return titleUserPage;
		
		
	}
	public void hoverMouseOnUserName() {
		try {
		Point point = profileLink.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		action.moveToElement(profileLink, xcord, ycord).perform();
		Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			// TODO: handle exception
		}
		
	}
	
	
	public String getUserName() {
		
		String userName = profileLink.getText();
		return userName;
		
	}
	
	public UserDetailPage userDetailPageLink() {
		
		userNameMenu.click();
		return new UserDetailPage();
	}
	

}
