package stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {

    @Before(order = 1)
    public void getTitle(Scenario scenario) {
        System.out.println("Start scenario " + scenario.getName());
    }

    @Before(order = 2)
    public void getData() {
        RestAssured.baseURI = "https://app.asana.com";
        RestAssured.basePath = "/api/1.0/";
        //TODO: add configuration file for baseURI and Path
    }
}
