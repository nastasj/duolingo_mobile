package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
})
public interface DuolingoAuthConfig extends Config {

    String login();

    String password();
}
