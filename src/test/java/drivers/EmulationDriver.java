package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulationConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class EmulationDriver implements WebDriverProvider {

    static EmulationConfig emulationConfig = ConfigFactory.create(EmulationConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(emulationConfig.platformVersion())
                .setDeviceName(emulationConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage(emulationConfig.appPackage())
                .setAppActivity(emulationConfig.appActivity());

        AndroidDriver driver = new AndroidDriver(getAppiumServerUrl(), options);

        return driver;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(emulationConfig.appiumUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appVersion = "Duolingo_v5.163.6(1925).apk";
        String appPath = "src/test/resources/apps/" + appVersion;
        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}
