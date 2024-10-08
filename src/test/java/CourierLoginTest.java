import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import model.Courier;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static api.CourierClientApi.*;
import static api.CourierClientApi.createCourierResponse;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.notNullValue;


public class CourierLoginTest extends CourierBaseTest {
    private String LOGIN = "ninja"+ LocalDateTime.now().toString();
    private String PASSWORD = "1234"+ LocalDateTime.now().toString();
    private String FIRSTNAME = "ninja"+ LocalDateTime.now().toString() + "name";
    private Courier testCourier;
    //Тест создает курьера для последующего входа
    @Before
    public void createCourier() {
        courier = new Courier(LOGIN, PASSWORD, FIRSTNAME);
        createCourierResponse(courier);
    }

    @Test
    @DisplayName("Логин валидного курьера") // имя теста
    @Description("Попытка входа с валидными данными")
    public void loginValidCourierTest() {
        testCourier = new Courier(LOGIN, PASSWORD);
        loginCourierResponse(testCourier)
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue());
    }
    @Test
    @DisplayName("Попытка входа с неверным логином") // имя теста
    public void loginWrongLoginTest() {
        testCourier = new Courier("WrongLogin", PASSWORD);
        loginCourierResponse(testCourier)
                .then()
                .assertThat()
                .statusCode(SC_NOT_FOUND);
    }
    @Test
    @DisplayName("Попытка входа с неверным паролем") // имя теста

    public void loginWrongPasswordTest() {
        testCourier = new Courier(LOGIN, "WrongPass");
        loginCourierResponse(testCourier)
                .then()
                .assertThat()
                .statusCode(SC_NOT_FOUND);
    }
    @Test
    @DisplayName("Попытка входа с пустым логином") // имя теста

    public void loginEmptyLoginTest() {
        testCourier = new Courier("", PASSWORD);
        loginCourierResponse(testCourier)
                .then()
                .assertThat()
                .statusCode(SC_BAD_REQUEST);
    }
    @Test
    @DisplayName("Попытка входа с пустым паролем") // имя теста
    public void loginEmptyPasswordTest() {
        testCourier = new Courier(LOGIN, "");
        loginCourierResponse(testCourier)
                .then()
                .assertThat()
                .statusCode(SC_BAD_REQUEST);
    }

}
