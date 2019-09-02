package com.sct.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sct.qa.base.Base;

public class HomePage extends Base{
	
	// PageElements of home page
	@FindBy(xpath = "//img[@src =\"//images.shopclues.com/images/ui/shopclues_logo@2x.png\" and @itemprop=\"logo\"]")
	WebElement logoImage;
	@FindBy(xpath = "//input[@id =\"autocomplete\"]")
	WebElement searchBar;
	@FindBy(xpath = "//a[@class=\"srch_action btn orange\"]")
	WebElement searchBtn;
	@FindBy(xpath = "//a[@class=\"notify_ic\"]")
	WebElement locatioIcon;
	@FindBy(xpath = "//a[text()=\"Fashion\"]")
	WebElement linkFashion;
	@FindBy(xpath = "//a[text()=\"Sign In\"]")
	WebElement signInLink;
	@FindBy(xpath = "//input[@id=\"main_user_login\"]")
	WebElement userName;
	@FindBy(xpath = "//input[@class=\"label_jump password_txt\"]")
	WebElement password;
	@FindBy(xpath = "//a[@id=\"login_button\"]")
	WebElement signInBtn;
		
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
		
	}
	
	public boolean validateLogo() {
		boolean tf = logoImage.isDisplayed();
		
		return tf;
	}
	
	public UserPage signIn() {
		signInLink.click();
		userName.sendKeys(prop.getProperty("username"));
		password.sendKeys("password");
		signInBtn.click();
		
		return new UserPage();
	}
	
	
}
