package com.crm.Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.Login_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

public class BaseClass
{
	File_Utility flib=new File_Utility();

	 public WebDriver driver;
	 //comes from take screenshot
	 public static WebDriver sDriver;
	 
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void bS() {
		System.out.println("DataBase connetion");
	}
	
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void bF() {
		System.out.println("Execuet in parallel mode");
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	//public void bC( String BROWSER) throws Throwable {
	public void bC() throws Throwable {
			String BROWSER = flib.getPropertyKeyValue1("browser");
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
		}
		sDriver=driver;
		
		System.out.println("lanching the browswe");
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void bM() throws Throwable {
		String URL = flib.getPropertyKeyValue1("url");
		String username =flib.getPropertyKeyValue1("un");
		String password=flib.getPropertyKeyValue1("pw");
		
		driver.get(URL);
		Login_Page lop=new Login_Page(driver);
		lop.login(username, password);
		System.out.println("Login to applicaton");
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void aM() {
		System.out.println("logout the application");	
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void aC() {
		System.out.println("close the browser");
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void aT() {
		System.out.println("Execute sucessfully");	
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void aS() {
		System.out.println("DataBase close");
	}
}
