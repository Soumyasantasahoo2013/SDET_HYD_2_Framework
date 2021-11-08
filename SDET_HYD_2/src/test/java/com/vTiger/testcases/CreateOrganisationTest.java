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

import com.vtiger.genericutils.BaseClass;
import com.vtiger.genericutils.ExcelUtility;
import com.vtiger.genericutils.JavaUtility;
import com.vtiger.genericutils.PropertyFileUtility;
import com.vtiger.genericutils.WebDriverUtility;
import com.vtiger.objectRepository.CreateOrganisation;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganisationInfo;
import com.vtiger.objectRepository.OrganisationPage;

public class CreateOrganisationTest extends BaseClass{

	@Test
	public void createOrganisationTest() throws Throwable
	{
		ExcelUtility eUtil=new ExcelUtility();
		String orgName = eUtil.excelUtility("Sheet1",1 , 2)+"_"+JavaUtility.generateRandomNumber();

		//Create Organisation
		hp=new HomePage(driver);
		hp.clickOnOrganisation();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.clickOnCreateOrg();
		
		CreateOrganisation co=new CreateOrganisation(driver);
		co.createOrgName(orgName);

		OrganisationInfo oi=new OrganisationInfo(driver);
		oi.verifyOrgName(orgName);
	}

}
