package screens;

import com.codeborne.selenide.SelenideElement;
import config.AuthConfig;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ForgotPasswordScreen {

    LoginScreen loginScreen = new LoginScreen();

    private static final SelenideElement

            emailInput = $(id("com.duolingo:id/emailInput")),
            sendEmailButton = $(id("com.duolingo:id/sendEmailButton")),
            quitButton = $(id("com.duolingo:id/quit"));


    @Step("Check tapping quitButton returns to login screen")
    public ForgotPasswordScreen checkQuitButtonReturnsToLoginScreen() {
        quitButton.click();
        loginScreen.checkFacebookButtonIsVisible();
        return this;
    }

    @Step("Check Send Email button is not clickable until email are entered")
    public ForgotPasswordScreen checkSendEmailButtonIsNotClickable() {
        sendEmailButton.shouldNotBe(enabled);
        return this;
    }

    @Step("Enter email input and tap Sign in button")
    public ForgotPasswordScreen enterEmailInputAndTapSignInButton(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
        sendEmailButton.click();
        return this;
    }
}
