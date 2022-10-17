package com.crm.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.Home_Page;
import com.crm.ObjectRepository.Login_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_ProductTest extends BaseClass {
	@Test(groups= {"regressionTest"})
	public void delete_ProductTest() throws Throwable {
	//public static void main(String[] args) throws Throwable {
		/*String key ="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		//WebDriver driver=new ChromeDriver();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib =new Excel_Utility();
		
		WebDriver driver;
		String BROWSER= flib.getPropertyKeyValue1("browser");
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(); 
		}
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
		WebDriver_Utility wlib=new WebDriver_Utility();
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib =new Excel_Utility();
		
		
		wlib.getWindowMaximize(driver);
		
		wlib.waitForPageToLoad(driver);

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*String URL = flib.getPropertyKeyValue1("url");
		String username =flib.getPropertyKeyValue1("un");
		String password=flib.getPropertyKeyValue1("pw");
		/*FileInputStream fils =new FileInputStream("./Common_Data.properties");
		Properties prop=new Properties();
		prop.load(fils);
		String URL= prop.getProperty("url");
		String username = prop.getProperty("un");
		String password = prop.getProperty("pw");
		driver.get(URL);
		Login_Page lop=new Login_Page(driver);
		lop.login(username, password);
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		Home_Page hmp=new  Home_Page(driver);
		hmp.Create_Products();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("Dummy_Product");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		driver.findElement(By.xpath("//input[@name='Delete']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		hmp.Click_Admin();
		hmp.Click_Logout();
		wlib.closetheBrowser(driver);
	}
	}

