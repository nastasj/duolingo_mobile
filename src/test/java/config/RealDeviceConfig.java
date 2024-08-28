package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:real.properties"
})

public interface RealDeviceConfig extends Config {

    String appiumUrl();

    String appPackage();

    String appActivity();

    String platformVersion();

    String deviceName();
}
