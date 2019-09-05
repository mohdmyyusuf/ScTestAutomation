package com.sct.qa.testcases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sct.qa.base.Base;
import com.sct.qa.pages.HomePage;
import com.sct.qa.pages.UserPage;
import com.sct.qa.util.LoggerTest;


@Listeners(com.sct.qa.util.ListenerTest.class)
public class HomePageTest extends Base{
	static Logger log = Logger.getLogger(HomePageTest.class.getName());
	HomePage homePage;
	UserPage userPage;
	
	HomePageTest(){		
		super();
	}
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException
	{
		initialization();
		homePage = new HomePage();
		LoggerTest.logSetup();
		log.info("Initialization has been started");
	}
	
	@Test(priority = 1)
	public void validateHomePageTitleTest()
	{
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals("Online Shopping Site India - Shop Online for men, women and kids fashion, home, kitchen, health, sports and more products at ShopClues", title);
		//Assert.assertEquals("Shopclues", title);
		log.info("Validating home page name");
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
