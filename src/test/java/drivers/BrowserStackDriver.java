package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    public AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    private static final BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", authConfig.userName());
        caps.setCapability("browserstack.key", authConfig.accessKey());
        caps.setCapability("url", config.url());
        caps.setCapability("app_url", config.app());
        caps.setCapability("device", config.deviceName());
        caps.setCapability("platformName", config.platformVersion());
        caps.setCapability("project", config.projectName());
        caps.setCapability("build", config.buildName());
        caps.setCapability("name", config.name());

        try {
            return new RemoteWebDriver(
                    new URL(config.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);

        }
    }
}
