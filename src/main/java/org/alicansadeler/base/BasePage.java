package org.alicansadeler.base;

import org.alicansadeler.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage() {
        this.webDriver = Driver.getDriver();
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    public void waitForVisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement webElement) {
        waitForVisibility(webElement);
        webElement.click();
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement webElement) {
        waitForVisibility(webElement);
        return webElement.getText();
    }
}
