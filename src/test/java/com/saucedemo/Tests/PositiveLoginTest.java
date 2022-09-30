package com.saucedemo.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.Pages.LoginPage;

public class PositiveLoginTest {

	@Test
	public void positiveLoginTest() {
		System.out.println("Starting positiveLoginTest");

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo("https://www.saucedemo.com/");
		loginPage.loginApp("standard_user", "secret_sauce");

		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		driver.quit();
	}

}