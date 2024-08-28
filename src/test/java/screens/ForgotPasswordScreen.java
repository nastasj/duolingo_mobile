package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ForgotPasswordScreen {

    private final SelenideElement

            emailInput = $(id("com.duolingo:id/emailInput")),
            sendEmailButton = $(id("com.duolingo:id/sendEmailButton")),
            quitButton = $(id("com.duolingo:id/quit"));

    LoginScreen loginScreen = new LoginScreen();

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

    @Step("Enter email")
    public ForgotPasswordScreen enterEmail(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Tap Send Email button")
    public ForgotPasswordScreen tapSendEmailButton() {
        sendEmailButton.click();
        return this;
    }
}
