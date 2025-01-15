package org.alicansadeler;

import io.qameta.allure.Step;
import org.alicansadeler.base.BaseTest;
import org.alicansadeler.utility.ConfigReader;
import org.alicansadeler.utility.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Başarılı kullanıcı girişi")
    @Step("Başarılı login testi gerçekleştiriliyor")
    public void loginTestSuccess() {
        loginToN11();
        Assert.assertTrue(pages.getHomePage().isUserLoggedIn(), "Kullanıcı giriş yapmamış");
    }

    @Test(description = "Yanlış email ile hata mesajı görüntüleniyor")
    @Step("Yanlış email ile login testi gerçekleştiriliyor")
    public void loginTestUnSuccessForEmail() {
        webDriver.get(Constants.LOGIN_URL);
        pages.getLoginPage().login("invalidemail@test.com", ConfigReader.getProperty("password"));
        Assert.assertTrue(pages.getLoginPage().isErrorMessage(), "Hata mesajı görüntülenemedi");
        Assert.assertEquals(pages.getLoginPage().getErrorMessage(), "E-posta adresi veya şifre hatalı, kontrol edebilir misin?"
        , "Hata mesajı beklendiği gibi değil");
    }

    @Test(description = "Yanlış password ile hata mesajı görüntüleniyor")
    @Step("Yanlış password ile login testi gerçekleştiriliyor")
    public void loginTestUnSuccessForPassword() {
        webDriver.get(Constants.LOGIN_URL);
        pages.getLoginPage().login(ConfigReader.getProperty("email"), "invalidpass1");
        Assert.assertTrue(pages.getLoginPage().isErrorMessage(), "Hata mesajı görüntülenemedi");
        Assert.assertEquals(pages.getLoginPage().getErrorMessage(), "E-posta adresi veya şifre hatalı, kontrol edebilir misin?"
                , "Hata mesajı beklendiği gibi değil");
    }

    @Test(description = "Boş email ile giriş yapılamaz")
    @Step("Boş email alanı ile login testi gerçekleştiriliyor")
    public void loginTestEmptyEmail() {
        webDriver.get(Constants.LOGIN_URL);
        pages.getLoginPage().login("", ConfigReader.getProperty("password"));
        Assert.assertEquals(pages.getLoginPage().getValidationMessage(), "Geçerli bir e-posta adresi girmelisin.",
                "Geçersiz hata mesajı");

    }

    @Test(description = "Boş şifre ile giriş yapılamaz")
    @Step("Boş şifre alanı ile login testi gerçekleştiriliyor")
    public void loginTestEmptyPassword() {
        webDriver.get(Constants.LOGIN_URL);
        pages.getLoginPage().login(ConfigReader.getProperty("email"), "");
        Assert.assertEquals(pages.getLoginPage().getPasswordValidationMessage(), "Şifreni girebilir misin?",
                "Geçersiz hata mesajı");

    }

    @Test(description = "Şifre alanına maksimum 15 karakter girilebilir")
    @Step("Şifre karakter sayısı validasyonu ile login testi gerçekleştiriliyor")
    public void loginTestPasswordNumberOfCharacters() {
        webDriver.get(Constants.LOGIN_URL);
        pages.getLoginPage().login(ConfigReader.getProperty("email"), "invalidpassword1234");
        Assert.assertEquals(pages.getLoginPage().getPasswordValidationMessage(), "Girilen değer en fazla 15 karakter olmalıdır."
        , "Geçersiz hata mesajı");
    }
}
