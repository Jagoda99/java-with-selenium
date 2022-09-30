package com.saucedemo.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> cartProducts;
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutButton;
	
	public Boolean VerifyProduct(String productName) {
		
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> 
		cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	public void goToCheckout() {
		
		checkoutButton.click();
		
	}
	

}
