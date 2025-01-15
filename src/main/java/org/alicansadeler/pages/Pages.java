package org.alicansadeler.pages;

import org.alicansadeler.utility.Driver;
import org.openqa.selenium.WebDriver;

public class Pages {

    private WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;

    public Pages() {
        this.webDriver = Driver.getDriver();
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
