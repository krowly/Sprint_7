import api.CourierClientApi;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import model.Courier;
import org.junit.Before;
import io.restassured.*;
import org.junit.Test;
import static api.CourierClientApi.*;
import static api.CourierClientApi.createCourierResponse;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.time.LocalDateTime;

public class CourierLoginTest {
    private final String login = "ninja"+ LocalDateTime.now().toString();
    private final String password = "1234"+ LocalDateTime.now().toString();
    private final String firstName = "ninja"+ LocalDateTime.now().toString() + "name";
    @Before
    public void createCourier() {
        System.out.println();createCourierResponse(new Courier(login, password, password));
    }

    @Test
    @DisplayName("Логин валидного курьера") // имя теста
    @Description("Тест создает курьера на сайте и впоследствии заходит в него.")
    public void loginCourierTest1() {
        Courier courier = new Courier(login, password);
        loginCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", notNullValue());

    }
    @Test
    @DisplayName("Попытка входа с неверным логином") // имя теста
    public void loginCourierTest2() {
        Courier courier = new Courier("wronglogin", password);
        loginCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(404);
    }
    @Test
    @DisplayName("Попытка входа с неверным паролем") // имя теста

    public void loginCourierTest3() {
        Courier courier = new Courier(login, "wrongpass");
        loginCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(404);
    }
    @Test
    @DisplayName("Попытка входа с пустым паролем") // имя теста

    public void loginCourierTest4() {
        Courier courier = new Courier(login, "");
        loginCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(400);
    }
    @Test
    @DisplayName("Попытка входа с пустым логином") // имя теста

    public void loginCourierTest5() {
        Courier courier = new Courier("", password);
        loginCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(400);
    }
}
