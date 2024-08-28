package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:emulation.properties"
})

public interface EmulationConfig extends Config {

    String appiumUrl();

    String appPackage();

    String appActivity();

    String platformVersion();

    String deviceName();
}


