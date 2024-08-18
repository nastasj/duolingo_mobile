package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackDriver;
import drivers.EmulationDriver;
import drivers.RealDeviceDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.remoteConnectionTimeout = 30000;
        String deviceHost = System.getProperty("deviceHost");
        if ((deviceHost == null) || deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserStackDriver.class.getName();
        } else if (deviceHost.equals("emulation")) {
            Configuration.browser = EmulationDriver.class.getName();
        } else {
            Configuration.browser = RealDeviceDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        Attach.pageSource();
        String deviceHost = System.getProperty("deviceHost");
        if ((deviceHost == null) || deviceHost.equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            Attach.addVideo(sessionId);
        }
        closeWebDriver();
    }
}
