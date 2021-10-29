package com.vTiger.testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.genericutil.JavaUtility;
import com.vtiger.genericutil.PropertyFileUtility;
import com.vtiger.genericutil.WebDriverUtility;

public class CreateContactWithOrganisation {

	
	@Test
	public void createContactWithOrganisation() throws Throwable
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.propertyFileUtility("url");
		String UN = pUtil.propertyFileUtility("username");
		String pwd = pUtil.propertyFileUtility("password");
		
		//Open the Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Login into the application
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		//Create Contact with Organisation
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement fn = driver.findElement(By.name("salutationtype"));
		wUtil.selectByVisibleText(fn, "Mr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Soumya"+"_"+JavaUtility.generateRandomNumber());
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sahoo"+"_"+JavaUtility.generateRandomNumber());
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		//Switch to child window
		String partialWinTitle="Accounts";
		wUtil.switchToWindow(driver, partialWinTitle);
		driver.findElement(By.id("search_txt")).sendKeys("Session8");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='Session8']")).click();
		
		//Switch to Parent window
		String partialWinTitle1="Contacts";
		wUtil.switchToWindow(driver, partialWinTitle1);
		Thread.sleep(4000);
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
