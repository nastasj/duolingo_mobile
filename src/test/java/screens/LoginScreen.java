package screens;

import com.codeborne.selenide.SelenideElement;
import config.AuthConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;


public class LoginScreen {

    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    private static final SelenideElement

            loginInput = $(id("com.duolingo:id/loginView")),
            passwordInput = $(id("com.duolingo:id/passwordView")),
            signInButton = $(id("com.duolingo:id/signinButton")),
            forgotPasswordButton = $(id("com.duolingo:id/forgotPassword")),
            facebookButton = $(id("com.duolingo:id/facebookButton")),
            googleButton = $(id("com.duolingo:id/googleButton"));

    @Step("Check Sign in button is not clickable until login and password are entered")
    public LoginScreen checkSignInButtonIsNotClickable() {
        signInButton.shouldNotBe(enabled, Duration.ofSeconds(10));
        return this;
    }

    @Step("Enter auth inputs and tap Sign in button")
    public LoginScreen enterAuthInputsAndTapSignInButton() {
        loginInput.click();
        loginInput.sendKeys(authConfig.login());
        passwordInput.click();
        passwordInput.sendKeys(authConfig.password());
        signInButton.click();
        return this;
    }

    @Step("Tap Forgot Password button")
    public LoginScreen tapForgotPasswordButton() {
        forgotPasswordButton.click();
        return this;
    }

    @Step("Check Facebook button is visible")
    public LoginScreen checkFacebookButtonIsVisible() {
        facebookButton.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Check Google button is visible")
    public LoginScreen checkGoogleButtonIsVisible() {
        googleButton.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }
}