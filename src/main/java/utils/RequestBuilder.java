package utils;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.restassured.response.Response;
import org.json.JSONObject;
import testBase.TestBase;

import java.io.File;

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

    public Response sendPOST_CREATE_PROJECT(String token, File json) {
        Response response =
            given().
                    auth().oauth2(token)
                    .log().all().
            when().
                    body(json).
                    post("workspaces/1201734623930486/projects");
        return response;
    }
}
