package helpers;

import config.BrowserStackAuthConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserStack {

    private static final BrowserStackAuthConfig authConfig = ConfigFactory.create(BrowserStackAuthConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(authConfig.userName(), authConfig.accessKey())
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
