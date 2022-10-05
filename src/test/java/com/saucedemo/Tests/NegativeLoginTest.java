package com.saucedemo.Tests;

import com.saucedemo.TestComponents.Initialization;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.Pages.LoginPage;

import java.io.IOException;

public class NegativeLoginTest extends Initialization {

	@Test
	public void negativeLoginTests() throws IOException {

		System.out.println("Starting negativeLoginTest");

		LoginPage loginPage = launchApp();

		loginPage.loginApp("wrong_user", "secret_sauce");

		String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage,
				"Actual error message does not contain expected");

	}
}
