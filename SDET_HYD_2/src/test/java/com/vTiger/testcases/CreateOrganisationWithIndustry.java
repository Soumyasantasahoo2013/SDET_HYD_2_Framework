package com.vTiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.genericutil.BaseClass;
import com.vtiger.genericutil.ExcelUtility;
import com.vtiger.genericutil.JSONFileUtility;
import com.vtiger.genericutil.JavaUtility;
import com.vtiger.genericutil.WebDriverUtility;

public class CreateOrganisationWithIndustry extends BaseClass{

	@Test
	public void createOrganisationWithIndustry() throws Throwable
	{
		ExcelUtility eUtil=new ExcelUtility();
		String orgName = eUtil.excelUtility("Sheet1",1 , 2)+"_"+JavaUtility.generateRandomNumber();
		String indusType = eUtil.excelUtility("Sheet1", 3, 3);
		
		//Create Organisation with Industry
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ind = driver.findElement(By.name("industry"));
		wUtil.selectByVisibleText(ind, indusType);
	}

}
