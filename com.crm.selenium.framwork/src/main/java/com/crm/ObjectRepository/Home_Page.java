package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public	Home_Page(WebDriver driver ){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement Create_Organigation;

	@FindBy(xpath="//a[text()='Products']")
	private WebElement  Create_Products;

	@FindBy (xpath="//a[text()='Contacts']")
	private WebElement Create_Contact;

	@FindBy(xpath="//a[text()='More']")
	private WebElement more_opt;

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement Create_Capmaign;

	@FindBy(name="Campaigns")
	private WebElement Create_Capaign_With_Product;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Click_Admin;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Click_Logout;

	public WebElement getCreate_Organigation() {
		return Create_Organigation;
	}
	public WebElement getCreate_Products() {
		return Create_Products;
	}
	public WebElement getCreate_Contact() {
		return Create_Contact;
	}
	public WebElement getMore_opt() {
		return more_opt;
	}
	public WebElement getCreate_Capaign_With_Product() {
		return  Create_Capaign_With_Product;
	}
	public WebElement getCreate_Capmaign() {
		return Create_Capmaign;
	}
	public void Create_Organisation() {
		Create_Organigation.click();
	}
	public void Create_Products() {
		Create_Products.click();
	}
	public void Create_contact() {
		Create_Contact.click();
	}
	public void more_opt() {
		more_opt.click();
	}

	public void Create_Capaign_With_Product() {
		Create_Capaign_With_Product.click();
	}
	public void Create_Capmaign() {
		Create_Capmaign.click();
	}
	public void Click_Admin() {
		Click_Admin.click();		
	}
	public void Click_Logout() {
		Click_Logout.click();	
	}
}
