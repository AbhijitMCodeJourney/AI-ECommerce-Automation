package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtil;

public class ApiTest {

    @Test
    public void verifyUserGetApi() {

        Response response =
                ApiUtil.get(
                        "https://jsonplaceholder.typicode.com/users/1"
                );

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertEquals(
                response.jsonPath().getInt("id"),
                1
        );

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Leanne Graham"
        );

        System.out.println("GET API validation passed.");
    }

    @Test
    public void verifyUserPostApi() {

        String requestBody = """
                {
                    "name": "Abhijit Mali",
                    "username": "abhijit",
                    "email": "abhijit@test.com"
                }
                """;

        Response response =
                ApiUtil.post(
                        "https://jsonplaceholder.typicode.com/users",
                        requestBody
                );

        Assert.assertEquals(
                response.getStatusCode(),
                201
        );

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Abhijit Mali"
        );

        Assert.assertEquals(
                response.jsonPath().getString("username"),
                "abhijit"
        );

        Assert.assertEquals(
                response.jsonPath().getString("email"),
                "abhijit@test.com"
        );

        System.out.println("POST API validation passed.");
    }

    @Test
    public void verifyInvalidUserApi() {

        Response response =
                ApiUtil.get(
                        "https://jsonplaceholder.typicode.com/users/9999"
                );

        Assert.assertEquals(
                response.getStatusCode(),
                404
        );

        System.out.println(
                "Negative API validation passed."
        );
    }
}