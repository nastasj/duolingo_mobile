package config;

import org.aeonbits.owner.Config;

import java.time.Duration;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:real.properties"
})

public interface RealDeviceConfig extends Config {

    String appUrl();

    String appiumUrl();

    String appPackage();

    String appActivity();

    String platformVersion();

    String deviceName();

    String automationName();
}
