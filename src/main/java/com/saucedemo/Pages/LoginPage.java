package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement passwordEl;
	
	@FindBy(id = "login-button")
	WebElement submit;
	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement errorMessage;

	public String getErrorMessage() {
		return errorMessage.getText();
	}
	public ProductCatalog loginApp(String email, String password) {
		
		username.sendKeys(email);
		passwordEl.sendKeys(password);
		submit.click();
		return new ProductCatalog(driver);
		
	}
}
