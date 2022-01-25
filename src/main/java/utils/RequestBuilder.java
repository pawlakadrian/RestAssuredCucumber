package utils;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.restassured.response.Response;
import testBase.TestBase;

import static io.restassured.RestAssured.given;

public class RequestBuilder extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(RequestBuilder.class);

    //work with workspace
    public Response sendGET_WORKSPACE(String token) {
        Response response =
            given().
                    auth().oauth2(token)
                    .log().all().
            when().
                get("/workspaces");
        return response;
    }
}
