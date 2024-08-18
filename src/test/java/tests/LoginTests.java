package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.*;

@Tag("mobile")
@Tag("login")
@Owner("Antoshkina Anastasia")
@DisplayName("Mobile login cases")
public class LoginTests extends TestBase {

    StartScreen startScreen = new StartScreen();
    LoginScreen loginScreen = new LoginScreen();
    HomeScreen homescreen = new HomeScreen();

    @Test
    @DisplayName("Check successful login")
    void successfulLoginTest() {
        startScreen.tapLoginButton();
        loginScreen.enterAuthInputsAndTapSignInButton();
        homescreen.checkGuidebookButtonIsVisible();
    }

    @Test
    @DisplayName("Check Sign In button is not clickable until login and password are entered")
    void signInButtonIsNotClickableTest() {
        startScreen.tapLoginButton();
        loginScreen.checkSignInButtonIsNotClickable();
    }

    @Test
    @DisplayName("Check Facebook button is visible")
    void checkFacebookButtonIsVisibleTest() {
        startScreen.tapLoginButton();
        loginScreen.checkFacebookButtonIsVisible();
    }

    @Test
    @DisplayName("Check Google button is visible")
    void checkGoogleButtonIsVisibleTest() {
        startScreen.tapLoginButton();
        loginScreen.checkGoogleButtonIsVisible();
    }
}
