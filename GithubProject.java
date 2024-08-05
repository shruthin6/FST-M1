package ibm.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GithubProject {
    // SSH Key to test with
    String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDGC7tXpp5hDL8MT7xf3cH3vBLrnBmD2BUK+GihSDAO7Xhq8tdWvIoRdXqqMFNX42LY0y2LY84lxCuHWjE24KXibG3KI3vbka8Tyko1HB0hsbCvdWnJ/6ukEwCQW1GceRtksuWBOoHvDTugcD6INiPTc9Czf45HzPieinUuYn6MWAR2H1COlK93Bgq3Vh1gQeopdPdQW4tqvwb76kJ7utW58KTOW/yE35CfuApuaKZiVjGGAaCK13le/Qv1S6Qzcq5vFTSEx2kyYzF8SZxOaN/0V9r3OuoW8lmy4MMNP5AiUTig55iRLYd67MR4sM2rKtozSlIh1fskSk8ZMz+O9hcRfKUZQCTsJjxXqCDmmIpKZYrdOXGMU0tQutF8izfUt2V3memScfw9bZa7ahzAvIwEpXE13HhE/fwNsvNFD6hTAstWSkB1ppjGJNQMtI+3NHGLHloXkEh7mh30qLaSDYRKGc1Df355I8H3PYfj+9acV7FSwvBctmWQeu4HB3OoZ57HgtP9W/K5HMekt30u1UNi65KWKEUw902V4v4iwUO1fQaNLTjsx+nY3BMxYKWg7hnbS3MuvzOBX1B1yk0ynIF/c1CwF4C5DeGpJFSmv9CURteqLZvEJHrCQybeVL7AOR2VaRvNSXCb/nBblq/gsSuPXinGV/7PMropvXiDG9O3";
    int sshKeyId;
    // Request specification
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization", "token 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").
            addHeader("Content-Type", "application/json").
            build();

    // Response Specification
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).
            expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).
            build();

    @Test(priority = 1)
    public void postRequestTest() {
        // Path: https://api.github.com/user/keys
        // Request body
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        // Generate response
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        // Extract the id
        sshKeyId = response.then().extract().path("id");

        // Assertions
        response.then().statusCode(201).spec(responseSpec);
    }

    @Test(priority = 2)
    public void getRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().get("/{keyId}").
        then().statusCode(200).spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().delete("/{keyId}").
        then().statusCode(204).time(lessThan(3000L));
    }

}
