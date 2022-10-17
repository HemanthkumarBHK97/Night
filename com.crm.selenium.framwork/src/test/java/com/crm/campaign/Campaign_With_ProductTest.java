package com.crm.campaign;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.Home_Page;

public class Campaign_With_ProductTest extends  BaseClass{

	@Test(groups= {"regressionTest"})
	public void campaign_With_ProductTest() throws Throwable {
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib =new Excel_Utility();
		

		//public static void main(String[] args) throws Throwable {
		/*	String key ="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver;
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
		}

		WebDriver_Utility wlib=new WebDriver_Utility();
		//	File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib =new Excel_Utility();

		//WebDriver driver=new ChromeDriver();*/

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
		Home_Page hmp=new Home_Page(driver);
		hmp.more_opt();
		/*driver.findElement(By.xpath("//a[text()='More']")).click();*/
		hmp.Create_Capaign_With_Product();
		//driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//RandomNum
		int ranNum =jlib.getRanDomNum();

		String data = elib.getDataFromExcel("Campaign", 0, 0)+ranNum;

		/*FileInputStream fils1=new FileInputStream("./Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fils1);
		Sheet sheet = wb.getSheet("Campaign");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue()+ranNum;*/
		System.out.println(data);	
		driver.findElement(By.name("campaignname")).sendKeys(data);
		//driver.findElement(By.name("button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		/*Set<String> allwin = driver.getWindowHandles();
		for(String wh: allwin )
		{
			driver.switchTo().window(wh);
		}		*/

		wlib.switchToWindow(driver, "Products&action");

		driver.findElement(By.id("search_txt")).sendKeys("LAP_TAP");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='LAP_TAP']")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(title.contains(data)) {
			System.out.println("title has match");
		}
		else {
			System.out.println("title has not match");
		}
		Thread.sleep(2000);
		hmp.Click_Admin();
		hmp.Click_Logout();
		wlib.closetheBrowser(driver);
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
	}
}

