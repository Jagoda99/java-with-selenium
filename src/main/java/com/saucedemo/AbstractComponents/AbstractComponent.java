package com.saucedemo.AbstractComponents;

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
	@FindBy(id = "react-burger-menu-btn")
	WebElement menuButton;
	@FindBy(xpath ="/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]")
	WebElement logoutLink;
	
	
	public void goTo(String url) {
		
		driver.get(url);
		System.out.println("Page is opened.");
	}
	
	public void goToCart() {
		
		cartHeader.click();
	}

}
