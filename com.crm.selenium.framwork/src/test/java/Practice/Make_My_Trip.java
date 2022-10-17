package Practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Make_My_Trip {

	public static void main(String[] args) throws Throwable {
		String key ="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream fils =new FileInputStream("./Make_My_Trip.properties");
		Properties prop =new Properties();
		prop.load(fils);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		FileInputStream filss=new FileInputStream("./Book2.xlsx");
		Workbook wb = WorkbookFactory.create(filss);
		String from = wb.getSheet("Mytrip").getRow(0).getCell(0).getStringCellValue();
		String to = wb.getSheet("Mytrip").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(from);

		Robot rob =new Robot();
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys(to);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rob.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(1000);
		String month1="September 2022";
		String date1="30";
		driver.findElement(By.xpath("//div[text()='"+month1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date1+"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		Thread.sleep(1000);
		String month = "October";
		String date = "15";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
		
	}
}
