package com.sct.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sct.qa.base.Base;
import com.sct.qa.pages.HomePage;
import com.sct.qa.pages.UserPage;
import com.sct.qa.util.LoggerTest;

public class UserPageTest extends Base {
	
	UserPage userPage;
	HomePage homePage;
	UserPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		userPage= homePage.signIn();
	}
	
	@Test
	public void verifyUserPageTitleTest() {
		
		String userPageTitle = userPage.verifyUserPageTitle();
		Assert.assertEquals("Online Shopping Site India - Shop Online for men, women and kids fashion, home, kitchen, health, sports and more products at ShopClues", userPageTitle);
		
	}
	
	@Test
	public void mouseHoverPfName() {
		
		userPage.hoverMouseOnUserName();
	}
	
	@Test
	public void getUserNameTest() {
		
		String currentUser = userPage.getUserName();
		System.out.println("Logged in user is"+currentUser);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
