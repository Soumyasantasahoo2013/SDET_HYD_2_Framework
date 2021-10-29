package com.vTiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtiger.genericutil.JavaUtility;
import com.vtiger.genericutil.PropertyFileUtility;
import com.vtiger.genericutil.WebDriverUtility;

public class CreateOrganisationTest {
	
	@Test
	public void createOrganisationTest() throws Throwable
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.propertyFileUtility("url");
		String UN = pUtil.propertyFileUtility("username");
		String pwd = pUtil.propertyFileUtility("password");
		
		//Open the Browser
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    wUtil.waitForPageLoad(driver);
	    
	    //Login into the application
	    driver.get(URL);
	    driver.findElement(By.name("user_name")).sendKeys(UN);
	    driver.findElement(By.name("user_password")).sendKeys(pwd);
	    driver.findElement(By.id("submitButton")).click();
	    
	    //Create Organisation
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys("Session"+"_"+JavaUtility.generateRandomNumber());
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //Logout from the application
	    Thread.sleep(4000);
	    WebElement admImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));	    
	    wUtil.mouseOver(driver, admImg);
	    driver.findElement(By.linkText("Sign Out")).click();
	    
	    //Close the connection
	    Thread.sleep(4000);
	    driver.close();  
	}

}
