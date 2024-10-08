package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Courier;

import static io.restassured.RestAssured.given;

public class CourierClientApi {
    private static final String CREATE = "/api/v1/courier";
    private static final String LOGIN = "/api/v1/courier/login";
    private static final String DELETE = "/api/v1/courier/%s";

    private static RequestSpecification reqSpec(Object body) {
        return given()
                .header("Content-type", "application/json")
                .body(body);
    }
    @Step("Создание курьера")
    public static Response createCourierResponse(Object body) {
        return given()
                .spec(reqSpec(body))
                .post(CREATE);
    }
    @Step("Логин курьера")
    public static Response loginCourierResponse(Object body) {
        return given()
                .spec(reqSpec(body))
                .post(LOGIN);
    }

    @Step("Удаление курьера")
    public static Response deleteCourierResponse(Courier courier) {
        int id = loginCourierResponse(courier).getBody().path("id");
        return given()
                .header("Content-type", "application/json")
                .delete(String.format(DELETE,id));
    }
}
