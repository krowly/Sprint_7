import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;
import static test.data.OrderData.ORDERS;
import static api.OrderClientApi.createOrderApi;

import java.util.ArrayList;

@RunWith(Parameterized.class)
public class OrderCreationTest {

    private Order order;

    public OrderCreationTest(Order order) {

        this.order = order;
    }
    @Parameterized.Parameters
    public static Object[][] data() {
        Object[][] OO = new Object[ORDERS.length][1];
        int counter = 0;
        for (Order o : ORDERS) {
            OO[counter][0] = o;
            counter++;
        }
        return OO;
    }
    @Test
    @DisplayName("Создание валидных заказа")
    @Description("Данные лежат в массиве Orders, проверяются разные цвета.")
    public void createOrder() {
        createOrderApi(order).then().assertThat().statusCode(201).body("track", notNullValue());;
    }

}


