package org.alicansadeler.base;

import org.alicansadeler.pages.LoginPage;
import org.alicansadeler.pages.Pages;
import org.alicansadeler.utility.ConfigReader;
import org.alicansadeler.utility.Constants;
import org.alicansadeler.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;
    protected Pages pages;

    @BeforeMethod
    public void setUp() {
        webDriver = Driver.getDriver();
        pages = new Pages();
    }

    protected void loginToN11() {
        webDriver.get(Constants.LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
