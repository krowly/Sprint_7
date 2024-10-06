import model.Courier;
import org.junit.After;

import static api.CourierClientApi.deleteCourierResponse;

public class CourierBaseTest extends BaseTest {
    Courier courier;
    @After
    public void clearTestData()
    {
        try {
            deleteCourierResponse(courier);
            System.out.println("Созданный в тесте курьер был удален успешно.");

        } catch (Exception e) {
            System.out.println("В тесте произошла ошибка, возможно курьер не был удален.");
            System.out.println(e.toString());
        }
    }
}
