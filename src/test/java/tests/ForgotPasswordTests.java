package tests;

import config.AuthConfig;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import screens.*;

@Tag("mobile")
@Tag("forgot")
@Owner("Antoshkina Anastasia")
@DisplayName("Mobile forgot password cases")
public class ForgotPasswordTests extends TestBase {

    Faker faker = new Faker();

    StartScreen startScreen = new StartScreen();
    LoginScreen loginScreen = new LoginScreen();
    ForgotPasswordScreen forgotPasswordScreen = new ForgotPasswordScreen();
    CheckEmailBottomsheet checkEmailBottomsheet = new CheckEmailBottomsheet();
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Test
    @DisplayName("Check Forgot Password feature with correct email address sends email to user")
    void forgotPasswordWithCorrectEmailAddressTest() {
        startScreen.tapLoginButton();
        loginScreen.tapForgotPasswordButton();
        forgotPasswordScreen.enterEmailInputAndTapSignInButton(authConfig.login());
        checkEmailBottomsheet.checkBodyTitle();
        checkEmailBottomsheet.tapOkButton();
    }

    @Test
    @DisplayName("Check Forgot Password feature with invalid email address shows error message")
    void forgotPasswordWithInvalidEmailAddressTest() {
        startScreen.tapLoginButton();
        loginScreen.tapForgotPasswordButton();
        forgotPasswordScreen.enterEmailInputAndTapSignInButton(faker.name().firstName() + "@" + faker.name().lastName());
        checkEmailBottomsheet.checkErrorMessage();
    }

    @Test
    @DisplayName("Check Send Email button is not clickable until email is entered")
    void sendEmailButtonIsNotClickableTest() {
        startScreen.tapLoginButton();
        loginScreen.tapForgotPasswordButton();
        forgotPasswordScreen.checkSendEmailButtonIsNotClickable();
    }

    @Test
    @DisplayName("Check Quit button returns to login screen")
    void quitButtonReturnsToLoginScreenTest() {
        startScreen.tapLoginButton();
        loginScreen.tapForgotPasswordButton();
        forgotPasswordScreen.checkQuitButtonReturnsToLoginScreen();
    }
}
