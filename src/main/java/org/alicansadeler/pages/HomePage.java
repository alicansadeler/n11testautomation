package org.alicansadeler.pages;

import org.alicansadeler.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "user")
    private WebElement userNameText;

    public String getUserNameText() {
        return getText(userNameText);
    }

    public boolean isUserLoggedIn() {
        return userNameText.isDisplayed();
    }
}
