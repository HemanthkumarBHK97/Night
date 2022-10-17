package com.crm.Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

/**
 *  @param driver
 *  @author SURYA PRAKASH B
 *  @param Element
 *
 */

public class WebDriver_Utility {
	/**
	 * wait for page to load before identifying any synchronized  element in DOM
	 * @param driver
	 */
	public void  waitForPageToLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	/** 
	 * After every action it will for next action to perform
	 * @param driver
	 * @param element
	 */

	
	/**
	 * used to window maximize
	 * @param driver
	 * @author SURYA PRAKASH B
	 */
	public void getWindowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	

	public void	waitForElementToBeclick(WebDriver driver , WebElement element){
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void	waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element){
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Element));	
	}

	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}

	public void  waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element, int pollingTime) {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	/**
	 * used to switch to any window based on window title
	 * @param diver 
	 * @param partialWindowTitle
	 * @author  Hemanth
	 */


	public void     switchToWindow(WebDriver driver, String partialWindowTitle){
		Set<String> allid=driver.getWindowHandles();
		Iterator<String> it=allid.iterator();
		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to switch to alertWindow to alertwindow and accept(click on ok button)
	 * @param driver 
	 * @author Hemanth
	 */
	
	
	
	public void switchToAlertAndDismiss( WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame window based on index
	 * @param driver
	 * @param index
	 * @author Hemanth
	 */
	
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to  switch to frame window based on id or name attribute
	 * @param element
	 * @param index
	 * @author hemanth
	 */
	
	public void switchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}
	/**
	 * used to select the value from the dropDown based on index
	 * @param 
	 */
	
/**
 * used to close the browser tabs
 * @param driver
 * @author SURYA PRAKASH B
 */
	public void closetheBrowser(WebDriver driver) {
		driver.close();
	}
}
