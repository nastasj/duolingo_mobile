package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class CheckEmailBottomsheet {

    private final SelenideElement

            textBody = $(id("com.duolingo:id/body")),
            errorMessage = $(id("com.duolingo:id/errorMessage")),
            okButton = $(id("com.duolingo:id/okButton"));

    @Step("Check text body shows correct email")
    public CheckEmailBottomsheet checkBodyTitle(String email) {
        textBody.getText().contains(email);
        return this;
    }

    @Step("Check error message appears if incorrect email is entered")
    public CheckEmailBottomsheet checkErrorMessage() {
        errorMessage.shouldBe(visible);
        return this;
    }

    @Step("Tap Ok button")
    public CheckEmailBottomsheet tapOkButton() {
        okButton.click();
        return this;
    }
}
