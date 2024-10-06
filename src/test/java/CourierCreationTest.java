import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import model.Courier;
import org.junit.Test;
import java.time.LocalDateTime;

import static api.CourierClientApi.*;
import static org.apache.http.HttpStatus.SC_CONFLICT;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.equalTo;

public class CourierCreationTest extends CourierBaseTest {
    private final String LOGIN = "ninja"+ LocalDateTime.now().toString();
    private final String PASSWORD = "1234"+ LocalDateTime.now().toString();
    private final String FIRSTNAME = "ninja"+ LocalDateTime.now().toString() + "name";
    @Test
    @DisplayName("Создание валидного курьера") // имя теста
    @Description("Данные генерируется с использованием даты.")
    public void createCourierTest() {
        courier = new Courier(LOGIN, PASSWORD, FIRSTNAME);
        createCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
    }
    @Test
    @DisplayName("Создание валидного курьера дважды") // имя теста
    @Description("Тест должен возвращать код 409.")
    public void createCourierTwiceTest() {
        courier = new Courier(LOGIN, PASSWORD, FIRSTNAME);
        createCourierResponse(courier);
        createCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(SC_CONFLICT);
    }
}