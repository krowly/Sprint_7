package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderClientApi {
    private static final String order = "/api/v1/orders";

    @Step("Создание заказа")
    public static Response createOrderApi(Object body) {
        return given()
        .header("Content-type", "application/json")
        .body(body)
        .when()
        .post(order);
    }
    @Step("Получение списка заказов")
    public static Response getOrderList(){
        return given()
        .header("Content-type", "application/json")
        .when()
        .get(order);
    }
}
