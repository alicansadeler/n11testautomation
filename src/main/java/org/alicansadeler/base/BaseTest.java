package org.alicansadeler.base;

import org.alicansadeler.utility.Constants;
import org.alicansadeler.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = Driver.getDriver();
        webDriver.get(Constants.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
