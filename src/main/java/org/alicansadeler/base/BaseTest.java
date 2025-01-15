package org.alicansadeler.base;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.alicansadeler.pages.LoginPage;
import org.alicansadeler.pages.Pages;
import org.alicansadeler.utility.ConfigReader;
import org.alicansadeler.utility.Constants;
import org.alicansadeler.utility.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
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
    @Step("N11'e login olunuyor")
    protected void loginToN11() {
        webDriver.get(Constants.LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS) {
            screenshot();
        }
        Driver.closeDriver();
    }
}
