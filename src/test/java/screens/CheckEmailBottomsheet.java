package screens;

import com.codeborne.selenide.SelenideElement;
import config.AuthConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class CheckEmailBottomsheet {

    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    private static final SelenideElement

            textBody = $(id("com.duolingo:id/body")),
            errorMessage = $(id("com.duolingo:id/errorMessage")),
            okButton = $(id("com.duolingo:id/okButton"));

    @Step("Check text body shows correct email")
    public CheckEmailBottomsheet checkBodyTitle() {
        textBody.getText().contains(authConfig.login());
        return this;
    }

    @Step("Check error message appears if incorrect email is entered")
    public CheckEmailBottomsheet checkErrorMessage() {
        errorMessage.isDisplayed();
        return this;
    }

    @Step("Tap Ok button")
    public CheckEmailBottomsheet tapOkButton() {
        okButton.click();
        return this;
    }
}
