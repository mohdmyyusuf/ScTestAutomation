package com.sct.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sct.qa.base.Base;
import com.sct.qa.pages.HomePage;
import com.sct.qa.pages.UserPage;


public class HomePageTest extends Base{
	
	HomePage homePage;
	UserPage userPage;
	
	HomePageTest(){		
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void validateHomePageTitleTest()
	{
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals("Online Shopping Site India - Shop Online for men, women and kids fashion, home, kitchen, health, sports and more products at ShopClues", title);
		//Assert.assertEquals("Shopclues", title);
	}
	
	@Test(priority = 2)
	public void validateLogoTest() {
		boolean flag = homePage.validateLogo();
		Assert.assertTrue(flag);
		
		//Assert.assertTrue(flag);
		
	}
	
	@Test(priority = 3)
	public void logiTest()
	{
		userPage= homePage.signIn();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
