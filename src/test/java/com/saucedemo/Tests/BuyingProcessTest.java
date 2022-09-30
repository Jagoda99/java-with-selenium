package com.saucedemo.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.Pages.CartPage;
import com.saucedemo.Pages.CheckoutPage;
import com.saucedemo.Pages.LoginPage;
import com.saucedemo.Pages.ProductCatalog;

public class BuyingProcessTest {

	@Test
	public void buyingProcess() {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo("https://www.saucedemo.com/");
		loginPage.loginApp("standard_user", "secret_sauce");
				
		ProductCatalog productCatalog = new ProductCatalog(driver);
		productCatalog.addProductToCart("Sauce Labs Bolt T-Shirt");
		productCatalog.goToCart();
		
		CartPage cartPage = new CartPage(driver);
		Boolean verifyCart = cartPage.VerifyProduct("Sauce Labs Bolt T-Shirt");
		Assert.assertTrue(verifyCart);
		cartPage.goToCheckout();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.fillInForm("Abc", "Xyz", "12345");
		checkoutPage.continueOrder();
		Boolean verifyCheckout = checkoutPage.VerifyFinishProduct("Sauce Labs Bolt T-Shirt");
		Assert.assertTrue(verifyCheckout);
		checkoutPage.finishOrder();
		String confirmationMessage = checkoutPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANK YOU FOR YOUR ORDER"));
		
		driver.close();
	}
}