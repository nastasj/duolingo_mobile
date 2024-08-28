package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class HomeScreen {

    private final SelenideElement

            primaryButton = $(id("com.duolingo:id/primaryButton"));

    @Step("Check Primary button is visible")
    public HomeScreen checkPrimaryButtonIsVisible() {
        primaryButton.shouldBe(visible, Duration.ofSeconds(15));
        return this;
    }
}
