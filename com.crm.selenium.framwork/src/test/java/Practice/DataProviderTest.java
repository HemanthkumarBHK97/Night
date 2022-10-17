package Practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test( dataProvider = "dataProvider_test")
	public void CompanyDetails(String name,String phoneNO,String email) {
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(phoneNO);
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(email);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		driver.quit();
	}
	@DataProvider
	public Object[][] dataProvider_test(){
		Object[][] objArr =new Object[3][3];
		objArr[0][0]="AAA";
		objArr[0][1]="9132165488";
		objArr[0][2]="Hemanth.selenium@gamil.com";

		objArr[1][0]="BBB";
		objArr[1][1]="9132165487";
		objArr[1][2]="Hemanth.selenium1@gmail.com";

		objArr[2][0]="CCC";
		objArr[2][1]="9132165486";
		objArr[2][2]="Hemanth.selenium2@gmail.com";
		return objArr;

	}
}
