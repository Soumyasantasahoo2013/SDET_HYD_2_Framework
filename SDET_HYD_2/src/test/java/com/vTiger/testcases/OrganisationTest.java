package com.vTiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericutil.BaseClass;
import com.vtiger.genericutil.ExcelUtility;
import com.vtiger.genericutil.JavaUtility;

public class OrganisationTest extends BaseClass{
	
	@Test(groups = "smokeTest")
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
	
	@Test(groups = "regressionTest")
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
