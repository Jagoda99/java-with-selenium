package com.saucedemo.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.Pages.LoginPage;

public class NegativeLoginTest {

	@Test
	public void negativeLoginTests() {

		System.out.println("Starting negativeLoginTest");

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo("https://www.saucedemo.com/");
		loginPage.loginApp("wrong_user", "secret_sauce");

		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		String actualErrorMessage = errorMessage.getText();
		String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: "
						+ expectedErrorMessage);

		driver.quit();
	}
}
