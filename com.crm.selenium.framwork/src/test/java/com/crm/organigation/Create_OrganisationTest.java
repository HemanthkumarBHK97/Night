package com.crm.organigation;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.Home_Page;
import com.crm.ObjectRepository.Validation_And_Verification;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class Create_OrganisationTest  extends BaseClass{
	@Test(groups="regressionTest")
	public void create_Organisation() throws Throwable {
		/*String key ="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);*/
		/*WebDriver driver;
		File_Utility flib=new File_Utility();
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
		//File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib =new Excel_Utility();

		//	WebDriver driver=new ChromeDriver();
		//File_Utility flib=new File_Utility();

		wlib.getWindowMaximize(driver);
		wlib.waitForPageToLoad(driver);

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
		lop.login(username, password);*/
		/*	driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		 */
		Home_Page hmp=new Home_Page(driver);
		hmp.Create_Organisation();
		
		//Assert.assertEquals(true, false);
		//	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		int ranNum=jlib.getRanDomNum();
		String data = elib.getDataFromExcel("Sheet1", 0, 0)+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Validation_And_Verification valid=new Validation_And_Verification(driver);
		valid.OrganizationValidation(driver, data);
		
		//validation part
		/*String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains(data)) {
			System.out.println("Create_Organisation is "+"pass");
		}
		else {
			System.out.println("Create_Organisation is"+"fail");
		}	*/
		/*WebElement move = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act =new Actions(driver);
		act.moveToElement(move).perform();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();*/
		hmp.Click_Admin();
		hmp.Click_Logout(); 
		wlib.closetheBrowser(driver);
	}
	/*@Test
		public void modify()
		{
			System.out.println("Modification is done");
		}*/
}
