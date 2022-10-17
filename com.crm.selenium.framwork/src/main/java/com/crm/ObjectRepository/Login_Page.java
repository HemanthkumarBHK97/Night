package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public  Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameTextField;

	@FindBy(name="user_password")
	private WebElement passwordTextField;
     
	@FindBy(id="submitButton")
	private WebElement submitButton ;

	public WebElement getUserNameTextField() {
		return usernameTextField;
	}
	public WebElement getpasswordTextField() {
		return passwordTextField;
	}
public	WebElement getSubmitButton() {
	return submitButton;	
	}
	 public void login(String userName, String password) {
		 usernameTextField.sendKeys(userName);
		 passwordTextField.sendKeys(password);
		 submitButton.click();
	}
}
