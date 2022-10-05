package com.saucedemo.Tests;

import com.saucedemo.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.Pages.LoginPage;

import java.io.IOException;

public class PositiveLoginTest extends Initialization {

	@Test
	public void positiveLoginTest() throws IOException {
		System.out.println("Starting positiveLoginTest");

		LoginPage loginPage = launchApp();
		loginPage.loginApp("standard_user", "secret_sauce");

		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		driver.quit();
	}

}