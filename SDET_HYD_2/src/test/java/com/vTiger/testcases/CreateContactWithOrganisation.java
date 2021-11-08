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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericutils.BaseClass;
import com.vtiger.genericutils.ExcelUtility;
import com.vtiger.genericutils.JavaUtility;
import com.vtiger.genericutils.PropertyFileUtility;
import com.vtiger.genericutils.WebDriverUtility;

public class CreateContactWithOrganisation extends BaseClass{

	
	@Test
	public void createContactWithOrganisation() throws Throwable
	{
		String firstName = eUtil.excelUtility("Sheet1", 5, 2)+"_"+JavaUtility.generateRandomNumber();
		String lastName = eUtil.excelUtility("Sheet1", 5, 3)+"_"+JavaUtility.generateRandomNumber();
		String searchType = eUtil.excelUtility("Sheet1", 5, 4);
		
		//Create Contact with Organisation
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement fn = driver.findElement(By.name("salutationtype"));
		wUtil.selectByVisibleText(fn, "Mr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		//Switch to child window
		String partialWinTitle="Accounts";
		wUtil.switchToWindow(driver, partialWinTitle);
		driver.findElement(By.id("search_txt")).sendKeys(searchType);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='Session8']")).click();
		
		//Switch to Parent window
		String partialWinTitle1="Contacts";
		wUtil.switchToWindow(driver, partialWinTitle1);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
