package com.vTiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.genericutil.JSONFileUtility;
import com.vtiger.genericutil.JavaUtility;
import com.vtiger.genericutil.WebDriverUtility;

public class CreateOrganisationWithIndustry {

	@Test
	public void createOrganisationWithIndustry() throws Throwable
	{
		JSONFileUtility jUtil=new JSONFileUtility();
		String URL = jUtil.jsonFileUtility("url");
		String UN = jUtil.jsonFileUtility("username");
		String pwd = jUtil.jsonFileUtility("password");
		
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//Open the Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Login into the application
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		//Create Organisation with Industry
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Session"+"_"+JavaUtility.generateRandomNumber());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ind = driver.findElement(By.name("industry"));
		wUtil.selectByVisibleText(ind, "Banking");

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
