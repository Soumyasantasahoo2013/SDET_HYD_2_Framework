package com.vTiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.genericutils.BaseClass;
import com.vtiger.genericutils.ExcelUtility;
import com.vtiger.genericutils.JSONFileUtility;
import com.vtiger.genericutils.JavaUtility;
import com.vtiger.genericutils.WebDriverUtility;
import com.vtiger.objectRepository.CreateOrganisation;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganisationPage;

public class CreateOrganisationWithIndustry extends BaseClass{

	@Test
	public void createOrganisationWithIndustry() throws Throwable
	{
		ExcelUtility eUtil=new ExcelUtility();
		String orgName = eUtil.excelUtility("Sheet1",1 , 2)+"_"+JavaUtility.generateRandomNumber();
		String indusType = eUtil.excelUtility("Sheet1", 3, 3);

		//Create Organisation with Industry
		hp=new HomePage(driver);
		hp.clickOnOrganisation();

		OrganisationPage op=new OrganisationPage(driver);
		op.clickOnCreateOrg();
		
		CreateOrganisation co=new CreateOrganisation(driver);
		co.createOrgNamewithIndustry(orgName, indusType);
	}

}
