package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) throws IOException {
		String key ="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		FileInputStream fils =new FileInputStream("./Common_Data.properties");
		Properties prop=new Properties();
		prop.load(fils);
		String URL= prop.getProperty("url");
		String username = prop.getProperty("un");
		String password = prop.getProperty("pw");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		FileInputStream fils2 =new FileInputStream("./Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fils2);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
		driver.findElement(By.name("accountname")).sendKeys(data);
		
	}
}
