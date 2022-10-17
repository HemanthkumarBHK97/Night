package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Data_From_XL {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		FileInputStream fils =new FileInputStream("./Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fils);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
		System.out.println(data);
		
		
	}   

}
