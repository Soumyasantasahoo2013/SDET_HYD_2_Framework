package com.vtiger.genericutil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public WebDriver driver;
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void connectDatabase()
	{
		System.out.println("Connect to Database");
	}

	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void launchBrowser() throws Throwable
	{
		//Open the Browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void login() throws Throwable
	{
		//Login into the application
		driver.get(pUtil.propertyFileUtility("url"));
		driver.findElement(By.name("user_name")).sendKeys(pUtil.propertyFileUtility("username"));
		driver.findElement(By.name("user_password")).sendKeys(pUtil.propertyFileUtility("password"));
		driver.findElement(By.id("submitButton")).click();
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void logout() throws Throwable
	{
		//Logout from the application
		Thread.sleep(4000);
		WebElement admImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOver(driver, admImg);
		driver.findElement(By.linkText("Sign Out")).click();
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
