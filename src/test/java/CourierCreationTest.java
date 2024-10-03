import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import model.Courier;
import org.junit.Test;
import static api.CourierClientApi.*;
import java.time.LocalDateTime;
import static org.hamcrest.Matchers.equalTo;


public class CourierCreationTest extends BaseTest {
    private final String login = "ninja"+ LocalDateTime.now().toString();
    private final String password = "1234"+ LocalDateTime.now().toString();
    private final String firstName = "ninja"+ LocalDateTime.now().toString() + "name";

    @Test
    @DisplayName("Создание валидного курьера") // имя теста
    @Description("Данные генерируется с использованием даты.")
    public void createCourierTest() {
        Courier courier = new Courier(login, password, firstName);

        createCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(201)
                .body("ok", equalTo(true));
    }
    @Test
    @DisplayName("Создание валидного курьера дважды") // имя теста
    @Description("Тест должен возвращать код 409.")
    public void createCourierTwiceTest() {
        Courier courier = new Courier(login, password, firstName);
        createCourierResponse(courier);
        createCourierResponse(courier)
                .then()
                .assertThat()
                .statusCode(409);
    }
}
