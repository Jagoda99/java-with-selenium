package com.saucedemo.TestComponents;

import com.saucedemo.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Initialization {

    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "GlobalData.properties");
        prop.load(ip);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        return driver;
    }
    @BeforeMethod
    public LoginPage launchApp() throws IOException {
        driver = initializeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo("https://www.saucedemo.com/");
        return loginPage;

    }
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }



}
