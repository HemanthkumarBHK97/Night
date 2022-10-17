package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation_And_Verification {
	public  Validation_And_Verification( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
			WebElement actualOrganizationData;
	//getter method

	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}

	//Business
	public void  OrganizationValidation (WebDriver driver,String data) {
		String actData = actualOrganizationData.getText();
		if(actData.contains(data)) {
			System.out.println("Create_Organisation is "+"pass");
		}
		else {
			System.out.println("Create_Organisation is"+"fail");
		}	
	}
	
	
	
	
	public void setActualOrganizationData(WebElement actualOrganizationData) {
		this.actualOrganizationData = actualOrganizationData;
	}	
}

