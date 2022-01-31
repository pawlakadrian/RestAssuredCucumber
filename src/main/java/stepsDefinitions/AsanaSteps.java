package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Workspace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testBase.TestBase;
import utils.JsonConnector;
import utils.RequestBuilder;

import java.io.File;

import static org.hamcrest.core.Is.is;

public class AsanaSteps extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(AsanaSteps.class);
    Workspace workspace;

    private static String token = data.getToken();

    @Given("I have workspace object")
    public void i_have_workspace_object() {
        workspace = JsonConnector.fillWorkspaceData(new File(WORKSPACE_PATH));
        requestBuilder = new RequestBuilder();
    }

    @When("User performs GET workspace operation")
    public void user_performs_GET_workspace_operation() {
        response = requestBuilder.sendGET_WORKSPACE(token);
    }

    @Then("User is able to see the response with workspace details")
    public void user_is_able_to_see_the_response_with_workspace_details() {
        response.then()
                .log()
                .all()
                .body("data[0].name", is(workspace.getName()))
                .body("data[0].gid", is(workspace.getGid()))
                .body("data[0].resource_type", is(workspace.getResource_type()))
                .statusCode(200);
        response = null;
        logger.info("Validation pass");
    }

    @Given("I have a new project object")
    public void i_have_a_new_project_object() {
        requestBuilder = new RequestBuilder();
    }

    @When("User perform asana POST project")
    public void user_perform_asana_POST_project() {
        File json = new File("src/main/java/testData/create_project.json");
        response = requestBuilder.sendPOST_CREATE_PROJECT(token, json);
    }

    @Then("User is able to see response with new project")
    public void user_is_able_to_see_response_with_new_project() {
        response.then()
                .log()
                .all()
                .body("data.owner.name", is("Adrian"))
                .body("data.name", is("Homework new project"))
                .statusCode(201);
        response = null;
        logger.info("Validation pass");
    }
}
