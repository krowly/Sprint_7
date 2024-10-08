import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static api.OrderClientApi.getOrderList;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderListTest extends BaseTest {
    @Test
    @DisplayName("Получение списка заказов")
    public void getOrderListTest() {
        getOrderList().then().assertThat().statusCode(SC_OK).body("orders", notNullValue());;
    }
}
