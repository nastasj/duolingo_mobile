package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:browserstack.properties"
})

public interface BrowserStackConfig extends Config {

    String url();

    String app();

    String deviceName();

    String platformVersion();

    String projectName();

    String buildName();

    String name();
}
