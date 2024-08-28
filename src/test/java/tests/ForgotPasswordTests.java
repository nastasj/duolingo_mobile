package tests;

import com.github.javafaker.Faker;
import config.DuolingoAuthConfig;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.CheckEmailBottomsheet;
import screens.ForgotPasswordScreen;
import screens.LoginScreen;
import screens.StartScreen;

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
    DuolingoAuthConfig authConfig = ConfigFactory.create(DuolingoAuthConfig.class, System.getProperties());

    @Test
    @DisplayName("Check Forgot Password feature with correct email address sends email to user")
    void forgotPasswordWithCorrectEmailAddressTest() {
        startScreen.tapLoginButton();
        loginScreen.tapForgotPasswordButton();
        forgotPasswordScreen.enterEmail(authConfig.login());
        forgotPasswordScreen.tapSendEmailButton();
        checkEmailBottomsheet.checkBodyTitle(authConfig.login());
        checkEmailBottomsheet.tapOkButton();
    }

    @Test
    @DisplayName("Check Forgot Password feature with invalid email address shows error message")
    void forgotPasswordWithInvalidEmailAddressTest() {
        startScreen.tapLoginButton();
        loginScreen.tapForgotPasswordButton();
        forgotPasswordScreen.enterEmail(faker.name().firstName() + "@" + faker.name().lastName());
        forgotPasswordScreen.tapSendEmailButton();
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
