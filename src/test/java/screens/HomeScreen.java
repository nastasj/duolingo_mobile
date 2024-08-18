package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class HomeScreen {

    private static final SelenideElement

            path = $(id("com.duolingo:id/path")),
            guidebookButton = $(id("com.duolingo:id/guidebook"));

    @Step("Check Guidebook button is visible")
    public HomeScreen checkGuidebookButtonIsVisible() {
        path.shouldBe(visible, Duration.ofSeconds(15)).click();
        guidebookButton.shouldBe(visible, Duration.ofSeconds(15));
        return this;
    }
}
