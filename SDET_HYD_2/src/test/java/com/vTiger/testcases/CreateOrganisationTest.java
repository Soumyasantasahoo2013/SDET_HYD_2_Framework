package com.vTiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericutil.BaseClass;
import com.vtiger.genericutil.ExcelUtility;
import com.vtiger.genericutil.JavaUtility;
import com.vtiger.genericutil.PropertyFileUtility;
import com.vtiger.genericutil.WebDriverUtility;

public class CreateOrganisationTest extends BaseClass{

	@Test(invocationCount = 3)
	public void createOrganisationTest() throws Throwable
	{
		ExcelUtility eUtil=new ExcelUtility();
		String orgName = eUtil.excelUtility("Sheet1",1 , 2)+"_"+JavaUtility.generateRandomNumber();

		//Create Organisation
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Organisation Created");

		WebElement orgInfo = driver.findElement(By.className("dvHeaderText"));
		String organisationInfo = orgInfo.getText();
		System.out.println(organisationInfo);
		Assert.assertTrue(organisationInfo.contains(orgName));
		Reporter.log("Verification Passed", true);

		//	    SoftAssert sa=new SoftAssert();
		//	    sa.assertEquals(true, false);		
		//	    System.out.println("Verfication is done");
	}

}
