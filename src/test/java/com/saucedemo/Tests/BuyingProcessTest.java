package com.saucedemo.Tests;

import com.saucedemo.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.Pages.CartPage;
import com.saucedemo.Pages.CheckoutPage;
import com.saucedemo.Pages.LoginPage;
import com.saucedemo.Pages.ProductCatalog;

import java.io.IOException;

public class BuyingProcessTest extends Initialization {

	@Test
	public void buyingProcess() throws IOException {

		LoginPage loginPage = launchApp();
		ProductCatalog productCatalog = loginPage.loginApp("standard_user", "secret_sauce");

		productCatalog.addProductToCart("Sauce Labs Bolt T-Shirt");
		CartPage cartPage = productCatalog.goToCart();
		
		Boolean verifyCart = cartPage.VerifyProduct("Sauce Labs Bolt T-Shirt");
		Assert.assertTrue(verifyCart);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		
		checkoutPage.fillInForm("Abc", "Xyz", "12345");
		checkoutPage.continueOrder();
		Boolean verifyCheckout = checkoutPage.VerifyFinishProduct("Sauce Labs Bolt T-Shirt");
		Assert.assertTrue(verifyCheckout);
		checkoutPage.finishOrder();
		String confirmationMessage = checkoutPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANK YOU FOR YOUR ORDER"));
	}
}