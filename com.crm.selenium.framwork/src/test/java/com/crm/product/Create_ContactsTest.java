package com.crm.product;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.Home_Page;

public class Create_ContactsTest extends BaseClass {
	@Test(groups= {"regressionTest"})
	public void create_ContactsTest() throws Throwable {

		WebDriver_Utility wlib=new WebDriver_Utility();
		//File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib =new Excel_Utility();

		//public static void main(String[] args) throws Throwable {
		/*String key ="webdriver.chrome.driver";
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
		}*/

	

		//WebDriver driver=new ChromeDriver();
		wlib.getWindowMaximize(driver);
		wlib.waitForPageToLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	/*	String URL = flib.getPropertyKeyValue1("url");
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
		//	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		hmp.Create_contact();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		int ranNum=jlib.getRanDomNum();

		String data = elib.getDataFromExcel("Contacts", 0, 0)+ranNum;
		String data1 = elib.getDataFromExcel("Contacts", 0, 1);

		/*FileInputStream fils2 =new FileInputStream("./Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fils2);
		String frist = wb.getSheet("Contacts").getRow(1).getCell(0).getStringCellValue();
		String last = wb.getSheet("Contacts").getRow(0).getCell(1).getStringCellValue();*/
		//	String data = cell.getStringCellValue()+ranNum;
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys(data);
		driver.findElement(By.name("lastname")).sendKeys(data1);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		//wlib.switchToWindow(driver, data1);
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		
		/*System.out.println(driver.getTitle());
		Set<String> allwin = driver.getWindowHandles();
		for( String wh:allwin) {
			driver.switchTo().window(wh);
		}*/
		wlib.switchToWindow(driver, parent);
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("Qspiders100");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(title.contains(data)) {
			System.out.println("title is matching");
		}
		else {
			System.out.println("title is not matching");
		}
		hmp.Click_Admin();
		hmp.Click_Logout(); 
		wlib.closetheBrowser(driver);
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
	}
}

