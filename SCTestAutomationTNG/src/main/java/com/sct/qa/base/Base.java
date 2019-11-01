package com.sct.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sct.qa.util.TestUtil;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public Base()
	{		
		prop = new Properties();
		try 
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\myusuf\\git\\MYGitRepo\\SCTestAutomationTNG\\src\\main\\java\\com\\sct\\qa\\config\\config.properties");
			prop.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void initialization() 
	{
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\myusuf\\git\\MYGitRepo\\SCTestAutomationTNG\\Drivers\\chromedriver_win32\\chromedriver.exe");
			
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-notifications");
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);			
		}
		else if(browserName.equals("ff")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\myusuf\\git\\MYGitRepo\\SCTestAutomationTNG\\Drivers\\geckodriver.exe");
			DesiredCapabilities capab = new DesiredCapabilities().firefox();
			capab.setCapability("marionette", true);
			driver = new FirefoxDriver(capab);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
