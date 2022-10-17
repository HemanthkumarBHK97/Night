package com.crm.Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	public void onTestFailure(ITestResult result) {
		String data = result.getMethod().getMethodName();
		System.out.println(data+"----i am executing the listners----");
		
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sDriver);
		File scr = edriver.getScreenshotAs(OutputType.FILE);
		try {
		File des = new File("./com.crm.selenium.framwork/ScreenShoot/"+data+".png");
			FileUtils.copyFile(scr, des);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
