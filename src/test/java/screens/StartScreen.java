package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class StartScreen {

    private final SelenideElement

            loginButton = $(id("com.duolingo:id/introFlowLoginButton"));

    @Step("Tap Login button")
    public StartScreen tapLoginButton() {
        loginButton.click();
        return this;
    }
}
