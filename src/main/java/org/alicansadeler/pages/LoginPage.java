package org.alicansadeler.pages;

import org.alicansadeler.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(className = "error-message")
    private WebElement errorMessage;

    @FindBy(className = "errorText")
    private WebElement validationMessage;

    @FindBy(xpath = "//div[@data-errormessagefor='password']//div[@class='errorText']")
    private WebElement passwordValidationMessage;

    public void login(String email, String password) {
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    public boolean isErrorMessage() {
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public String getValidationMessage() {
        return getText(validationMessage);
    }

    public String getPasswordValidationMessage() {
        return getText(passwordValidationMessage);
    }
}
