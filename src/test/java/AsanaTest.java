import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class AsanaTest {

    @Test
    public void shouldGetWorkspaces() {
        when()
                .get("https://app.asana.com/api/1.0/workspaces/").
                then()
                .statusCode(200);
    }
}
