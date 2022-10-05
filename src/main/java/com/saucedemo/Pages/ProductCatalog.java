package com.saucedemo.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".inventory_item")
	List<WebElement> allProducts;
	
	By addToCart = By.cssSelector(".pricebar button");
	

	public WebElement getProductByName(String productName) {

		return allProducts.stream().filter(prod ->
		prod.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)).findFirst().orElse(null);
	}
	
	public void addProductToCart(String productName) {
		
		WebElement product = getProductByName(productName);
		product.findElement(addToCart).click();
		System.out.println("Product added to card");

	}

}
