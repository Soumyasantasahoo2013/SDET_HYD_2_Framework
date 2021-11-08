package com.vtiger.genericutils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	/**
	 * This method to select by index
	 * @param ele
	 * @param index
	 */
	public void selectByIndex(WebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method to select by visible text
	 * @param ele
	 * @param visText
	 */
	public void selectByVisibleText(WebElement ele,String visText)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(visText);
	}
	
	/**
	 * This method will wait for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void waitForElementtobeVisible(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	 /**
     * this method will perform mouse over action
     * @param driver
     * @param element
     */
    public void mouseOver(WebDriver driver, WebElement element)
    {
    	Actions act = new Actions(driver);
    	act.moveToElement(element).perform();
    }
    
    /**
     * this method perfoem right click action
     * @param driver
     * @param element
     */
    public void rightClick(WebDriver driver, WebElement element)
    {
    	Actions act = new Actions(driver);
    	act.contextClick(element).perform();
    }
    
    public void maximiseWin(WebDriver driver)
    {
    	driver.manage().window().maximize();
    }
    
    /**
     * this method helps to switch from one window to another window
     * @param driver
     * @param partialWinTitle
     */
    public void switchToWindow(WebDriver driver, String partialWinTitle)
    {
    	Set<String> window = driver.getWindowHandles();
    	Iterator<String> it = window.iterator();
    	while(it.hasNext())
    	{
    		String winID=it.next();
    		String title = driver.switchTo().window(winID).getTitle();
    		if(title.contains(partialWinTitle))
    		{
    			break;
    		}
    	}
    }
    
    /**
     * accept alert pop up
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    /**
     * dismiss alert pop up
     * @param driver
     */
    public void dissmisAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    /**
     * switch to frame based on element
     * @param driver
     * @param element
     */
    public void switchToFrame(WebDriver driver, WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    
    /**
     * switch to frame based on index
     * @param driver
     * @param index
     */
    public void switchToFrame(WebDriver driver, int index)
    {
    	driver.switchTo().frame(index);
    }
    
    /**
     * switch to frame based on id or name
     * @param driver
     * @param idOrName
     */
    public void switchToFrame(WebDriver driver, String idOrName)
    {
    	driver.switchTo().frame(idOrName);
    }
    
    /**
     * it will take the screen shot 
     * @param driver
     * @param screenshotName
     * @throws Throwable
     */
    public String takeScreenShot(WebDriver driver, String screenshotName) throws Throwable
    {
    	String screenshotpath="./screenshot/"+screenshotName+".PNG";
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst = new File(screenshotpath);
    	Files.copy(src, dst);
    	return screenshotpath;
    }
    
    /**
     * this will scroll to a particular web element
     * @param driver
     * @param element
     */
    public void scrollToWebElement(WebDriver driver, WebElement element)
    {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	int y = element.getLocation().getY();
    	js.executeScript("window.scrollBy(0,"+y+")", element);
    }
    
    /**
     * this method will press the enter key on keyboard 
     * @throws Throwable
     */
    public void pressEnter() throws Throwable
    {
    	Robot rc = new Robot();
    	rc.keyPress(KeyEvent.VK_ENTER);
    	rc.keyRelease(KeyEvent.VK_ENTER);
    	
    }

}
