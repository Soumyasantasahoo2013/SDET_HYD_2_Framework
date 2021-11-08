package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericutils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;

	/**
	 * @return the orgLink
	 */
	public WebElement getOrgLink() {
		return orgLink;
	}

	/**
	 * @return the admImg
	 */
	public WebElement getAdmImg() {
		return admImg;
	}

	/**
	 * @return the signOutBtn
	 */
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	/**
	 * Buisness logic for clicking on Organisation
	 */
	public void clickOnOrganisation()
	{
		orgLink.click();
	}
	
	public void signOutFromVtiger() throws Throwable
	{
		mouseOver(driver, admImg);
		Thread.sleep(4000);
		signOutBtn.click();
	}

}
