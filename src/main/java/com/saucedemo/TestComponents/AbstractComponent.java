package com.saucedemo.TestComponents;

import com.saucedemo.Pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartHeader;
	
	public void goTo(String url) {
		
		driver.get(url);
		System.out.println("Page is opened.");
	}
	
	public CartPage goToCart() {
		
		cartHeader.click();
		return new CartPage(driver);
	}

}
