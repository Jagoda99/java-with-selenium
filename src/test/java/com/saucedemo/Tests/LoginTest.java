package com.saucedemo.Tests;

import com.saucedemo.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.Pages.LoginPage;

import java.io.IOException;

public class LoginTest extends Initialization {

	@Test(dataProvider = "getData")
	public void standardUserLoginTest(String email, String password) throws IOException {

		System.out.println("Starting standardUserLoginTest");

		LoginPage loginPage = launchApp();
		loginPage.loginApp(email, password);
		
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

	}
	@DataProvider
	public Object[][] getData() {

		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},
				{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
	}

}
