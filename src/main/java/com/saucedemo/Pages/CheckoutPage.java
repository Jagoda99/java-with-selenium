package com.saucedemo.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> finishProducts;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishButton;
	
	@FindBy(css = ".complete-header")
	WebElement confirmationMessage;
	

	public void fillInForm(String first_name, String last_name, String postal_code) {
		
		firstName.sendKeys(first_name);
		lastName.sendKeys(last_name);
		postalCode.sendKeys(postal_code);
	}

	public void continueOrder() {

		continueButton.click();
	}
	
	public Boolean VerifyFinishProduct(String productName) {

		return finishProducts.stream().anyMatch(finishProduct ->
				finishProduct.getText().equalsIgnoreCase(productName));
	}
	public void finishOrder() {

		finishButton.click();
	}

	public String verifyConfirmationMessage() {

		return confirmationMessage.getText();
	}

}
