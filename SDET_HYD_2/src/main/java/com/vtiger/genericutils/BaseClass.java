package com.vtiger.genericutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.Login;

public class BaseClass {

	public WebDriver driver;
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public static WebDriver sdriver;
	public HomePage hp;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void connectDatabase()
	{
		System.out.println("Connect to Database");
	}

	//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void launchBrowser() throws Throwable
	{
		//Open the Browser
		String BROWSER = pUtil.propertyFileUtility("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		sdriver=driver;
		wUtil.waitForPageLoad(driver);
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void login() throws Throwable
	{
		//Login into the application
		driver.get(pUtil.propertyFileUtility("url"));
		Login lp=new Login(driver);
		lp.loginIntoVtiger(pUtil.propertyFileUtility("username"), pUtil.propertyFileUtility("password"));
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void logout() throws Throwable
	{
		//Logout from the application
		Thread.sleep(4000);
		hp=new HomePage(driver);
		hp.signOutFromVtiger();
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void closeBrowser() throws Throwable
	{
		//Close the connection
		Thread.sleep(4000);
		driver.close();  
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void disconnectDatabase()
	{
		System.out.println("close connection from Database");
	}


}
