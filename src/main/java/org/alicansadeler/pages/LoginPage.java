package org.alicansadeler.pages;

import io.qameta.allure.Step;
import org.alicansadeler.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    @Step("Login işlemi gerçekleştiriliyor. Email: {0}")
    public void login(String email, String password) {
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    @Step("Hata mesajı görünülürlüğü kontrol ediliyor.")
    public boolean isErrorMessage() {
        return errorMessage.isDisplayed();
    }

    @Step("Hata mesajı getiriliyor.")
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Validasyon mesajı getiriliyor.")
    public String getValidationMessage() {
        return getText(validationMessage);
    }

    @Step("Password validasyon mesajı getiriliyor.")
    public String getPasswordValidationMessage() {
        return getText(passwordValidationMessage);
    }
}
