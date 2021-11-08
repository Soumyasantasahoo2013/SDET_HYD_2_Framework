package com.vtiger.objectRepository;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfo {
	
	public OrganisationInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement orgInfo;

	/**
	 * @return the orgInfo
	 */
	public WebElement getOrgInfo() {
		return orgInfo;
	}
	
	public void verifyOrgName(String organisationName)
	{
		String organisationInfo = orgInfo.getText();
		Assert.assertTrue(organisationInfo.contains(organisationName));
	}

}
