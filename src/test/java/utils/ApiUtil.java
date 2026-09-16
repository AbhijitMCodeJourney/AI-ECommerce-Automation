package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtil {

    public static Response get(String endpoint) {

        return given()
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint, String requestBody) {

        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(endpoint);
    }
}