package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CourierClientApi {
    private static final String create = "/api/v1/courier";
    private static final String login = "/api/v1/courier/login";

    private static RequestSpecification reqSpec(Object body) {
        return given()
                .header("Content-type", "application/json")
                .body(body);
    }

    public static Response createCourierResponse(Object body) {
        return given()
                .spec(reqSpec(body))
                .post(create);
    }
    public static Response loginCourierResponse(Object body) {
        return given()
                .spec(reqSpec(body))
                .post(login);
    }
}
