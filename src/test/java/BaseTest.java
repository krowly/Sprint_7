import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest {
    @Before
    public void setup() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
